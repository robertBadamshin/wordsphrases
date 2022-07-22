package com.app.wordsphrases.navigation

import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.support.SupportAppScreen

class WordsPhrasesRouter : Router() {

    fun addScreen(
        screen: SupportAppScreen,
        screenFragmentAnimation: ScreenFragmentAnimation = ScreenFragmentAnimation.Default,
    ) {
        val command = AddScreenCommand(
            screen = screen,
            screenFragmentAnimation = screenFragmentAnimation,
        )
        executeCommands(command)
    }
}
