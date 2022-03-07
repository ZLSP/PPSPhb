package com.zlsp.android.ppsphb.present.fragments.raports

import androidx.recyclerview.widget.DiffUtil
import com.zlsp.android.ppsphb.domain.raports.RaportsItem
import com.zlsp.android.ppsphb.domain.redaction.RedactionItem

class RaportsDiffCallback: DiffUtil.ItemCallback<RaportsItem>() {
    override fun areItemsTheSame(oldItem: RaportsItem, newItem: RaportsItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: RaportsItem, newItem: RaportsItem): Boolean {
        return oldItem == newItem
    }
}