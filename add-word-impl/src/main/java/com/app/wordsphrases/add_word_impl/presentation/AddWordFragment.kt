package com.app.wordsphrases.add_word_impl.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.wordsphrases.add_word_impl.R
import com.app.wordsphrases.add_word_impl.di.AddWordComponent
import com.app.wordsphrases.add_word_api.WordImage
import com.app.wordsphrases.add_word_impl.presentation.ui.TranslationsAdapter
import com.app.wordsphrases.add_word_impl.presentation.ui.model.TranslationsViewState
import com.bumptech.glide.Glide
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputLayout
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class AddWordFragment : MvpAppCompatFragment(), AddWordView {

    private val presenter by moxyPresenter { AddWordComponent.get().addWordPresenter }

    private lateinit var arrowBackImageView: ImageView
    private lateinit var translateButton: Button
    private lateinit var translationRecyclerView: RecyclerView
    private lateinit var translationTextInputLayout: TextInputLayout
    private lateinit var translationProgress: ProgressBar
    private lateinit var bottomAppBar: BottomAppBar
    private lateinit var wordImageView: ImageView
    private lateinit var fabAddWord: FloatingActionButton

    private val translationsAdapter by lazy { TranslationsAdapter() }

    private val takePhoto = registerForActivityResult(
        ActivityResultContracts.TakePicturePreview()
    ) { bitmap ->
        if (bitmap == null) {
            return@registerForActivityResult
        }

        val image = WordImage.BitmapWordImage(bitmap)
        presenter.onImageSelected(image)
    }

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
        return inflater.inflate(R.layout.fragment_translation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arrowBackImageView = view.findViewById(R.id.image_view_arrow_back)
        arrowBackImageView.setOnClickListener { requireActivity().onBackPressed() }

        translationTextInputLayout = view.findViewById(R.id.text_input_layout_text_to_translate)

        translateButton = view.findViewById(R.id.button_translate)
        translateButton.setOnClickListener {
            val textToTranslate = translationTextInputLayout.editText?.text.toString()
            presenter.onTranslateClick(textToTranslate)
        }

        translationRecyclerView = view.findViewById(R.id.recycler_view_translations)
        translationRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        translationRecyclerView.adapter = translationsAdapter
        val dividerItemDecoration = DividerItemDecoration(
            requireContext(),
            RecyclerView.VERTICAL,
        )
        translationRecyclerView.addItemDecoration(dividerItemDecoration)

        translationProgress = view.findViewById(R.id.translation_progress)

        bottomAppBar = view.findViewById(R.id.bottom_app_bar_add_word)
        bottomAppBar.setOnMenuItemClickListener { menuItem ->
            val itemId = menuItem.itemId

            when (itemId) {
                R.id.item_take_photo -> dispatchTakePicture()
                R.id.item_pick_photo -> dispatchPickPicture()
                else -> throw IllegalAccessException("no such item")
            }

            return@setOnMenuItemClickListener true
        }

        wordImageView = view.findViewById(R.id.image_view_word_image)

        fabAddWord = view.findViewById(R.id.fab_add_word)
        fabAddWord.setOnClickListener { presenter.onAddWordClicked("wordToTranslate", "translation") }
    }

    override fun showTranslations(viewState: TranslationsViewState) {
        when (viewState) {
            is TranslationsViewState.Success -> {
                translationProgress.isVisible = false
                translationsAdapter.items = viewState.translations
            }
            is TranslationsViewState.Loading -> {
                translationProgress.isVisible = true
            }
            is TranslationsViewState.Error -> {
                translationProgress.isVisible = false
                // show error
            }
            is TranslationsViewState.Empty -> {
                translationProgress.isVisible = false
                translationsAdapter.items = null
            }
        }
    }

    override fun setImage(image: WordImage?) {
        when (image) {
            is WordImage.FileWordImage -> Glide.with(requireContext()).load(image.uri).into(wordImageView)
            is WordImage.BitmapWordImage -> wordImageView.setImageBitmap(image.bitmap)
        }
        wordImageView.isVisible = true
    }

    override fun showMessage(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    private fun dispatchTakePicture() {
        takePhoto.launch(null)
    }

    private fun dispatchPickPicture() {
        pickPhoto.launch("image/*")
    }
}