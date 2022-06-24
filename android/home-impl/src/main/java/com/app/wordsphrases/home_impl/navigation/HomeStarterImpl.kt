package com.app.wordsphrases.home_impl.navigation

import androidx.fragment.app.Fragment
import com.app.wordsphrases.home_api.HomeStarter
import com.app.wordsphrases.home_impl.presentation.HomeFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen
import javax.inject.Inject

class HomeStarterImpl @Inject constructor() : HomeStarter {

    override fun getScreen(): SupportAppScreen {
        return object : SupportAppScreen() {

            override fun getFragment(): Fragment {
                return HomeFragment()
            }

            override fun getScreenKey(): String {
                return HomeFragment::class.java.simpleName
            }
        }
    }
}