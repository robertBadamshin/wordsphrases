package com.app.wordsphrases.words_stories_impl.presentation

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.*
import com.app.wordsphrases.core_ui.view.configureInsets
import com.app.wordsphrases.words_stories_impl.R
import com.app.wordsphrases.words_stories_impl.di.WordsStoriesComponent
import com.app.wordsphrases.words_stories_impl.presentation.ui.*
import com.app.wordsphrases.words_stories_impl.presentation.ui.adapter.WordsStoriesAdapter
import com.app.wordsphrases.words_stories_impl.presentation.ui.model.WordUiModel
import com.app.wordsphrases.words_stories_impl.presentation.view.StoriesProgressView
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class WordsStoriesFragment : MvpAppCompatFragment(), WordStoriesView {

    private val wordsStoriesPresenter by moxyPresenter {
        WordsStoriesComponent.get().wordStoriesPresenter
    }

    private lateinit var wordsStoriesRecyclerView: RecyclerView
    private lateinit var storiesProgressView: StoriesProgressView

    private val wordsStoriesAdapter by lazy {
        WordsStoriesAdapter(
            onNextClicked = {
                onLeafStoryClicked(StoriesLeafDirection.Right)
            },
            onPrevClicked = {
                onLeafStoryClicked(StoriesLeafDirection.Left)
            },
        )
    }

    private fun onLeafStoryClicked(storiesLeafDirection: StoriesLeafDirection) {
        val nextItemPosition = getNextItemPosition(storiesLeafDirection)
        layoutManager.scrollToPosition(nextItemPosition)

        storiesProgressView.startStories(nextItemPosition)
    }

    private fun getNextItemPosition(storiesLeafDirection: StoriesLeafDirection): Int {
        val visibleItemPosition = layoutManager.findFirstVisibleItemPosition()

        val changedItemPosition = when (storiesLeafDirection) {
            StoriesLeafDirection.Left -> visibleItemPosition - 1
            StoriesLeafDirection.Right -> visibleItemPosition + 1
        }

        return changedItemPosition.coerceIn(0, layoutManager.itemCount - 1)
    }

    private val layoutManager by lazy {
        LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_words_stories, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        wordsStoriesRecyclerView = view.findViewById(R.id.recycler_view_stories)

        wordsStoriesRecyclerView.layoutManager = layoutManager
        val snapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(wordsStoriesRecyclerView)
        wordsStoriesRecyclerView.adapter = wordsStoriesAdapter

        val onSnapPositionChangeListener = object : OnSnapPositionChangeListener {

            override fun onSnapPositionChange(position: Int) {
                storiesProgressView.startStories(position)
            }
        }
        val snapOnScrollListener = SnapOnScrollListener(
            snapHelper = snapHelper,
            onSnapPositionChangeListener = onSnapPositionChangeListener,
        )

        wordsStoriesRecyclerView.addOnScrollListener(snapOnScrollListener)

        storiesProgressView = view.findViewById(R.id.stories_progress_view)

        storiesProgressView.setStoriesListener(object : StoriesProgressView.StoriesListener {

            override fun onNext(index: Int) {
                val nextItemPosition = getNextItemPosition(StoriesLeafDirection.Right)
                layoutManager.scrollToPosition(nextItemPosition)
            }

            override fun onPrev(index: Int) {
                val nextItemPosition = getNextItemPosition(StoriesLeafDirection.Left)
                layoutManager.scrollToPosition(nextItemPosition)
            }

            override fun onComplete() {

            }
        })

        view.configureInsets()
    }

    override fun showWords(words: List<WordUiModel>) {
        wordsStoriesAdapter.items = words

        storiesProgressView.setStoriesCount(words.size)
        storiesProgressView.setStoryDuration(2000L)

        storiesProgressView.startStories()
    }

    companion object {

        fun newInstance(): Fragment {
            val fragment = WordsStoriesFragment()
            return fragment
        }
    }

    private enum class StoriesLeafDirection {

        Left,
        Right,
    }
}