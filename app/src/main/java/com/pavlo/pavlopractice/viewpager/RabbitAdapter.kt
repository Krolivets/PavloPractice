package com.pavlo.pavlopractice.viewpager

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pavlo.pavlopractice.databinding.RecyclerviewItemViewpagerBinding

class RabbitAdapter :
    RecyclerView.Adapter<RabbitAdapter.ItemViewHolder>() {

    private var itemList = emptyList<ItemModel>()

    override fun getItemCount() = itemList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            RecyclerviewItemViewpagerBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    class ItemViewHolder(private val binding: RecyclerviewItemViewpagerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ItemModel) {
            with(binding) {
                tvFirstName.text = item.firstName
                tvLastName.text = item.lastName
            }
        }
    }

    fun setList(list: List<ItemModel>) {
        itemList = list
        notifyItemChanged(itemList.size)
    }
}
