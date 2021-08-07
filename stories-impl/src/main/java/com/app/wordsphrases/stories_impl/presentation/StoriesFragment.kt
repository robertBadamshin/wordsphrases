package com.app.wordsphrases.stories_impl.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.app.wordsphrases.navigation.MainRouter
import com.app.wordsphrases.navigation.NavigationScreen
import com.app.wordsphrases.stories_impl.R
import com.app.wordsphrases.stories_impl.di.StoriesComponent
import com.app.wordsphrases.stories_impl.ui.model.WordUiModel
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class StoriesFragment : MvpAppCompatFragment(), StoriesView {

    private val storiesPresenter by moxyPresenter { StoriesComponent.get().storiesPresenter }

    private lateinit var wordTextView: TextView
    private lateinit var translationTextView: TextView
    private lateinit var containerView: View

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
    }

    override fun openScreen(screen: NavigationScreen) {
        (requireActivity() as MainRouter).startScreen(screen)
    }

    override fun showWord(uiModel: WordUiModel) {
        wordTextView.text = uiModel.word
        translationTextView.text = uiModel.translation
    }
}