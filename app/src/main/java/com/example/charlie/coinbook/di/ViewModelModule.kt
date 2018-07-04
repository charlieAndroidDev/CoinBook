package com.example.charlie.coinbook.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.charlie.coinbook.ui.TradingPairsViewModel
import com.example.charlie.coinbook.ui.TransactionViewModel
import com.example.charlie.coinbook.viewmodel.CoinBookViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(TradingPairsViewModel::class)
    abstract fun bindTradingPairsViewModel(tradingPairsViewModel: TradingPairsViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(TransactionViewModel::class)
    abstract fun bindTransactionViewModel(transactionViewModel: TransactionViewModel) : ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory : CoinBookViewModelFactory) : ViewModelProvider.Factory

}