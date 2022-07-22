package com.app.wordsphrases.words_stories_impl.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.*
import com.app.wordsphrases.core_ui.view.*
import com.app.wordsphrases.words_stories_impl.R
import com.app.wordsphrases.words_stories_impl.di.WordsStoriesComponent
import com.app.wordsphrases.words_stories_impl.presentation.ui.*
import com.app.wordsphrases.words_stories_impl.presentation.ui.adapter.WordsStoriesAdapter
import com.app.wordsphrases.words_stories_impl.presentation.ui.model.WordUiModel
import com.app.wordsphrases.words_stories_impl.presentation.view.StoriesProgressView
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

private val verticalSwipeThreshold = 30.dpToPx()

class WordsStoriesFragment : MvpAppCompatFragment(), WordStoriesView {

    private val wordsStoriesPresenter by moxyPresenter {
        WordsStoriesComponent.get().wordStoriesPresenter
    }

    private lateinit var wordsStoriesRecyclerView: RecyclerView
    private lateinit var storiesProgressView: StoriesProgressView

    private val wordsStoriesAdapter by lazy { WordsStoriesAdapter() }

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

    @SuppressLint("ClickableViewAccessibility")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        wordsStoriesRecyclerView = view.findViewById(R.id.recycler_view_stories)

        wordsStoriesRecyclerView.layoutManager = layoutManager
        val snapHelper = PagerSnapHelper()
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
                requireActivity().onBackPressed()
            }
        })

        configureGesturesForStories()

        view.configureInsets()
    }

    private fun configureGesturesForStories() {
        val simpleOnGestureListener = object : GestureDetector.SimpleOnGestureListener() {

            override fun onSingleTapUp(event: MotionEvent): Boolean {
                if (event.x < wordsStoriesRecyclerView.width / 2) {
                    onLeafStoryClicked(StoriesLeafDirection.Left)
                } else {
                    onLeafStoryClicked(StoriesLeafDirection.Right)
                }

                return true
            }

            override fun onDown(e: MotionEvent?): Boolean {
                return true
            }

            override fun onFling(
                firstEvent: MotionEvent,
                secondEvent: MotionEvent,
                velocityX: Float,
                velocityY: Float
            ): Boolean {

                val diffX = secondEvent.x - firstEvent.x
                val diffY = secondEvent.y - firstEvent.y

                if (diffY > 0 && diffY > diffX && diffY > verticalSwipeThreshold) {
                    requireActivity().onBackPressed()
                    return true
                }

                return false
            }
        }

        val gestureDetector = GestureDetector(requireContext(), simpleOnGestureListener)
        val itemTouchListener = object : RecyclerView.OnItemTouchListener {

            override fun onInterceptTouchEvent(
                recyclerView: RecyclerView,
                event: MotionEvent
            ): Boolean {
                return true
            }

            override fun onTouchEvent(recyclerView: RecyclerView, event: MotionEvent) {
                when (event.action) {
                    MotionEvent.ACTION_DOWN -> {
                        storiesProgressView.pause()
                    }
                    MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                        storiesProgressView.resume()
                    }
                }
                gestureDetector.onTouchEvent(event)
            }

            override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {
                // nothing to do
            }
        }

        wordsStoriesRecyclerView.addOnItemTouchListener(itemTouchListener)
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