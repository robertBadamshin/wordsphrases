package com.app.wordsphrases.stories_api

import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router

interface StoriesApi {

    val storiesStarter: StoriesStarter

    @get:StoriesNavigationQualifier
    val storiesRouter: Router

    @get:StoriesNavigationQualifier
    val storiesNavigatorHolder: NavigatorHolder
}