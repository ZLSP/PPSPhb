package com.zlsp.android.ppsphb.present.fragments.raports

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.zlsp.android.ppsphb.R
import com.zlsp.android.ppsphb.domain.raports.RaportsItem

class RaportsListAdapter: ListAdapter<RaportsItem, RaportsItemViewHolder>(RaportsDiffCallback()) {

    var onRaportsItemClickListener: ((RaportsItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RaportsItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_raport,
            parent,
            false
        )
        return RaportsItemViewHolder(view)
    }

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: RaportsItemViewHolder, position: Int) {
        val raportsItem = getItem(position)
        holder.tvName.text = raportsItem.name
        holder.view.setOnClickListener {
            onRaportsItemClickListener?.invoke(raportsItem)
        }
    }

}