package com.app.wordsphrases.presentation

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.WindowCompat
import com.app.wordsphrases.R
import com.app.wordsphrases.core.BaseWordsPhrasesApp.Companion.appComponent
import com.app.wordsphrases.core.di.MainNavigationQualifier
import com.app.wordsphrases.di.AppComponentImpl
import com.app.wordsphrases.navigation.WordsPhrasesAppNavigator
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import ru.terrakok.cicerone.NavigatorHolder
import javax.inject.Inject

class MainActivity : MvpAppCompatActivity(), MainView {

    private val mainPresenter by moxyPresenter {
        (appComponent as AppComponentImpl).mainPresenter
    }

    private lateinit var mainContainer: View

    @Inject
    @MainNavigationQualifier
    lateinit var navigatorHolder: NavigatorHolder

    private val navigator by lazy {
        WordsPhrasesAppNavigator(this, supportFragmentManager, R.id.fragment_container)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (appComponent as AppComponentImpl).inject(this)


        mainContainer = findViewById(R.id.main_container)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        val intentData = intent?.data
        if (intentData != null) {
            mainPresenter.startEmailLogin(intentData.toString())
        }
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

    override fun showToast(stringRes: Int) {
        Toast.makeText(this, stringRes, Toast.LENGTH_LONG).show()
    }
}