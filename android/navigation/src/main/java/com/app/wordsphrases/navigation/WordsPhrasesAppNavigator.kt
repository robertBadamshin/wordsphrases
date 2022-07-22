package com.app.wordsphrases.navigation

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.*
import ru.terrakok.cicerone.android.support.*
import ru.terrakok.cicerone.commands.Command

open class WordsPhrasesAppNavigator(
    private val activity: FragmentActivity,
    private val fragmentManager: FragmentManager,
    private val containerId: Int,
) : SupportAppNavigator(activity, fragmentManager, containerId) {

    override fun setupFragmentTransaction(
        command: Command?,
        currentFragment: Fragment?,
        nextFragment: Fragment?,
        fragmentTransaction: FragmentTransaction,
    ) {
        when (command) {
            is AddScreenCommand -> {
                when (command.screenFragmentAnimation) {
                    ScreenFragmentAnimation.SlideTop -> {
                        setFragmentTransactionSlideVerticalAnimation(fragmentTransaction)
                    }
                    ScreenFragmentAnimation.SlideBottom -> {
                        throw IllegalStateException("not implemented in app")
                    }
                    ScreenFragmentAnimation.Default -> {
                        createDefaultAnimation(fragmentTransaction)
                    }
                }
            }
            else -> {
                createDefaultAnimation(fragmentTransaction)
            }
        }

        fragmentTransaction.setReorderingAllowed(true)
    }


    private fun createDefaultAnimation(fragmentTransaction: FragmentTransaction) {
        fragmentTransaction.setCustomAnimations(
            R.anim.push_left_in_no_alpha,
            0,
            0,
            R.anim.push_right_out_no_alpha,
        )
    }

    private fun setFragmentTransactionSlideVerticalAnimation(fragmentTransaction: FragmentTransaction) {
        fragmentTransaction.setCustomAnimations(
            R.anim.slide_in_top,
            R.anim.slide_out_bottom,
            R.anim.slide_in_top,
            R.anim.slide_out_bottom,
        )
    }

    override fun applyCommand(command: Command?) {
        when (command) {
            is AddScreenCommand -> activityAdd(command)
            else -> super.applyCommand(command)
        }
    }

    private fun activityAdd(command: AddScreenCommand) {
        val screen = command.screen
        val activityIntent = screen.getActivityIntent(activity)

        // Start activity
        if (activityIntent != null) {
            val options = createStartActivityOptions(command, activityIntent)
            checkAndStartActivity(screen, activityIntent, options)
        } else {
            fragmentAdd(command)
        }
    }

    private fun checkAndStartActivity(
        screen: SupportAppScreen,
        activityIntent: Intent,
        options: Bundle
    ) {
        // Check if we can start activity
        if (activityIntent.resolveActivity(activity.packageManager) != null) {
            activity.startActivity(activityIntent, options)
        } else {
            unexistingActivity(screen, activityIntent)
        }
    }

    private fun fragmentAdd(command: AddScreenCommand) {
        val screen = command.screen
        val fragment = createFragment(screen)

        val fragmentTransaction = fragmentManager.beginTransaction()

        setupFragmentTransaction(
            command,
            fragmentManager.findFragmentById(containerId),
            fragment,
            fragmentTransaction
        )

        fragmentTransaction
            .add(containerId, fragment, screen.screenKey)
            .addToBackStack(screen.screenKey)
            .commit()
    }
}