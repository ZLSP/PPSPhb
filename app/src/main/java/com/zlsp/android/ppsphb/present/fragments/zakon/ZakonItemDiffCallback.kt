package com.zlsp.android.ppsphb.present.fragments.zakon

import androidx.recyclerview.widget.DiffUtil
import com.zlsp.android.ppsphb.domain.zakon.ZakonItem

class ZakonItemDiffCallback: DiffUtil.ItemCallback<ZakonItem>() {
    override fun areItemsTheSame(oldItem: ZakonItem, newItem: ZakonItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ZakonItem, newItem: ZakonItem): Boolean {
        return oldItem == newItem
    }
}