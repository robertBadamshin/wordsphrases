package com.app.wordsphrases.word_detail_impl.navigation

import androidx.fragment.app.Fragment
import com.app.wordsphrases.word_detail_api.WordDetailStarter
import com.app.wordsphrases.word_detail_impl.presentation.WordDetailsFragment
import com.wordphrases.domain.entity.WordId
import ru.terrakok.cicerone.android.support.SupportAppScreen
import javax.inject.Inject

class WordDetailsStarterImpl @Inject constructor() : WordDetailStarter {

    override fun getScreen(wordId: WordId): SupportAppScreen {
        return object : SupportAppScreen() {

            override fun getFragment(): Fragment {
                return WordDetailsFragment.newInstance(wordId)
            }

            override fun getScreenKey(): String {
                return WordDetailsFragment::class.java.simpleName
            }
        }
    }
}