package com.app.wordsphrases.presentation

import android.os.Bundle
import android.view.View
import androidx.core.view.WindowCompat
import com.app.wordsphrases.R
import com.app.wordsphrases.core.BaseWordsPhrasesApp.Companion.appComponent
import com.app.wordsphrases.di.AppComponentImpl
import com.app.wordsphrases.navigation.NavigationScreen
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter

class MainActivity : MvpAppCompatActivity(), MainView {

    private val mainPresenter by moxyPresenter {
        (appComponent as AppComponentImpl).mainPresenter
    }

    private lateinit var mainContainer: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainContainer = findViewById(R.id.main_container)

        WindowCompat.setDecorFitsSystemWindows(window, false)
    }

    override fun start(screen: NavigationScreen) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, screen.fragment)
            .commit()
    }
}