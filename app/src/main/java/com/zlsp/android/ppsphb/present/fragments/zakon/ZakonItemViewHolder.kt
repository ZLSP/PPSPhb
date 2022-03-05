package com.zlsp.android.ppsphb.present.fragments.zakon

import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.zlsp.android.ppsphb.R

class ZakonItemViewHolder(val view: View): RecyclerView.ViewHolder(view) {
    val llBox = view.findViewById<LinearLayout>(R.id.ll_box)
    val tvArticle = view.findViewById<TextView>(R.id.tv_article)
}