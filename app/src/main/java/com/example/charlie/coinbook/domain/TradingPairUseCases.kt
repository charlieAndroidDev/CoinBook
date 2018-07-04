package com.example.charlie.coinbook.domain

import com.example.charlie.coinbook.data.repository.CryptoOperationsRepository
import io.reactivex.Single
import javax.inject.Inject

class TradingPairUseCases @Inject constructor(private val cryptoOperationsRepository: CryptoOperationsRepository) {

    fun getAllTradingPairs() : Single<Map<String, Map<String, List<String>>>> {
        return cryptoOperationsRepository.getAllTradingPairs()
    }

}