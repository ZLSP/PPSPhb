package com.zlsp.android.ppsphb.present.fragments.zakon

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.zlsp.android.ppsphb.R
import com.zlsp.android.ppsphb.domain.zakon.ZakonItem

class ZakonListAdapter: ListAdapter<ZakonItem, ZakonItemViewHolder>(ZakonItemDiffCallback()) {

    var onZakonItemClickListener: ((ZakonItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ZakonItemViewHolder {
        val layout = when(viewType) {
            VIEW_NO_ACTIVE -> R.layout.item_zakon_default
            VIEW_ACTIVE -> R.layout.item_zakon_active
            else -> throw RuntimeException("Error")
        }
        val view = LayoutInflater.from(parent.context).inflate(
            layout,
            parent,
            false
        )
        return ZakonItemViewHolder(view)
    }

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: ZakonItemViewHolder, position: Int) {
        val zakonItem = getItem(position)
        holder.tvArticle.text = zakonItem.article
        holder.view.setOnClickListener {
            onZakonItemClickListener?.invoke(zakonItem)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (!getItem(position).active)
            VIEW_NO_ACTIVE
        else
            VIEW_ACTIVE
    }

    companion object {
        const val VIEW_NO_ACTIVE = 100
        const val VIEW_ACTIVE = 101

        const val MAX_POOL_SIZE = 30
    }
}