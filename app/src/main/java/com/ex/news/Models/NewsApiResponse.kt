package com.ex.news.Models

import java.io.Serializable

class NewsApiResponse : Serializable {
    var status: String? = null
    var totalResults = 0
    var articles: List<NewsHeadlines>? = null
}