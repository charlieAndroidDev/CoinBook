package com.example.charlie.coinbook.data.repository

import com.example.charlie.coinbook.data.Transaction
import com.example.charlie.coinbook.data.db.CoinDataDatabase
import com.example.charlie.coinbook.data.remote.api.CryptoCompareAPI
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CryptoOperationsRepository @Inject constructor(private val cryptoCompareAPI: CryptoCompareAPI,
                                                     private val coinDataDatabase: CoinDataDatabase) {

    fun getAllTradingPairs() : Single<Map<String, Map<String, List<String>>>> {
        return cryptoCompareAPI.getAllExchanges()
    }

    fun getAllTransactions() : Maybe<List<Transaction>> {
        return coinDataDatabase.transactionDao().getAll()
    }

    fun insertTransaction(transaction: Transaction) : Completable {

        return Completable.create {

            coinDataDatabase.transactionDao().insert(transaction)
            it.onError(Exception("Transaction insert failed"))
            it.onComplete()

        }

    }

}