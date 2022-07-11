package com.app.wordsphrases.word_detail_impl.presentation;

import com.app.wordsphrases.word_detail_impl.presentation.ui.model.WordUiModel;
import java.lang.Override;
import moxy.viewstate.MvpViewState;
import moxy.viewstate.ViewCommand;
import moxy.viewstate.strategy.AddToEndSingleStrategy;

public class WordDetailsView$$State extends MvpViewState<WordDetailsView> implements WordDetailsView {
	@Override
	public void showWord(WordUiModel uiModel) {
		ShowWordCommand showWordCommand = new ShowWordCommand(uiModel);
		this.viewCommands.beforeApply(showWordCommand);

		if (hasNotView()) {
			return;
		}

		for (WordDetailsView view : this.views) {
			view.showWord(uiModel);
		}

		this.viewCommands.afterApply(showWordCommand);
	}

	public class ShowWordCommand extends ViewCommand<WordDetailsView> {
		public final WordUiModel uiModel;

		ShowWordCommand(WordUiModel uiModel) {
			super("showWord", AddToEndSingleStrategy.class);

			this.uiModel = uiModel;
		}

		@Override
		public void apply(WordDetailsView mvpView) {
			mvpView.showWord(uiModel);
		}
	}
}
