package com.pavlo.pavlopractice.login

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.pavlo.pavlopractice.R
import com.pavlo.pavlopractice.databinding.FragmentFinishBinding

class FinishFragment : Fragment(R.layout.fragment_finish) {
    private val args: FinishFragmentArgs by navArgs()
    private val binding by viewBinding(FragmentFinishBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupData()
    }

    private fun setupData() {
        with(binding) {
            resultFirstName.text = args.user.firstName
            resultLastName.text = args.user.lastName
            resultAge.text = args.user.age.toString()
            resultAddress.text = args.user.address
        }
    }
}
