package com.zlsp.android.ppsphb.present.menu

import androidx.recyclerview.widget.DiffUtil
import com.zlsp.android.ppsphb.domain.menu.MenuItem

class MenuItemDiffCallback: DiffUtil.ItemCallback<MenuItem>() {
    override fun areItemsTheSame(oldItem: MenuItem, newItem: MenuItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: MenuItem, newItem: MenuItem): Boolean {
        return oldItem == newItem
    }
}