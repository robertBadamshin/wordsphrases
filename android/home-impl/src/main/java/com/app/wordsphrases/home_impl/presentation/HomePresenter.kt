package com.app.wordsphrases.home_impl.presentation

import android.util.Log
import com.app.wordsphrases.home_api.HomeNavigationQualifier
import com.app.wordsphrases.stories_api.StoriesStarter
import com.wordphrases.data.repository.*
import com.wordphrases.db.WordDbEntity
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
            //FirebaseRepository().getListFromFirebase()
            try {
//                val dataSource = WordLocalDataSource()
//                val dbEntity = WordDbEntity(
//
//                )
//                dataSource.insert()

                //repo.putWords()
                //repo.getWords()
            } catch (ex: Exception) {
                Log.d("das", "$ex")
            }
        }

        val screen = storiesStarter.getScreen()
        router.newRootScreen(screen)
    }
}