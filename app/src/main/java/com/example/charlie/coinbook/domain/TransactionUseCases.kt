package com.example.charlie.coinbook.domain

import com.example.charlie.coinbook.data.Transaction
import com.example.charlie.coinbook.data.repository.CryptoOperationsRepository
import io.reactivex.Completable
import io.reactivex.Maybe
import javax.inject.Inject

class TransactionUseCases @Inject constructor(private val cryptoOperationsRepository: CryptoOperationsRepository) {

    fun getAllTransactions() : Maybe<List<Transaction>> {
        return cryptoOperationsRepository.getAllTransactions()
    }

    fun insertTransaction(transaction: Transaction) : Completable {
        return cryptoOperationsRepository.insertTransaction(transaction)
    }

}