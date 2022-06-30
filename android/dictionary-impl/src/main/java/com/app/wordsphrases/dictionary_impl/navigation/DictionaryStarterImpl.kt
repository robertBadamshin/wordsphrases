package com.app.wordsphrases.dictionary_impl.navigation

import androidx.fragment.app.Fragment
import com.app.wordsphrases.dictionary_api.DictionaryStarter
import com.app.wordsphrases.dictionary_impl.presentation.DictionaryFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen
import javax.inject.Inject

class DictionaryStarterImpl @Inject constructor(

) : DictionaryStarter {

    override fun getScreen(): SupportAppScreen {
        return object : SupportAppScreen() {

            override fun getFragment(): Fragment {
                return DictionaryFragment()
            }

            override fun getScreenKey(): String {
                return DictionaryFragment::class.java.simpleName
            }
        }
    }

}