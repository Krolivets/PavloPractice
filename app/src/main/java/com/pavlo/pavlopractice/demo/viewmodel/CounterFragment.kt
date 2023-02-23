package com.pavlo.pavlopractice.demo.viewmodel

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.pavlo.pavlopractice.R
import com.pavlo.pavlopractice.databinding.FragmentCounterBinding

class CounterFragment : Fragment(R.layout.fragment_counter) {

    private val viewModel: CounterViewModel by viewModels()
    private val binding by viewBinding(FragmentCounterBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.currentValueLiveData.observe(viewLifecycleOwner) {
            binding.tvNumber.text = it.toString()
        }

        with(binding) {
            btnIncrement.setOnClickListener { viewModel.increment() }
            btnDecrement.setOnClickListener { viewModel.decrement() }
        }
    }
}
