package com.zlsp.android.ppsphb.present.menu

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import com.zlsp.android.ppsphb.R
import com.zlsp.android.ppsphb.domain.menu.MenuItem

class MenuListAdapter: ListAdapter<MenuItem, MenuItemViewHolder>(MenuItemDiffCallback()) {

    var onMenuItemClickListener: ((MenuItem) -> Unit)? = null
    private var ctx : Context? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuItemViewHolder {
        ctx = parent.context
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_menu,
            parent,
            false
        )
        return MenuItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: MenuItemViewHolder, position: Int) {
        val menuItem = getItem(position)
        println("menuItem: $menuItem position: $position")
        Glide.with(ctx!!).load(menuItem.icon).into(holder.ivIcon)
        holder.tvName.text = menuItem.name
        holder.view.setOnClickListener {
            onMenuItemClickListener?.invoke(menuItem)
        }
    }
}