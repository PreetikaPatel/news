package com.ex.news

import com.ex.news.Models.NewsHeadlines

interface OnFetchDataListener<NewsApiResponse> {
    fun OnFetchData(list: List<NewsHeadlines>?, message: String?)
    fun OnError(message: String?)
}