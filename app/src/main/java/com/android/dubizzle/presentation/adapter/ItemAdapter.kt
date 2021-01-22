package com.android.dubizzle.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.dubizzle.databinding.RowItemLayoutBinding
import com.android.dubizzle.domain.model.Item
import com.android.dubizzle.utils.setImageUrl

/**
 *   Created by Mohd Farhan on 22/01/2021.
 */
class ItemAdapter (
    val itemList: List<Item>,
    val listener: View.OnClickListener
) : RecyclerView.Adapter<ItemAdapter.ItemVH>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemVH {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: RowItemLayoutBinding = RowItemLayoutBinding.inflate(layoutInflater, parent, false)
        binding.listener = listener
        return ItemVH(binding)
    }
    override fun onBindViewHolder(holder: ItemVH, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int = itemList.size


    class ItemVH(binding: RowItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.getRoot()) {

        private val binding: RowItemLayoutBinding
        fun bind(item: Item ){
            binding.item = item
            binding.itemImage.setImageUrl(item.imageUrls.get(0))
            binding.executePendingBindings()
        }
        init {
            this.binding = binding
        }
    }

}