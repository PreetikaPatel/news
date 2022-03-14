package com.ex.news

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var text_title: TextView
    var text_source: TextView
    var img_headline: ImageView
    var cardView: CardView

    init {
        text_title = itemView.findViewById(R.id.text_title)
        text_source = itemView.findViewById(R.id.text_source)
        img_headline = itemView.findViewById(R.id.img_headline)
        cardView = itemView.findViewById(R.id.main_container)
    }
}