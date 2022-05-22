package com.app.wordsphrases.add_word_impl.navigation

import androidx.fragment.app.Fragment
import com.app.wordsphrases.add_word_api.EnterWordStarter
import com.app.wordsphrases.add_word_api.domain.entity.*
import com.app.wordsphrases.add_word_impl.di.AddWordParentComponent
import com.app.wordsphrases.add_word_impl.presentation.enter_word_screen.EnterWordFragment
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.support.SupportAppScreen
import java.util.*
import javax.inject.Inject

class EnterWordStarterImpl @Inject constructor() : EnterWordStarter {

    override fun getScreen(
        type: AddWordComponentType,
        router: Router,
        initialTextWrapper: InitialTextWrapper,
    ): SupportAppScreen {
        val component = AddWordParentComponent.get()
        val uuid = UUID.randomUUID()

        component.createAddWordComponent(
            uuid = uuid,
            type = type,
            router = router,
            initialTextWrapper = initialTextWrapper,
        )

        return object : SupportAppScreen() {

            override fun getScreenKey(): String {
                return EnterWordFragment::class.java.simpleName
            }

            override fun getFragment(): Fragment {
                return EnterWordFragment.newInstance(uuid)
            }
        }
    }
}