package com.app.wordsphrases.add_word_impl.presentation.enter_word_screen

import android.content.res.ColorStateList
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.activity.OnBackPressedCallback
import androidx.core.graphics.Insets
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsAnimationCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import androidx.core.view.updatePadding
import androidx.core.widget.doAfterTextChanged
import com.app.wordsphrases.add_word_impl.R
import com.app.wordsphrases.add_word_impl.di.AddWordParentComponent
import com.app.wordsphrases.core_ui.view.showKeyboard
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class EnterWordFragment : MvpAppCompatFragment(), EnterWordView {

    private val presenter by moxyPresenter {
        val addWordComponent = AddWordParentComponent.get().requirePopupAddWordComponent()
        return@moxyPresenter addWordComponent.enterWordPresenter
    }

    private lateinit var arrowCloseImageView: ImageView
    private lateinit var textToTranslateEditText: EditText
    private lateinit var translateWordFab: FloatingActionButton
    private lateinit var translationProgressBar: ProgressBar

    private val whiteColor by lazy { requireContext().getColor(android.R.color.white) }
    private val disabledColor by lazy { requireContext().getColor(R.color.white_38) }

    private val backPressedCallback = object : OnBackPressedCallback(true) {

        override fun handleOnBackPressed() {
            presenter.onBackPressed()
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requireActivity().onBackPressedDispatcher.addCallback(this, backPressedCallback)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_enter_word, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arrowCloseImageView = view.findViewById(R.id.image_view_close_enter_word)
        arrowCloseImageView.setOnClickListener { requireActivity().onBackPressed() }

        textToTranslateEditText = view.findViewById(R.id.edit_text_enter_word)

        translateWordFab = view.findViewById(R.id.fab_translate_word_enter_word)
        translateWordFab.setOnClickListener {
            val textToTranslate = textToTranslateEditText.text.toString()
            presenter.onTranslateClick(textToTranslate)
        }

        textToTranslateEditText.doAfterTextChanged { editableText ->
            presenter.onWordChanged(editableText.toString())
        }

        translationProgressBar = view.findViewById(R.id.translation_progress_enter_word)

        presenter.onWordChanged(textToTranslateEditText.text.toString())

        configureInsets(view)
    }

    override fun onResume() {
        super.onResume()
        presenter.showKeyboard()
    }

    override fun showMessage(messageRes: Int) {
        Snackbar
            .make(requireActivity().findViewById(android.R.id.content), messageRes, Snackbar.LENGTH_SHORT)
            .setAnchorView(translateWordFab)
            .show()
    }

    override fun showTranslationProgress() {
        translationProgressBar.isVisible = true
    }

    override fun hideTranslationProgress() {
        translationProgressBar.isVisible = false
    }

    override fun setTranslateButtonEnabled() {
        translateWordFab.imageTintList = ColorStateList.valueOf(whiteColor)
        translateWordFab.isClickable = true
    }

    override fun setTranslateButtonDisabled() {
        translateWordFab.imageTintList = ColorStateList.valueOf(disabledColor)
        translateWordFab.isClickable = false
    }

    override fun showTranslateButton() {
        translateWordFab.isVisible = true
    }

    override fun hideTranslateButton() {
        translateWordFab.isVisible = false
    }

    override fun showKeyboard() {
        textToTranslateEditText.showKeyboard()
    }

    private fun configureInsets(view: View) {
        ViewCompat.setOnApplyWindowInsetsListener(view) { _, windowInsets ->
            val screenInsets =
                windowInsets.getInsets(WindowInsetsCompat.Type.systemBars() or WindowInsetsCompat.Type.ime())
            view.updatePadding(top = screenInsets.top, bottom = screenInsets.bottom)

            return@setOnApplyWindowInsetsListener windowInsets
        }

        val insetsCallback = object : WindowInsetsAnimationCompat.Callback(DISPATCH_MODE_STOP) {

            override fun onProgress(
                insets: WindowInsetsCompat,
                runningAnimations: MutableList<WindowInsetsAnimationCompat>
            ): WindowInsetsCompat {
                val screenInsets = getScreenInsets(insets)
                view.updatePadding(bottom = screenInsets.bottom)
                return insets
            }
        }

        ViewCompat.setWindowInsetsAnimationCallback(view, insetsCallback)
    }

    private fun getScreenInsets(insets: WindowInsetsCompat): Insets {
        return insets.getInsets(WindowInsetsCompat.Type.ime() or WindowInsetsCompat.Type.systemBars())
    }
}