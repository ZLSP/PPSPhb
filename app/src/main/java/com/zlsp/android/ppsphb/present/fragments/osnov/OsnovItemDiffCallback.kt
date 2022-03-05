package com.zlsp.android.ppsphb.present.fragments.osnov

import androidx.recyclerview.widget.DiffUtil
import com.zlsp.android.ppsphb.domain.osnov.OsnovItem

class OsnovItemDiffCallback: DiffUtil.ItemCallback<OsnovItem>() {
    override fun areItemsTheSame(oldItem: OsnovItem, newItem: OsnovItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: OsnovItem, newItem: OsnovItem): Boolean {
        return oldItem == newItem
    }
}