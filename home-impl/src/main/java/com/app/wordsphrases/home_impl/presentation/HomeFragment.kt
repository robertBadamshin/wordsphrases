package com.app.wordsphrases.home_impl.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.wordsphrases.home_impl.R
import com.app.wordsphrases.navigation.MainRouter
import com.app.wordsphrases.navigation.NavigationScreen
import com.app.wordsphrases.home_impl.di.HomeComponent
import com.google.android.material.floatingactionbutton.FloatingActionButton
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class HomeFragment : MvpAppCompatFragment(), HomeView {

    private val homePresenter by moxyPresenter { HomeComponent.get().homePresenter }

    private lateinit var addWordButton: FloatingActionButton

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        addWordButton = view.findViewById(R.id.floating_button_add_word)
        addWordButton.setOnClickListener { homePresenter.openAddWord() }
    }

    override fun openScreen(screen: NavigationScreen) {
        (requireActivity() as MainRouter).startScreen(screen)
    }

    override fun setHomeScreen(screen: NavigationScreen) {
        start(screen)
    }

    private fun start(screen: NavigationScreen) {
        childFragmentManager.beginTransaction()
            .add(R.id.fragment_container_home, screen.fragment)
            .addToBackStack("tempKey")
            .commit()
    }
}