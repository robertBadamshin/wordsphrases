package com.app.wordsphrases.select_language_impl.presentation

import android.os.Bundle
import android.view.*
import com.app.wordsphrases.select_language_impl.R
import com.app.wordsphrases.select_language_impl.di.LanguagePairComponent
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class LanguagePairFragment : MvpAppCompatFragment(), LanguagePairView {

    private val storiesPresenter by moxyPresenter { LanguagePairComponent.get().languagePairPresenter }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_languages_pair, container, false)
    }
}