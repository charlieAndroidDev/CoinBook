package com.example.charlie.coinbook.data

data class Exchange(private val name : String,
                    private val tradingPairs: List<TradingMap>)