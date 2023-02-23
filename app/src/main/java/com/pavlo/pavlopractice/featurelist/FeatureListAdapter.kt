package com.pavlo.pavlopractice.featurelist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pavlo.pavlopractice.databinding.RecyclerviewItemBinding
import com.pavlo.pavlopractice.models.Feature

class FeatureListAdapter(
    private val features: List<Feature>,
    private val clickListener: OnFeatureItemClickListener,
) :
    RecyclerView.Adapter<FeatureListAdapter.FeatureViewHolder>() {

    override fun getItemCount() = features.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeatureViewHolder {
        return FeatureViewHolder(
            RecyclerviewItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            ),
        )
    }

    override fun onBindViewHolder(holder: FeatureViewHolder, position: Int) {
        holder.bind(features[position])
    }

    inner class FeatureViewHolder(private val binding: RecyclerviewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Feature) {
            with(binding) {
                tvTitle.text = item.title
                tvId.text = item.id.toString()
                root.setOnClickListener { clickListener.onItemClick(item) }
            }
        }
    }

    interface OnFeatureItemClickListener {
        fun onItemClick(item: Feature)
    }
}
