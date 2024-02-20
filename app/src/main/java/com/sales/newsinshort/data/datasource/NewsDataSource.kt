package com.sales.newsinshort.data.datasource

import com.sales.newsinshort.data.entity.NewsResponse
import retrofit2.Response

interface NewsDataSource {
    fun getNewsHeadline(country: String): Response<NewsResponse>
}