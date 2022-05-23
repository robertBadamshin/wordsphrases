package com.app.wordsphrases.home_impl.presentation

import android.util.Log
import com.app.wordsphrases.home_api.HomeNavigationQualifier
import com.app.wordsphrases.stories_api.StoriesStarter
import kotlinx.coroutines.launch
import moxy.*
import ru.terrakok.cicerone.Router
import java.util.*
import javax.inject.Inject

class HomePresenter @Inject constructor(
    private val storiesStarter: StoriesStarter,
    @HomeNavigationQualifier private val router: Router,
) : MvpPresenter<HomeView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        val screen = storiesStarter.getScreen()
        router.newRootScreen(screen)
    }
}