package com.app.wordsphrases.add_word_impl.presentation.enter_word_screen

import android.content.res.ColorStateList
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.Toast
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsAnimationCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import androidx.core.view.updateLayoutParams
import androidx.core.view.updateMargins
import androidx.core.view.updatePadding
import androidx.core.widget.doAfterTextChanged
import com.app.wordsphrases.add_word_impl.R
import com.app.wordsphrases.add_word_impl.di.AddWordComponent
import com.app.wordsphrases.navigation.MainRouter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class EnterWordFragment : MvpAppCompatFragment(), EnterWordView {

    private val presenter by moxyPresenter { AddWordComponent.get().enterWordPresenter }

    private lateinit var arrowCloseImageView: ImageView
    private lateinit var textToTranslateEditText: EditText
    private lateinit var translateWordFab: FloatingActionButton
    private lateinit var translationProgressBar: ProgressBar

    private val whiteColor by lazy { requireContext().getColor(android.R.color.white) }
    private val disabledColor by lazy { requireContext().getColor(R.color.white_38) }

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

    override fun closeScreen() {
        (requireActivity() as MainRouter).closeScreen(this)
    }

    override fun showMessage(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    override fun showTranslationProgress() {
        translationProgressBar.isVisible = true
    }

    override fun hideTranslationProgress() {
        translationProgressBar.isVisible = false
    }

    override fun setTranslateButtonEnabled() {
        translateWordFab.imageTintList = ColorStateList.valueOf(whiteColor)
    }

    override fun setTranslateButtonDisabled() {
        translateWordFab.imageTintList = ColorStateList.valueOf(disabledColor)
    }

    private fun configureInsets(view: View) {
        ViewCompat.setOnApplyWindowInsetsListener(view) { _, windowInsets ->
            val insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.updatePadding(top = insets.top)
            return@setOnApplyWindowInsetsListener windowInsets
        }

        val insetsCallback = object : WindowInsetsAnimationCompat.Callback(DISPATCH_MODE_STOP) {

            override fun onProgress(
                insets: WindowInsetsCompat,
                runningAnimations: MutableList<WindowInsetsAnimationCompat>
            ): WindowInsetsCompat {
                val keyboardInsets = insets.getInsets(WindowInsetsCompat.Type.ime())
                view.updateLayoutParams<ViewGroup.MarginLayoutParams> {
                    updateMargins(bottom = keyboardInsets.bottom)
                }

                return insets
            }
        }

        ViewCompat.setWindowInsetsAnimationCallback(view, insetsCallback)
    }
}