package com.summerproposal.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.summerproposal.R
import com.summerproposal.databinding.VerticalcardItemBinding
import com.summerproposal.domain.model.Data

class VerticalList_RVAdapter : RecyclerView.Adapter<VerticalList_RVAdapter.DataAdapterViewHolder>() {

    inner class DataAdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    private val diffCallback = object : DiffUtil.ItemCallback<Data>(){
        override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    }

    private val differ = AsyncListDiffer(this, diffCallback)

    fun submitList(list: List<Data>) {
        differ.submitList(list)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataAdapterViewHolder {
        return DataAdapterViewHolder(
            LayoutInflater.from(
                parent.context
            ).inflate(
                R.layout.verticalcard_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: DataAdapterViewHolder, position: Int) {

        val item = differ.currentList[position]

        VerticalcardItemBinding.bind(holder.itemView).apply {
            tvType.text = item.attributes.title

            rvChild.apply {
                layoutManager = LinearLayoutManager(rvChild.context, RecyclerView.HORIZONTAL, false)

                item.relationships?.also {
                    adapter = HorizontalList_RVAdapter(it.items.data)
                }
            }
        }

//        holder.itemView.apply {
//            binding = PeacockdataItemBinding.bind(this)
//            binding.tvId.text = item.id
//            binding.tvType.text = item.type
//        }

    }


}