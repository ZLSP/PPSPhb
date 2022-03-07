package com.zlsp.android.ppsphb.present.fragments.redaction

import android.view.View
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.zlsp.android.ppsphb.R

class RedactionItemViewHolder(val view: View): RecyclerView.ViewHolder(view) {
    val tvName = view.findViewById<TextView>(R.id.pr_tv_name)
    val tvText = view.findViewById<TextView>(R.id.pr_tv_text)
}