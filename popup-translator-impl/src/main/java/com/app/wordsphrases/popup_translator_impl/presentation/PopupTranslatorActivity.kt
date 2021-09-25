package com.app.wordsphrases.popup_translator_impl.presentation

import android.content.Intent
import android.content.res.ColorStateList
import android.os.Bundle
import android.widget.ProgressBar
import androidx.core.view.isVisible
import com.app.wordsphrases.popup_translator_impl.R
import com.app.wordsphrases.popup_translator_impl.di.PopupTranslatorComponent
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter


class PopupTranslatorActivity : MvpAppCompatActivity(), PopupTranslatorView {

    private val popupTranslatorPresenter by moxyPresenter { PopupTranslatorComponent.get().popupTranslatorPresenter }

    private lateinit var translateWordFab: FloatingActionButton
    private lateinit var translationProgressBar: ProgressBar

    private val whiteColor by lazy { getColor(android.R.color.white) }
    private val disabledColor by lazy { getColor(R.color.white_38) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_popup_translator)
        translateWordFab = findViewById(R.id.fab_translate_word_enter_word)
        translationProgressBar = findViewById(R.id.translation_progress)

        initWordText()
    }

    private fun initWordText() {
        val wordText = intent
            .getCharSequenceExtra(Intent.EXTRA_PROCESS_TEXT)
            ?.toString()

        if (wordText == null) {
            throw IllegalArgumentException("extraText should be presented")
        }

        popupTranslatorPresenter.onSetWordText(wordText)
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

    override fun showMessage(messageRes: Int) {
        Snackbar
            .make(findViewById(android.R.id.content), messageRes, Snackbar.LENGTH_SHORT)
            .setAnchorView(translateWordFab)
            .show()
    }

}