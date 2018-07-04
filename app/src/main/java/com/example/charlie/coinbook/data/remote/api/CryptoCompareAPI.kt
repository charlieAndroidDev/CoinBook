package com.example.charlie.coinbook.data.remote.api

import io.reactivex.Single
import retrofit2.http.GET

interface CryptoCompareAPI {

    @GET("data/all/exchanges")
    fun getAllExchanges() : Single<Map<String, Map<String, List<String>>>>

}