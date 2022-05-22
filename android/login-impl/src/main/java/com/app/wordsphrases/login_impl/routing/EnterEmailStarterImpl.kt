package com.app.wordsphrases.login_impl.routing

import com.app.wordsphrases.login_api.EnterEmailStarter
import ru.terrakok.cicerone.android.support.SupportAppScreen
import javax.inject.Inject

class EnterEmailStarterImpl @Inject constructor() : EnterEmailStarter {

    override fun getScreen(): SupportAppScreen {
        return EnterEmailScreen()
    }
}