package com.app.wordsphrases.select_language_impl.presentation

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.*
import androidx.core.content.ContextCompat
import androidx.fragment.app.*
import androidx.recyclerview.widget.*
import com.app.wordsphrases.core_ui.view.configureInsets
import com.app.wordsphrases.select_language_impl.R
import com.app.wordsphrases.select_language_impl.di.SelectLanguageComponent
import com.app.wordsphrases.select_language_impl.navigation.init_params.SelectLanguageInitParams
import com.app.wordsphrases.select_language_impl.presentation.ui.adapter.LanguagesAdapter
import com.app.wordsphrases.select_language_impl.presentation.ui.model.LanguageUiModel
import com.wordphrases.domain.entity.language.Language
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import java.io.Serializable

private const val selectLanguageInitParamsKey = "selectLanguageFragmentInitParamsKey"
private const val languageResultKey = "languageResultKey"

class SelectLanguageFragment : MvpAppCompatFragment(), SelectLanguageView {

    private val initParams by lazy {
        requireArguments()
            .getSerializable(selectLanguageInitParamsKey) as? SelectLanguageInitParams
            ?: throw IllegalStateException("initParams should be presented")
    }

    private val selectLanguagePresenter by moxyPresenter {
        SelectLanguageComponent.get().selectLanguagePresenter.apply {
            init(initParams)
        }
    }

    private lateinit var crossImageView: ImageView
    private lateinit var languagesRecyclerView: RecyclerView
    private lateinit var titleTextView: TextView
    private lateinit var requestLanguageButton: Button

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
        requestLanguageButton = view.findViewById(R.id.button_request_language)

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

        requestLanguageButton.setOnClickListener {
            selectLanguagePresenter.onRequestLanguageClick()
        }

        view.configureInsets()
    }

    override fun showLanguages(languages: List<LanguageUiModel>) {
        languagesAdapter.items = languages
    }

    override fun setTitle(titleRes: Int) {
        titleTextView.setText(titleRes)
    }

    override fun setScreenResult(key: String, language: Language) {
        val bundle = getFragmentResultBundle(language)
        setFragmentResult(key, bundle)
    }

    override fun startIntent(intent: Intent) {
        requireContext().startActivity(intent)
    }

    private fun getFragmentResultBundle(language: Language): Bundle {
        val bundle = Bundle()
        bundle.putSerializable(languageResultKey, language as Serializable)
        return bundle
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

        fun getLanguageResultFromBundle(bundle: Bundle): Language {
            return bundle.getSerializable(languageResultKey) as Language
        }
    }
}