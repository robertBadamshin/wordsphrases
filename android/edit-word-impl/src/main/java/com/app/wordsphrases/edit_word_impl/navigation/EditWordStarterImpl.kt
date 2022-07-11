package com.app.wordsphrases.edit_word_impl.navigation

import androidx.fragment.app.Fragment
import com.app.wordsphrases.edit_word_api.*
import com.app.wordsphrases.edit_word_impl.presentation.add_word_screen.EditWordFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen
import javax.inject.Inject

class EditWordStarterImpl @Inject constructor() : EditWordStarter {

    override fun getScreen(initParams: EditWordInitParams): SupportAppScreen {

        return object : SupportAppScreen() {

            override fun getScreenKey(): String {
                return EditWordFragment::class.java.simpleName
            }

            override fun getFragment(): Fragment {
                return EditWordFragment.newInstance(initParams)
            }
        }
    }
}