package com.app.wordsphrases.stories_impl.presentation

import com.app.wordsphrases.email_sender_api.FeedbackEmailSender
import com.app.wordsphrases.stories_impl.model.mapper.WordUiMapper
import com.app.wordsphrases.stories_impl.use_case.*
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import moxy.*
import javax.inject.Inject

class StoriesPresenter @Inject constructor(
    private val getCurrentWord: GetCurrentWord,
    private val wordUiMapper: WordUiMapper,
    private val subscribeForWords: SubscribeForWords,
    private val moveToNextWord: MoveToNextWord,
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

    fun onSendFeedbackClick() {
        val sendFeedbackIntent = feedbackEmailSender()
        viewState.startEmailActivity(sendFeedbackIntent)
    }
}