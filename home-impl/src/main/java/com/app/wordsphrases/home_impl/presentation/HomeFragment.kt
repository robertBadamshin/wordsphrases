package com.app.wordsphrases.home_impl.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.app.wordsphrases.core.BaseWordsPhrasesApp.Companion.appComponent
import com.app.wordsphrases.home_impl.R
import com.app.wordsphrases.navigation.MainRouter
import com.app.wordsphrases.navigation.NavigationScreen
import com.app.wordsphrases.home_impl.di.HomeComponent
import com.google.android.material.floatingactionbutton.FloatingActionButton
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import ru.terrakok.cicerone.commands.Command

class HomeFragment : MvpAppCompatFragment(), HomeView {

    private val homePresenter by moxyPresenter { HomeComponent.get().homePresenter }

    private lateinit var addWordButton: FloatingActionButton

    private val nestedPagesRouter: Router by lazy { appComponent.router }
    private val navigatorHolder: NavigatorHolder by lazy { appComponent.navigatorHolder }
    private val navigator: Navigator by lazy {
        object : SupportAppNavigator(requireActivity(), childFragmentManager, R.id.fragment_container_home) {

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

    private val backPressedNestedNavigationCallback = object : OnBackPressedCallback(false) {

        override fun handleOnBackPressed() {
            childFragmentManager.popBackStack()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requireActivity().onBackPressedDispatcher.addCallback(this, backPressedNestedNavigationCallback)

        childFragmentManager.addOnBackStackChangedListener {
            homePresenter.onBackStackChanged(childFragmentManager.backStackEntryCount)
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

        addWordButton = view.findViewById(R.id.floating_button_add_word)
        addWordButton.setOnClickListener { homePresenter.openEnterWord() }
    }

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

    override fun updateBackPressedNestedNavigationEnabled(enabled: Boolean) {
        backPressedNestedNavigationCallback.isEnabled = enabled
    }
}