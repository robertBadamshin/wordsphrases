package com.app.wordsphrases.login_impl.routing

import androidx.fragment.app.Fragment
import com.app.wordsphrases.login_impl.presentation.EnterEmailFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class EnterEmailScreen : SupportAppScreen() {

    override fun getFragment(): Fragment {
        return EnterEmailFragment.newInstance()
    }

    override fun getScreenKey(): String {
        return EnterEmailFragment::class.java.simpleName
    }
}