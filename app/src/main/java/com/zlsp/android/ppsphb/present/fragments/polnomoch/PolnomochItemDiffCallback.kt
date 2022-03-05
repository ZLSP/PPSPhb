package com.zlsp.android.ppsphb.present.fragments.polnomoch

import androidx.recyclerview.widget.DiffUtil
import com.zlsp.android.ppsphb.domain.polnomoch.PolnomochItem

class PolnomochItemDiffCallback: DiffUtil.ItemCallback<PolnomochItem>() {
    override fun areItemsTheSame(oldItem: PolnomochItem, newItem: PolnomochItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: PolnomochItem, newItem: PolnomochItem): Boolean {
        return oldItem == newItem
    }
}