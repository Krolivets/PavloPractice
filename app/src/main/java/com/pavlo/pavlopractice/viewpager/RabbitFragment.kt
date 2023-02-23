package com.pavlo.pavlopractice.viewpager

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.pavlo.pavlopractice.R
import com.pavlo.pavlopractice.databinding.FragmentRabbitRecyclerBinding

class RabbitFragment(position: Int) : Fragment(R.layout.fragment_rabbit_recycler) {
    private val binding by viewBinding(FragmentRabbitRecyclerBinding::bind)
    private lateinit var adapter: RabbitAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvFirstItems.layoutManager = LinearLayoutManager(context)
        binding.rvFirstItems.addItemDecoration(DividerItemDecoration(context, 1))
        initAdapter()
    }

    val pos = position
    private fun initAdapter() {
        recyclerView = binding.rvFirstItems
        adapter = RabbitAdapter()
        recyclerView.adapter = adapter
        adapter.setList(myItem())
    }

    private fun myItem(): ArrayList<ItemModel> {
        val itemList = ArrayList<ItemModel>()

        repeat(20) { index ->
            if (pos == 0) {
                itemList.add(
                    ItemModel(
                        firstName = "Rabbit",
                        lastName = "King ${(index + 1)}"

                    )
                )
            } else {
                itemList.add(
                    ItemModel(
                        firstName = "Король",
                        lastName = "Кроль ${(index + 1)}"
                    )
                )
            }
        }
        return itemList
    }
}
