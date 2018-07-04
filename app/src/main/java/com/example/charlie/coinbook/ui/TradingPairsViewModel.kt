package com.example.charlie.coinbook.ui

import android.arch.lifecycle.ViewModel
import com.example.charlie.coinbook.domain.TradingPairUseCases
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject
import javax.inject.Named

class TradingPairsViewModel @Inject constructor(private val tradingPairUseCases: TradingPairUseCases,
                                                @Named("MAIN") val mainScheduler : Scheduler,
                                                @Named("BACKGROUND") val backgroundScheduler : Scheduler) : ViewModel() {

    private val disposables : CompositeDisposable = CompositeDisposable()


}
