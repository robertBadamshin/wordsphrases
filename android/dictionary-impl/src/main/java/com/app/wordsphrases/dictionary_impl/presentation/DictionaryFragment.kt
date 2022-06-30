package com.app.wordsphrases.dictionary_impl.presentation

import android.os.Bundle
import android.view.*
import android.widget.*
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.*
import com.app.wordsphrases.core_ui.view.configureInsets
import com.app.wordsphrases.dictionary_impl.R
import com.app.wordsphrases.dictionary_impl.di.DictionaryComponent
import com.app.wordsphrases.select_language_impl.R
import com.app.wordsphrases.select_language_impl.di.SelectLanguageComponent
import com.app.wordsphrases.select_language_impl.navigation.init_params.SelectLanguageInitParams
import com.app.wordsphrases.select_language_impl.presentation.ui.adapter.LanguagesAdapter
import com.app.wordsphrases.select_language_impl.presentation.ui.model.LanguageUiModel
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

private const val selectLanguageInitParamsKey = "selectLanguageFragmentInitParamsKey"

class DictionaryFragment : MvpAppCompatFragment(), DictionaryView {

    private val selectLanguagePresenter by moxyPresenter {
        DictionaryComponent.get().dictionaryPresenter
    }

    private lateinit var wordsRecyclerView: RecyclerView

    private val languagesAdapter by lazy {
        LanguagesAdapter(
            onLanguageSelected = { language ->
                selectLanguagePresenter.onLanguageSelected(language)
            }
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dictionary, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        crossImageView = view.findViewById(R.id.image_view_close_select_language)
        crossImageView.setOnClickListener { requireActivity().onBackPressed() }

        wordsRecyclerView = view.findViewById(R.id.recycler_view_languages_select_language)

        val layoutManager = LinearLayoutManager(requireContext())
        wordsRecyclerView.layoutManager = layoutManager
        wordsRecyclerView.adapter = languagesAdapter

        val itemDecorator = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        val decoratorDrawable = ContextCompat.getDrawable(
            requireContext(),
            R.drawable.drawable_language_separator
        )!!
        itemDecorator.setDrawable(decoratorDrawable)
        wordsRecyclerView.addItemDecoration(itemDecorator)

        titleTextView = view.findViewById(R.id.text_view_title_select_language)

        view.configureInsets()
    }

    override fun showLanguages(languages: List<LanguageUiModel>) {
        languagesAdapter.items = languages
    }

    override fun setTitle(titleRes: Int) {
        titleTextView.setText(titleRes)
    }

    companion object {

        fun newInstance(initParams: SelectLanguageInitParams): Fragment {
            val fragment = DictionaryFragment()
            val arguments = Bundle().apply {
                putSerializable(selectLanguageInitParamsKey, initParams)
            }
            fragment.arguments = arguments
            return fragment
        }
    }
}