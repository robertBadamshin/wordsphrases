package com.app.wordsphrases.add_word_impl.presentation.enter_word_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowInsets
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import androidx.core.view.updatePadding
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.wordsphrases.add_word_impl.R
import com.app.wordsphrases.add_word_impl.di.AddWordComponent
import com.app.wordsphrases.add_word_api.WordImage
import com.app.wordsphrases.add_word_impl.presentation.ui.TranslationsAdapter
import com.app.wordsphrases.add_word_impl.presentation.ui.model.TranslationsViewState
import com.app.wordsphrases.navigation.MainRouter
import com.bumptech.glide.Glide
import com.google.android.material.floatingactionbutton.FloatingActionButton
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class EnterWordFragment : MvpAppCompatFragment(), EnterWordView {

    private val presenter by moxyPresenter { AddWordComponent.get().enterWordPresenter }

    private lateinit var arrowCloseImageView: ImageView
    private lateinit var textToTranslateEditText: EditText
    private lateinit var translateWordFab: FloatingActionButton

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

        ViewCompat.setOnApplyWindowInsetsListener(view) { _, windowInsets ->
            val sysWindow = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.updatePadding(top = sysWindow.top)
            windowInsets
        }
    }


    override fun closeScreen() {
        (requireActivity() as MainRouter).closeScreen(this)
    }

    override fun showMessage(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }
}