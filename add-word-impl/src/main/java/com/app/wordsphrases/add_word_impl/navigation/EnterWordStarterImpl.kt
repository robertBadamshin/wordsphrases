package com.app.wordsphrases.add_word_impl.navigation

import androidx.fragment.app.Fragment
import com.app.wordsphrases.add_word_api.EnterWordStarter
import com.app.wordsphrases.add_word_api.di.AddWordInnerComponent
import com.app.wordsphrases.add_word_impl.di.AddWordParentComponent
import com.app.wordsphrases.add_word_impl.presentation.enter_word_screen.EnterWordFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen
import javax.inject.Inject

class EnterWordStarterImpl @Inject constructor() : EnterWordStarter {

    override fun getScreen(innerComponent: AddWordInnerComponent): SupportAppScreen {

        // todo init
        val component = AddWordParentComponent.get()
        component.createPopupAddWordComponent(innerComponent)

        return object : SupportAppScreen() {

            override fun getScreenKey(): String {
                return EnterWordFragment::class.java.simpleName
            }

            override fun getFragment(): Fragment {
                return EnterWordFragment()
            }
        }
    }
}