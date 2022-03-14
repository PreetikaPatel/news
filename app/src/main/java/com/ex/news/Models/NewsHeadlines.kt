package com.ex.news.Models

import java.io.Serializable

class NewsHeadlines : Serializable {
    var source: Source? = null
    var author = ""
    var title = ""
    var description = ""
    var url = ""
    var urlToImage = ""
    var publishedAt = ""
    var content = ""
}