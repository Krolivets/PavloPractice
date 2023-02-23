package com.pavlo.pavlopractice.login

import android.os.Bundle
import android.view.View
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.pavlo.pavlopractice.R
import com.pavlo.pavlopractice.databinding.FragmentAgeBinding
import com.pavlo.pavlopractice.models.User

class AgeFragment : Fragment(R.layout.fragment_age) {
    private val args: AgeFragmentArgs by navArgs()
    private val binding by viewBinding(FragmentAgeBinding::bind)

    private var age = ""
    private var address = ""

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setFirstLastNames()
        setEditTextListeners()
        setBtnFinishListener()
    }

    private fun setFirstLastNames() {
        with(binding) {
            tvFirstName.text = args.firstName
            tvLastName.text = args.lastName
        }
    }

    private fun setEditTextListeners() {
        with(binding) {
            etAge.doOnTextChanged { text, start, count, after ->

                age = text.toString()

                etAddress.doOnTextChanged { text, _, _, _ ->
                    address = text.toString()
                }
            }
        }
    }

    private fun setBtnFinishListener() {
        binding.btnFinish.setOnClickListener {
            val user = User(
                firstName = args.firstName,
                lastName = args.lastName,
                age = age,
                address = address,
            )

            findNavController().navigate(
                AgeFragmentDirections.actionAgeFragmentToFinishFragment(user),
            )
        }
    }
}
