package com.example.charlie.coinbook.data.repository

import com.example.charlie.coinbook.data.Transaction
import com.example.charlie.coinbook.remote.api.CryptoCompareAPI
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CryptoOperationsRepository @Inject constructor(private val cryptoCompareAPI: CryptoCompareAPI) {

    fun getAllTradingPairs() : Single<Map<String, Map<String, List<String>>>> {
        return cryptoCompareAPI.getAllExchanges()
    }

    fun getAllTransactions() : Observable<List<Transaction>> {
        return Observable.just(emptyList())
    }

}