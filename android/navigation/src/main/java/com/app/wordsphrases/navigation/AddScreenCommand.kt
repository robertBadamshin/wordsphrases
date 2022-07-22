package com.app.wordsphrases.navigation

import ru.terrakok.cicerone.android.support.SupportAppScreen
import ru.terrakok.cicerone.commands.Command

class AddScreenCommand(
    val screen: SupportAppScreen,
    val screenFragmentAnimation: ScreenFragmentAnimation = ScreenFragmentAnimation.Default,
) : Command