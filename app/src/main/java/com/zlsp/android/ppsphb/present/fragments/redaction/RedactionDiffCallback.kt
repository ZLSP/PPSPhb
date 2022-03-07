package com.zlsp.android.ppsphb.present.fragments.redaction

import androidx.recyclerview.widget.DiffUtil
import com.zlsp.android.ppsphb.domain.redaction.RedactionItem

class RedactionDiffCallback: DiffUtil.ItemCallback<RedactionItem>() {
    override fun areItemsTheSame(oldItem: RedactionItem, newItem: RedactionItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: RedactionItem, newItem: RedactionItem): Boolean {
        return oldItem == newItem
    }
}