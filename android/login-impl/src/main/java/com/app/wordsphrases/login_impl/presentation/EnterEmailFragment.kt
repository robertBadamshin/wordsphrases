package com.app.wordsphrases.login_impl.presentation

import android.content.res.ColorStateList
import android.os.Bundle
import android.view.*
import android.widget.*
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import com.app.wordsphrases.core_ui.view.*
import com.app.wordsphrases.login_impl.R
import com.app.wordsphrases.login_impl.di.EnterEmailComponent
import com.google.android.material.color.MaterialColors
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class EnterEmailFragment : MvpAppCompatFragment(), EnterEmailView {

    private val presenter by moxyPresenter {
        return@moxyPresenter EnterEmailComponent.get().enterEmailPresenter
    }

    private lateinit var emailEditText: EditText
    private lateinit var sendLinkButton: FloatingActionButton
    private lateinit var checkEmailTextView: TextView
    private lateinit var emailWasSentToTextView: TextView
    private lateinit var emailDeliverDescriptionTextView: TextView
    private lateinit var resendEmailTextView: TextView
    private lateinit var sendingEmailProgressBar: ProgressBar

    private val enabledButtonColor by lazy {
        MaterialColors.getColor(sendLinkButton, R.attr.rainbow)
    }
    private val disabledButtonColor by lazy {
        MaterialColors.getColor(sendLinkButton, R.attr.rainbow_60)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_enter_email, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        emailEditText = view.findViewById(R.id.edit_text_email)
        sendLinkButton = view.findViewById(R.id.floating_button_send_link)
        checkEmailTextView = view.findViewById(R.id.text_view_check_email)
        emailWasSentToTextView = view.findViewById(R.id.text_view_email_was_sent_to)
        emailDeliverDescriptionTextView = view.findViewById(
            R.id.text_view_email_deliver_description
        )
        sendingEmailProgressBar = view.findViewById(R.id.progress_bar_email_sending)
        resendEmailTextView = view.findViewById(R.id.text_view_resend_email)

        emailEditText.addTextChangedListener(
            afterTextChanged = { editable ->
                presenter.onEmailInput(editable.toString())
            }
        )

        sendLinkButton.setOnClickListener {
            val currentEmailText = emailEditText.text.toString().trim()
            presenter.onSendEmailButtonClick(currentEmailText)
        }

        resendEmailTextView.setOnClickListener { presenter.onResendClicked() }

        view.configureInsets()
    }

    companion object {

        fun newInstance(): Fragment {
            return EnterEmailFragment()
        }
    }

    override fun setSendLinkButtonDisabled() {
        sendLinkButton.backgroundTintList = ColorStateList.valueOf(disabledButtonColor)
        sendLinkButton.isEnabled = false
    }

    override fun setSendLinkButtonEnabled() {
        sendLinkButton.backgroundTintList = ColorStateList.valueOf(enabledButtonColor)
        sendLinkButton.isEnabled = true
    }

    override fun showMessage(messageRes: Int) {
        val viewToShow = requireActivity().findViewById<View>(android.R.id.content)

        Snackbar
            .make(viewToShow, messageRes, Snackbar.LENGTH_SHORT)
            .setAnchorView(sendLinkButton)
            .show()
    }

    override fun emailWasSent(email: String) {
        setInputEmailControlsVisibility(visible = false)

        sendingEmailProgressBar.isVisible = false

        emailWasSentToTextView.text = getString(R.string.email_was_sent_to, email)
        setEmailDescriptionsVisibility(visible = true)

        emailEditText.hideKeyboard()
    }

    override fun showInputForEmail() {
        setInputEmailControlsVisibility(visible = true)

        sendingEmailProgressBar.isVisible = false

        setEmailDescriptionsVisibility(visible = false)

        emailEditText.showKeyboard()
    }

    private fun setInputEmailControlsVisibility(visible: Boolean) {
        emailEditText.isVisible = visible
        sendLinkButton.isVisible = visible
    }

    private fun setEmailDescriptionsVisibility(visible: Boolean) {
        checkEmailTextView.isVisible = visible
        emailWasSentToTextView.isVisible = visible
        emailDeliverDescriptionTextView.isVisible = visible
        resendEmailTextView.isVisible = visible
    }

    override fun showLoader() {
        sendingEmailProgressBar.isVisible = true
        sendLinkButton.isVisible = false
    }

    override fun hideLoader() {
        sendingEmailProgressBar.isVisible = false
        sendLinkButton.isVisible = true
    }
}