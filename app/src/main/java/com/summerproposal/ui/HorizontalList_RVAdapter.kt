package com.summerproposal.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.summerproposal.R
import com.summerproposal.databinding.HorizontalcardItemBinding
import com.summerproposal.domain.model.DatumData

class HorizontalList_RVAdapter(private val children: List<DatumData>) : RecyclerView.Adapter<HorizontalList_RVAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(
                parent.context
            ).inflate(
                R.layout.horizontalcard_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return children.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val child = children[position]

        HorizontalcardItemBinding.bind(holder.itemView).apply {
            tvContentTitle.text = child.attributes.title

            val url = if (child.attributes.imageUrl != null) child.attributes.imageUrl else child.attributes.images[0].url
            Glide.with(holder.itemView)
                .load(url)
                .centerCrop()
                .placeholder(R.drawable.ic_baseline_loading)
                .error(R.drawable.ic_baseline_error_24)
                .into(ivContentImage)
        }

    }


}