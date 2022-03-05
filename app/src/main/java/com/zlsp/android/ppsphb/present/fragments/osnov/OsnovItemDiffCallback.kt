package com.zlsp.android.ppsphb.present.fragments.osnov

import androidx.recyclerview.widget.DiffUtil
import com.zlsp.android.ppsphb.domain.osnovania.OsnovItem
import com.zlsp.android.ppsphb.domain.zakon.ZakonItem

class OsnovItemDiffCallback: DiffUtil.ItemCallback<OsnovItem>() {
    override fun areItemsTheSame(oldItem: OsnovItem, newItem: OsnovItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: OsnovItem, newItem: OsnovItem): Boolean {
        return oldItem == newItem
    }
}