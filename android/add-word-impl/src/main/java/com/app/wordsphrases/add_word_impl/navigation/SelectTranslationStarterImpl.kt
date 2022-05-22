package com.app.wordsphrases.add_word_impl.navigation

import androidx.fragment.app.Fragment
import com.app.wordsphrases.add_word_api.SelectTranslationStarter
import com.app.wordsphrases.add_word_impl.presentation.select_translation_fragment.SelectTranslationFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen
import java.util.*
import javax.inject.Inject

class SelectTranslationStarterImpl @Inject constructor() : SelectTranslationStarter {

    override fun getScreen(uuid: UUID): SupportAppScreen {
        return object: SupportAppScreen() {

            override fun getScreenKey(): String {
                return SelectTranslationFragment::class.java.simpleName
            }

            override fun getFragment(): Fragment {
                return SelectTranslationFragment.newInstance(uuid)
            }
        }
    }
}