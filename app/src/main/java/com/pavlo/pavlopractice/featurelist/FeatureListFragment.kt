package com.pavlo.pavlopractice.featurelist

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.pavlo.pavlopractice.R
import com.pavlo.pavlopractice.databinding.FragmentFeatureListBinding
import com.pavlo.pavlopractice.models.Feature

class FeatureListFragment :
    Fragment(R.layout.fragment_feature_list),
    FeatureListAdapter.OnFeatureItemClickListener {

    private val binding by viewBinding(FragmentFeatureListBinding::bind)
    private val viewModel: FeatureListViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvItems.layoutManager = LinearLayoutManager(context)
        binding.rvItems.addItemDecoration(DividerItemDecoration(context, 1))

        viewModel.featureListLD.observe(viewLifecycleOwner) {
            binding.rvItems.adapter = FeatureListAdapter(
                features = it,
                clickListener = this
            )
        }
    }

    override fun onItemClick(item: Feature) {
        when (item) {
            Feature.COUNTER -> navigateCounter()
            Feature.VIEWPAGER -> navigateViewPager()
            Feature.LOGIN -> navigateLogin()
        }
    }

    private fun navigateCounter() {
        findNavController().navigate(
            resId = R.id.action_featureListFragment_to_counterFragment,
            args = null,
            navOptions = navOptions {
                anim {
                    enter = android.R.animator.fade_in
                    exit = android.R.animator.fade_out
                }
            }
        )
    }

    private fun navigateViewPager() {
        findNavController().navigate(
            resId = R.id.action_featureListFragment_to_viewPagerFragment,
            args = null,
            navOptions = navOptions {
                anim {
                    enter = android.R.animator.fade_in
                    exit = android.R.animator.fade_out
                }
            }
        )
    }

    private fun navigateLogin() {
        findNavController().navigate(
            resId = R.id.action_featureListFragment_to_loginFragment,
            args = null,
            navOptions = navOptions {
                anim {
                    enter = android.R.animator.fade_in
                    exit = android.R.animator.fade_out
                }
            }
        )
    }
}
