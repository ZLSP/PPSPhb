package com.zlsp.android.ppsphb.present.fragments.osnov

import android.view.View
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.zlsp.android.ppsphb.R

class OsnovItemViewHolder(val view: View): RecyclerView.ViewHolder(view) {
    val tvName = view.findViewById<TextView>(R.id.osnov_tv_name)
    val tvArticle = view.findViewById<TextView>(R.id.osnov_tv_article)
    val tvText = view.findViewById<TextView>(R.id.osnov_tv_text)
    val svText = view.findViewById<ScrollView>(R.id.osnov_sv_text)
}