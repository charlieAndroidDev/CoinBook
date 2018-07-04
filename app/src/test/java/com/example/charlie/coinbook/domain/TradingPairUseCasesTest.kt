package com.example.charlie.coinbook.domain

import com.example.charlie.coinbook.data.repository.CryptoOperationsRepository
import com.example.charlie.coinbook.mock
import com.example.charlie.coinbook.whenever
import io.reactivex.Single
import org.junit.Test

class TradingPairUseCasesTest {

    private val cryptoOperationsRepository = mock<CryptoOperationsRepository>()
    val tradingPairUseCases = TradingPairUseCases(cryptoOperationsRepository)

    @Test
    fun testTradingPairUseCases_getAllTradingPairs_Completed() {

        whenever(cryptoOperationsRepository.getAllTradingPairs())
                .thenReturn(Single.just(emptyMap()))

        tradingPairUseCases.getAllTradingPairs()
                .test()
                .assertComplete()

    }

    @Test
    fun testTradingPairUseCases_getAllTradingPairs_Error() {

        val response = Throwable("Error!")

        whenever(cryptoOperationsRepository.getAllTradingPairs())
                .thenReturn(Single.error(response))

        tradingPairUseCases.getAllTradingPairs()
                .test()
                .assertError(response)

    }

    @Test
    fun testTradingPairUseCases_getAllTradingPairs_Response() {

        val response = mapOf(Pair("Coinbase", mapOf(Pair("42", listOf("BTC", "LTC")))))

        whenever(cryptoOperationsRepository.getAllTradingPairs())
                .thenReturn(Single.just(response))

        tradingPairUseCases.getAllTradingPairs()
                .test()
                .assertValue(response)

    }

}