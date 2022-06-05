package com.app.wordsphrases.select_language_impl.presentation

import android.animation.*
import android.content.res.ColorStateList
import android.os.Bundle
import android.view.*
import android.widget.ImageView
import androidx.annotation.AttrRes
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.*
import com.app.wordsphrases.core_ui.view.resolveColorInt
import com.app.wordsphrases.select_language_impl.R
import com.app.wordsphrases.select_language_impl.di.SelectLanguageComponent
import com.app.wordsphrases.select_language_impl.presentation.ui.adapter.LanguagesAdapter
import com.app.wordsphrases.select_language_impl.presentation.ui.model.LanguageUiModel
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter


class SelectLanguageFragment : MvpAppCompatFragment(), SelectLanguageView {

    private val selectLanguagePresenter by moxyPresenter {
        SelectLanguageComponent.get().selectLanguagePresenter
    }

    private lateinit var crossImageView: ImageView
    private lateinit var headerView: View
    private lateinit var languagesRecyclerView: RecyclerView

    private val valueHeaderColorAnimatorListener by lazy {
        ValueAnimator.AnimatorUpdateListener { valueAnimator ->
            val animatedColor = valueAnimator.animatedValue as Int
            headerView.backgroundTintList = ColorStateList.valueOf(animatedColor)
        }
    }
    private var headerColorAnimator: ValueAnimator? = null

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
        headerView = view.findViewById(R.id.container_header_select_language)
        languagesRecyclerView = view.findViewById(R.id.recycler_view_languages_select_language)

        val layoutManager = LinearLayoutManager(requireContext())
        languagesRecyclerView.layoutManager = layoutManager
        languagesRecyclerView.adapter = languagesAdapter

        val scrollListener = object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)

                selectLanguagePresenter.onScrollStateChanged(
                    layoutManager.findFirstCompletelyVisibleItemPosition()
                )
            }
        }
        languagesRecyclerView.addOnScrollListener(scrollListener)

        val itemDecorator = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        val decoratorDrawable = ContextCompat.getDrawable(
            requireContext(),
            R.drawable.drawable_language_separator
        )!!
        itemDecorator.setDrawable(decoratorDrawable)
        languagesRecyclerView.addItemDecoration(itemDecorator)
    }

    override fun showLanguages(languages: List<LanguageUiModel>) {
        languagesAdapter.items = languages
    }

    override fun startHeaderBackgroundAnimation(@AttrRes targetColorAttr: Int) {
        val colorInt = targetColorAttr.resolveColorInt(requireContext())

        headerColorAnimator?.cancel()
        val newHeaderColorAnimator = ObjectAnimator
            .ofArgb(headerView.backgroundTintList!!.defaultColor, colorInt)
            .setDuration(5000)

        newHeaderColorAnimator.addUpdateListener(valueHeaderColorAnimatorListener)
        headerColorAnimator = newHeaderColorAnimator

        newHeaderColorAnimator.start()
    }
}