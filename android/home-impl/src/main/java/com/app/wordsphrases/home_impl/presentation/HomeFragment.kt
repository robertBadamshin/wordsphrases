package com.app.wordsphrases.home_impl.presentation

import android.os.Bundle
import android.view.*
import androidx.fragment.app.*
import com.app.wordsphrases.core.BaseWordsPhrasesApp.Companion.appComponent
import com.app.wordsphrases.home_impl.R
import com.app.wordsphrases.home_impl.di.HomeComponent
import com.app.wordsphrases.home_impl.domain.entity.HomeScreenTab
import com.google.android.material.bottomnavigation.BottomNavigationView
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.terrakok.cicerone.*
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import ru.terrakok.cicerone.commands.Command

class HomeFragment : MvpAppCompatFragment(), HomeView {

    private val homePresenter by moxyPresenter { HomeComponent.get().homePresenter }

    private lateinit var bottomNavigationView: BottomNavigationView

    private val nestedPagesRouter: Router by lazy { appComponent.router }
    private val navigatorHolder: NavigatorHolder by lazy { appComponent.navigatorHolder }
    private val navigator: Navigator by lazy {
        object : SupportAppNavigator(
            requireActivity(),
            childFragmentManager,
            R.id.fragment_container_home
        ) {

            override fun setupFragmentTransaction(
                command: Command?,
                currentFragment: Fragment?,
                nextFragment: Fragment?,
                fragmentTransaction: FragmentTransaction
            ) {
                fragmentTransaction.setCustomAnimations(
                    R.anim.push_left_in_no_alpha,
                    R.anim.push_right_out_no_alpha,
                    R.anim.push_left_in_no_alpha,
                    R.anim.push_right_out_no_alpha
                )

                fragmentTransaction.setReorderingAllowed(true)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bottomNavigationView = view.findViewById(R.id.bottom_navigation_home)
        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.vocabulary_navigation_item -> {
                    homePresenter.onSelectTab(HomeScreenTab.Vocabulary)
                }
                R.id.folders_navigation_item -> throw IllegalStateException("wrong menu item")
            }

            return@setOnItemSelectedListener true
        }

        bottomNavigationView.setOnItemReselectedListener {
            // do nothing
        }
    }

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }
}