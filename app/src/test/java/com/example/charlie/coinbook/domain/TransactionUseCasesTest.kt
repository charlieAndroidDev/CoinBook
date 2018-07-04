package com.example.charlie.coinbook.domain

import android.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.charlie.coinbook.data.Transaction
import com.example.charlie.coinbook.data.repository.CryptoOperationsRepository
import com.example.charlie.coinbook.mock
import com.example.charlie.coinbook.whenever
import io.reactivex.Observable
import org.junit.Rule
import org.junit.Test

class TransactionUseCasesTest {

    private val cryptoOperationsRepository = mock<CryptoOperationsRepository>()

    val transactionUseCases = TransactionUseCases(cryptoOperationsRepository)

    @Test
    fun testTransactionUseCases_getAllTransactions_Completed() {

        whenever(cryptoOperationsRepository.getAllTransactions())
                .thenReturn(Observable.just(emptyList()))

        transactionUseCases.getAllTransactions()
                .test()
                .assertComplete()

    }

    @Test
    fun testTransactionUseCases_getAllTransactions_Error() {

        val response = Throwable("Error!")
        whenever(cryptoOperationsRepository.getAllTransactions())
                .thenReturn(Observable.error(response))

        transactionUseCases.getAllTransactions()
                .test()
                .assertError(response)

    }

    @Test
    fun testTransactionUseCases_getAllTransactions_Response() {

        val response = arrayListOf(Transaction(0L, "", 0, ""))
        whenever(cryptoOperationsRepository.getAllTransactions())
                .thenReturn(Observable.just(response))

        transactionUseCases.getAllTransactions()
                .test()
                .assertValue(response)
    }

}