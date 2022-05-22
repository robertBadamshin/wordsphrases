package com.app.wordsphrases.add_word_impl.presentation.select_translation_fragment

import android.content.res.ColorStateList
import android.os.Bundle
import android.view.*
import android.widget.*
import androidx.core.view.*
import com.app.wordsphrases.add_word_impl.R
import com.app.wordsphrases.add_word_impl.di.AddWordParentComponent
import com.app.wordsphrases.add_word_impl.presentation.ui.model.*
import com.app.wordsphrases.core_ui.view.dpToPx
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import java.util.*

private const val addWordComponentUuidKey = "addWordComponentUuid"

class SelectTranslationFragment : MvpAppCompatFragment(), SelectTranslationView {

    private val presenter by moxyPresenter {
        val uuid = requireArguments().getSerializable(addWordComponentUuidKey) as? UUID
            ?: throw IllegalStateException("addWordComponent Uuid should be presented")

        val addWordComponent = AddWordParentComponent.get().requireAddWordComponent(uuid)
        return@moxyPresenter addWordComponent.selectTranslationPresenter
    }

    private lateinit var arrowBackImageView: ImageView
    private lateinit var wordTextView: TextView

    private lateinit var fabAddWord: ExtendedFloatingActionButton
    private lateinit var translationLinearLayout: LinearLayout

    private val whiteColor by lazy { requireContext().getColor(android.R.color.white) }
    private val disabledColor by lazy { requireContext().getColor(R.color.white_38) }

//    // TODO cut image
//    private val takePhoto = registerForActivityResult(
//        ActivityResultContracts.TakePicturePreview()
//    ) { bitmap ->
//        if (bitmap == null) {
//            return@registerForActivityResult
//        }
//
//        val image = WordImage.BitmapWordImage(bitmap)
//        presenter.onImageSelected(image)
//    }
//
//    // TODO cut image
//    private val pickPhoto = registerForActivityResult(
//        ActivityResultContracts.GetContent()
//    ) { uri ->
//        if (uri == null) {
//            return@registerForActivityResult
//        }
//
//        val image = WordImage.FileWordImage(uri)
//        presenter.onImageSelected(image)
//    }

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

        ViewCompat.setOnApplyWindowInsetsListener(view) { _, windowInsets ->
            val insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.updatePadding(top = insets.top, bottom = insets.bottom)

            return@setOnApplyWindowInsetsListener windowInsets
        }
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

    override fun setDoneButtonEnabled() {
        val colorStateList = ColorStateList.valueOf(whiteColor)
        fabAddWord.iconTint = colorStateList
        fabAddWord.setTextColor(colorStateList)
        fabAddWord.isClickable = true
    }

    override fun setDoneButtonDisabled() {
        val colorStateList = ColorStateList.valueOf(disabledColor)
        fabAddWord.iconTint = colorStateList
        fabAddWord.setTextColor(colorStateList)
        fabAddWord.isClickable = false
    }

    override fun setWordToMargin(uiModel: MarginUiModel) {
        wordTextView.updateLayoutParams<ViewGroup.MarginLayoutParams> {
            topMargin = uiModel.margin.dpToPx()
        }
    }

    override fun showToastMessage(messageRes: Int) {
        Toast.makeText(requireContext(), messageRes, Toast.LENGTH_SHORT).show()
    }

    //    private fun dispatchTakePicture() {
//        takePhoto.launch(null)
//    }
//
//    private fun dispatchPickPicture() {
//        pickPhoto.launch("image/*")
//    }

    companion object {

        fun newInstance(uuid: UUID): SelectTranslationFragment {
            val arguments = Bundle().apply {
                putSerializable(addWordComponentUuidKey, uuid)
            }

            return SelectTranslationFragment().apply {
                setArguments(arguments)
            }
        }
    }
}