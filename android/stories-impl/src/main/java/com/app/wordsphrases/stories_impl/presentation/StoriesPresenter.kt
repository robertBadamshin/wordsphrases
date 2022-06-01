package com.app.wordsphrases.stories_impl.presentation

import com.app.wordsphrases.add_word_api.EnterWordStarter
import com.app.wordsphrases.add_word_api.domain.entity.*
import com.app.wordsphrases.email_sender_api.FeedbackEmailSender
import com.app.wordsphrases.stories_impl.use_case.*
import com.app.wordsphrases.stories_impl.model.mapper.WordUiMapper
import com.app.wordsphrases.stories_api.StoriesNavigationQualifier
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import moxy.*
import ru.terrakok.cicerone.Router
import javax.inject.Inject


class StoriesPresenter @Inject constructor(
    private val getCurrentWord: GetCurrentWord,
    private val wordUiMapper: WordUiMapper,
    private val subscribeForWords: SubscribeForWords,
    private val moveToNextWord: MoveToNextWord,
    private val enterWordStarter: EnterWordStarter,
    @StoriesNavigationQualifier private val router: Router,
    private val feedbackEmailSender: FeedbackEmailSender,
) : MvpPresenter<StoriesView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        getCurrentWord()
            .map { word -> wordUiMapper.map(word) }
            .onEach { uiModel -> viewState.showWord(uiModel) }
            .launchIn(presenterScope)

        presenterScope.launch {
            subscribeForWords()
        }
    }

    fun onNextWordClick() {
        moveToNextWord()
    }

    fun openEnterWord() {
        val screen = enterWordStarter.getScreen(
            type = AddWordComponentType.Regular,
            router = router,
            initialTextWrapper = InitialTextWrapper(null),
        )
        router.navigateTo(screen)
    }

    fun onBackStackChanged(entriesCount: Int) {
        val hasEntries = entriesCount > 0
        viewState.updateBackPressedNestedNavigationEnabled(hasEntries)

        val visible = !hasEntries
        viewState.updateAddWordButtonVisible(visible)
    }

    fun onSendFeedbackClick() {
        val sendFeedbackIntent = feedbackEmailSender()
        viewState.startEmailActivity(sendFeedbackIntent)
    }
}