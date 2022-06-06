package com.app.wordsphrases.select_language_impl.presentation

import android.os.Bundle
import android.view.*
import android.widget.*
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.*
import com.app.wordsphrases.core_ui.view.configureInsets
import com.app.wordsphrases.select_language_impl.R
import com.app.wordsphrases.select_language_impl.di.SelectLanguageComponent
import com.app.wordsphrases.select_language_impl.navigation.init_params.SelectLanguageInitParams
import com.app.wordsphrases.select_language_impl.presentation.ui.adapter.LanguagesAdapter
import com.app.wordsphrases.select_language_impl.presentation.ui.model.LanguageUiModel
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

private const val selectLanguageInitParamsKey = "selectLanguageFragmentInitParamsKey"

class SelectLanguageFragment : MvpAppCompatFragment(), SelectLanguageView {

    private val selectLanguageType by lazy {
        val initParams = requireArguments()
            .getSerializable(selectLanguageInitParamsKey) as? SelectLanguageInitParams
            ?: throw IllegalStateException("initParams should be presented")

        initParams.selectLanguageType
    }

    private val selectLanguagePresenter by moxyPresenter {
        SelectLanguageComponent.get().selectLanguagePresenter.apply {
            init(selectLanguageType)
        }
    }

    private lateinit var crossImageView: ImageView
    private lateinit var languagesRecyclerView: RecyclerView
    private lateinit var titleTextView: TextView

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
        return inflater.inflate(R.layout.fragment_select_language, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        crossImageView = view.findViewById(R.id.image_view_close_select_language)
        crossImageView.setOnClickListener { requireActivity().onBackPressed() }

        languagesRecyclerView = view.findViewById(R.id.recycler_view_languages_select_language)

        val layoutManager = LinearLayoutManager(requireContext())
        languagesRecyclerView.layoutManager = layoutManager
        languagesRecyclerView.adapter = languagesAdapter

        val itemDecorator = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        val decoratorDrawable = ContextCompat.getDrawable(
            requireContext(),
            R.drawable.drawable_language_separator
        )!!
        itemDecorator.setDrawable(decoratorDrawable)
        languagesRecyclerView.addItemDecoration(itemDecorator)

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
            val fragment = SelectLanguageFragment()
            val arguments = Bundle().apply {
                putSerializable(selectLanguageInitParamsKey, initParams)
            }
            fragment.arguments = arguments
            return fragment
        }
    }
}