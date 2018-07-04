package com.example.charlie.coinbook.domain

import com.example.charlie.coinbook.data.Transaction
import com.example.charlie.coinbook.data.repository.CryptoOperationsRepository
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class TransactionUseCases @Inject constructor(private val cryptoOperationsRepository: CryptoOperationsRepository) {

    fun getAllTransactions() : Observable<List<Transaction>> {
        return cryptoOperationsRepository.getAllTransactions()
    }

}