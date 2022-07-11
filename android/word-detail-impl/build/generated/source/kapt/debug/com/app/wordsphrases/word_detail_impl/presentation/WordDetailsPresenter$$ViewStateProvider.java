package com.app.wordsphrases.word_detail_impl.presentation;

import java.lang.Override;
import moxy.MvpView;
import moxy.ViewStateProvider;
import moxy.viewstate.MvpViewState;

public class WordDetailsPresenter$$ViewStateProvider extends ViewStateProvider {
	@Override
	public MvpViewState<? extends MvpView> getViewState() {
		return new WordDetailsView$$State();
	}
}
