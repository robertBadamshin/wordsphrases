package com.app.wordsphrases.home_impl.presentation

import com.app.wordsphrases.home_api.HomeNavigationQualifier
import com.app.wordsphrases.stories_api.StoriesStarter
import com.wordphrases.Platform
import com.wordphrases.data.repository.FirebaseRepository
import com.wordphrases.database.createDatabase
import kotlinx.coroutines.launch
import moxy.*
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class HomePresenter @Inject constructor(
    private val storiesStarter: StoriesStarter,
    @HomeNavigationQualifier private val router: Router,
) : MvpPresenter<HomeView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        presenterScope.launch {
            FirebaseRepository().getListFromFirebase()
        }

        val screen = storiesStarter.getScreen()
        router.newRootScreen(screen)
    }
}