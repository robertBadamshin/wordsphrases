package com.app.wordsphrases.add_word_impl.navigation

import androidx.fragment.app.Fragment
import com.app.wordsphrases.add_word_api.AddWordStarter
import com.app.wordsphrases.add_word_api.domain.entity.*
import com.app.wordsphrases.add_word_impl.di.AddWordParentComponent
import com.app.wordsphrases.add_word_impl.presentation.add_word_screen.AddWordFragment
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.support.SupportAppScreen
import java.util.*
import javax.inject.Inject

class AddWordStarterImpl @Inject constructor() : AddWordStarter {

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
                return AddWordFragment::class.java.simpleName
            }

            override fun getFragment(): Fragment {
                return AddWordFragment.newInstance(uuid)
            }
        }
    }
}