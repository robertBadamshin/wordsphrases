package com.app.wordsphrases.dictionary_impl.presentation

import android.os.Bundle
import android.view.*
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.*
import com.app.wordsphrases.core_ui.view.configureTopInsets
import com.app.wordsphrases.dictionary_impl.R
import com.app.wordsphrases.dictionary_impl.di.DictionaryComponent
import com.app.wordsphrases.dictionary_impl.presentation.adapter.WordsAdapter
import com.app.wordsphrases.dictionary_impl.presentation.ui.WordUiModel
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class DictionaryFragment : MvpAppCompatFragment(), DictionaryView {

    private val dictionaryPresenter by moxyPresenter {
        DictionaryComponent.get().dictionaryPresenter
    }

    private lateinit var wordsRecyclerView: RecyclerView

    private val wordsAdapter by lazy {
        WordsAdapter(
            onWordClick = { wordId ->
                dictionaryPresenter.onWordClick(wordId)
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

        wordsRecyclerView = view.findViewById(R.id.recycler_view_words)

        val layoutManager = LinearLayoutManager(requireContext())
        wordsRecyclerView.layoutManager = layoutManager
        wordsRecyclerView.adapter = wordsAdapter

        val itemDecorator = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        val decoratorDrawable = ContextCompat.getDrawable(
            requireContext(),
            R.drawable.drawable_words_separator
        )!!
        itemDecorator.setDrawable(decoratorDrawable)
        wordsRecyclerView.addItemDecoration(itemDecorator)

        view.configureTopInsets()
    }

    override fun setWords(uiModels: List<WordUiModel>) {
        wordsAdapter.items = uiModels
    }
}