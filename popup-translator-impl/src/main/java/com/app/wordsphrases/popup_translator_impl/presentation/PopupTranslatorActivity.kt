package com.app.wordsphrases.popup_translator_impl.presentation

import android.content.Intent
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.app.wordsphrases.popup_translator_impl.R
import com.app.wordsphrases.popup_translator_impl.di.AddWordInnerComponentImpl
import com.app.wordsphrases.popup_translator_impl.di.PopupTranslatorComponent
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import ru.terrakok.cicerone.commands.Command


class PopupTranslatorActivity : MvpAppCompatActivity(), PopupTranslatorView {

    private val addWordInnerComponent by lazy { AddWordInnerComponentImpl.get() }
    private val component by lazy { PopupTranslatorComponent.get(addWordInnerComponent) }

    private val popupTranslatorPresenter by moxyPresenter { component.popupTranslatorPresenter }

    private val navigatorHolder: NavigatorHolder by lazy {
        component.popupTranslatorNavigatorHolderWrapper.navigatorHolder
    }
    private val navigator: Navigator by lazy {
        object : SupportAppNavigator(this, supportFragmentManager, R.id.fragment_container_popup) {

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
            supportFragmentManager.popBackStack()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        onBackPressedDispatcher.addCallback(this, backPressedNestedNavigationCallback)

        setContentView(R.layout.activity_popup_translator)

        initWordText()
    }


    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

    private fun initWordText() {
        val wordText = intent
            .getCharSequenceExtra(Intent.EXTRA_PROCESS_TEXT)
            ?.toString()

        if (wordText == null) {
            throw IllegalArgumentException("extraText should be presented")
        }

        //
        //popupTranslatorPresenter.onSetWordText(wordText)
    }


    override fun beginPopupAddWordComponentCreation() {
        popupTranslatorPresenter.initPopupAddWordComponent(addWordInnerComponent)
    }
}