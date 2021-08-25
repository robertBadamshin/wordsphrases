package com.app.wordsphrases.add_word_impl.presentation.add_word_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.app.wordsphrases.add_word_api.WordImage
import com.app.wordsphrases.add_word_impl.R
import com.app.wordsphrases.add_word_impl.di.AddWordComponent
import com.app.wordsphrases.add_word_impl.presentation.ui.model.TranslationUiModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class SelectTranslationFragment : MvpAppCompatFragment(), AddWordView {

    private val presenter by moxyPresenter { AddWordComponent.get().selectTranslationPresenter }

    private lateinit var arrowBackImageView: ImageView
    private lateinit var wordTextView: TextView

    private lateinit var fabAddWord: FloatingActionButton
    private lateinit var translationLinearLayout: LinearLayout

    // TODO cut image
    private val takePhoto = registerForActivityResult(
        ActivityResultContracts.TakePicturePreview()
    ) { bitmap ->
        if (bitmap == null) {
            return@registerForActivityResult
        }

        val image = WordImage.BitmapWordImage(bitmap)
        presenter.onImageSelected(image)
    }

    // TODO cut image
    private val pickPhoto = registerForActivityResult(
        ActivityResultContracts.GetContent()
    ) { uri ->
        if (uri == null) {
            return@registerForActivityResult
        }

        val image = WordImage.FileWordImage(uri)
        presenter.onImageSelected(image)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_select_translation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arrowBackImageView = view.findViewById(R.id.image_view_arrow_back)
        arrowBackImageView.setOnClickListener { requireActivity().onBackPressed() }

        wordTextView = view.findViewById(R.id.text_view_word)

        fabAddWord = view.findViewById(R.id.fab_add_word)
        fabAddWord.setOnClickListener { presenter.onAddWordClicked() }

        translationLinearLayout = view.findViewById(R.id.linear_layout_translations)
    }

    override fun showTranslations(uiModels: List<TranslationUiModel>) {
        val layoutInflater = LayoutInflater.from(requireContext())

        translationLinearLayout.removeAllViews()

        uiModels.forEach { uiModel ->
            val translationItemView = layoutInflater.inflate(R.layout.item_translation, translationLinearLayout, false)

            val checkBox = translationItemView.findViewById<CheckBox>(R.id.check_box_translation_item)
            checkBox.isChecked = uiModel.selected

            checkBox.setOnCheckedChangeListener { _, _ ->
                presenter.onToggleTranslationSelection(uiModel.id)
            }

            val translationText = translationItemView.findViewById<TextView>(R.id.text_view_translation_text)
            translationText.text = uiModel.text

            translationLinearLayout.addView(translationItemView)
        }
    }

    override fun showMessage(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    override fun setWordText(word: String) {
        wordTextView.text = word
    }

    private fun dispatchTakePicture() {
        takePhoto.launch(null)
    }

    private fun dispatchPickPicture() {
        pickPhoto.launch("image/*")
    }
}