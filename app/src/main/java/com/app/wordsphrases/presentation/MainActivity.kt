package com.app.wordsphrases.presentation

import android.os.Bundle
import com.app.wordsphrases.R
import com.app.wordsphrases.core.BaseWordsPhrasesApp.Companion.appComponent
import com.app.wordsphrases.di.AppComponentImpl
import com.app.wordsphrases.navigation.MainRouter
import com.app.wordsphrases.navigation.NavigationScreen
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter

class MainActivity : MvpAppCompatActivity(), MainView, MainRouter {

    private val mainPresenter by moxyPresenter {
        (appComponent as AppComponentImpl).mainPresenter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun start(screen: NavigationScreen) {
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, screen.fragment)
            .addToBackStack("tempKey")
            .commit()
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

    override fun startScreen(screen: NavigationScreen) {
        start(screen)
    }
}