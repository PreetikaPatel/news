package com.ex.news


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ex.news.Models.NewsHeadlines
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

     var    headlines = (intent.getSerializableExtra("data") as NewsHeadlines)

        text_detail_title.text = headlines.title
        text_detail_author.text = headlines.author
        text_detail_time.setText(headlines.publishedAt)
        text_detail_detail.setText(headlines.description)
        text_detail_content.setText(headlines.content)
        Picasso.get().load(headlines.urlToImage).into(img_detail_news)
    }
}