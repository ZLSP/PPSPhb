package com.zlsp.android.ppsphb.present.fragments.raports

import android.view.View
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.zlsp.android.ppsphb.R

class RaportsItemViewHolder(val view: View): RecyclerView.ViewHolder(view) {
    val tvName = view.findViewById<TextView>(R.id.raports_tv_name)
}