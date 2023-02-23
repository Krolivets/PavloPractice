package com.pavlo.pavlopractice.login

import android.os.Bundle
import android.view.View
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.pavlo.pavlopractice.R
import com.pavlo.pavlopractice.databinding.FragmentLoginBinding

class LoginFragment : Fragment(R.layout.fragment_login) {

    private val binding by viewBinding(FragmentLoginBinding::bind)

    var firstName = ""
    var lastName = ""

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        validateButton()
        setEditTextListeners()
        setBtnContinueListener()
    }

    private fun validateButton() {
        if (lastName.length > 2 && firstName.length > 2) {
            binding.btnContinue.isEnabled = true
        }
    }

    private fun setEditTextListeners() {
        with(binding) {
            etFirstName.doOnTextChanged { text, _, _, _ ->
                firstName = text.toString().trim()
                validateButton()
            }
            etLastName.doOnTextChanged { text, _, _, _ ->
                lastName = text.toString().trim()
                validateButton()
            }
        }
    }

    private fun setBtnContinueListener() {
        binding.btnContinue.setOnClickListener {
            val action =
                LoginFragmentDirections.actionLoginFragmentToAgeFragment(firstName, lastName)
            findNavController().navigate(action)
        }
    }
}
