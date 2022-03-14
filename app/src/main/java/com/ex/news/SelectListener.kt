package com.ex.news

import com.ex.news.Models.NewsHeadlines

interface SelectListener {
    fun OnNewsClicked(headlines: NewsHeadlines?)
}