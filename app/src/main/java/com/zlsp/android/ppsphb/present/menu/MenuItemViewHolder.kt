package com.zlsp.android.ppsphb.present.menu

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.zlsp.android.ppsphb.R

class MenuItemViewHolder(val view: View): RecyclerView.ViewHolder(view) {
    val ivIcon = view.findViewById<ImageView>(R.id.iv_icon)
    val tvName = view.findViewById<TextView>(R.id.tv_name)

}