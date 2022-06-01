package com.app.wordsphrases.select_language_impl.presentation

import android.os.Bundle
import android.view.*
import com.app.wordsphrases.home_impl.R
import moxy.MvpAppCompatFragment

// TODO add view interface
class LanguagePairFragment : MvpAppCompatFragment() {

    // TODO add presenter injection

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_languages_pair, container, false)
    }
}