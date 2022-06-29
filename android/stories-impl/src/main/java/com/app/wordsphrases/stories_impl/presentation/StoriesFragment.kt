package com.app.wordsphrases.stories_impl.presentation

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.*
import androidx.activity.OnBackPressedCallback
import androidx.core.view.*
import androidx.fragment.app.*
import com.app.wordsphrases.core.BaseWordsPhrasesApp
import com.app.wordsphrases.core_ui.view.*
import com.app.wordsphrases.stories_impl.di.StoriesComponent
import com.app.wordsphrases.stories_impl.model.WordUiModel
import com.app.wordsphrases.stories_impl.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.terrakok.cicerone.*
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import ru.terrakok.cicerone.commands.Command

class StoriesFragment : MvpAppCompatFragment(), StoriesView {

    private val storiesPresenter by moxyPresenter { StoriesComponent.get().storiesPresenter }

    private lateinit var wordTextView: TextView
    private lateinit var translationTextView: TextView
    private lateinit var containerView: View
    private lateinit var addWordButton: FloatingActionButton
    private lateinit var feedBackImageView: ImageView

    private val navigatorHolder: NavigatorHolder by lazy { BaseWordsPhrasesApp.appComponent.storiesNavigatorHolder }
    private val navigator: Navigator by lazy {
        object : SupportAppNavigator(
            requireActivity(),
            childFragmentManager,
            R.id.fragment_container_stories
        ) {

            override fun setupFragmentTransaction(
                command: Command?,
                currentFragment: Fragment?,
                nextFragment: Fragment?,
                fragmentTransaction: FragmentTransaction
            ) {
                fragmentTransaction.setCustomAnimations(
                    R.anim.push_left_in_no_alpha,
                    R.anim.push_right_out_no_alpha,
                    R.anim.push_left_in_no_alpha,
                    R.anim.push_right_out_no_alpha
                )

                fragmentTransaction.setReorderingAllowed(true)
            }
        }
    }


    private val backPressedNestedNavigationCallback = object : OnBackPressedCallback(false) {

        override fun handleOnBackPressed() {
            childFragmentManager.popBackStack()
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requireActivity().onBackPressedDispatcher.addCallback(
            this,
            backPressedNestedNavigationCallback
        )

        childFragmentManager.addOnBackStackChangedListener {
            storiesPresenter.onBackStackChanged(childFragmentManager.backStackEntryCount)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_stories, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        wordTextView = view.findViewById(R.id.text_view_word_text_stories)
        translationTextView = view.findViewById(R.id.text_view_translation_text_stories)
        containerView = view.findViewById(R.id.container_stories)
        containerView.setOnClickListener { storiesPresenter.onNextWordClick() }

        addWordButton = view.findViewById(R.id.floating_button_add_word)
        addWordButton.setOnClickListener { storiesPresenter.openEnterWord() }

        feedBackImageView = view.findViewById(R.id.image_view_feedback)
        feedBackImageView.setOnClickListener { storiesPresenter.onSendFeedbackClick() }

        view.configureTopInsets()
    }

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

    override fun showWord(uiModel: WordUiModel) {
        wordTextView.text = uiModel.word
        translationTextView.text = uiModel.translation
    }

    override fun updateBackPressedNestedNavigationEnabled(enabled: Boolean) {
        backPressedNestedNavigationCallback.isEnabled = enabled
    }

    override fun updateAddWordButtonVisible(visible: Boolean) {
        addWordButton.isVisible = visible
    }

    override fun startEmailActivity(intent: Intent) {
        startActivity(intent)
    }
}