package com.example.charlie.coinbook.ui

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.charlie.coinbook.domain.TransactionUseCases
import com.example.charlie.coinbook.viewmodel.TransactionResponse
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Named

class TransactionViewModel @Inject constructor(private val transactionUseCases: TransactionUseCases,
                                               @Named("MAIN") private val mainScheduler : Scheduler,
                                               @Named("BACKGROUND") private val backgroundScheduler : Scheduler) : ViewModel() {

    private val disposables : CompositeDisposable = CompositeDisposable()

    val response = MutableLiveData<TransactionResponse>()

    override fun onCleared() {
        disposables.clear()
    }

    fun getTransactions() {

        disposables.add(transactionUseCases.getAllTransactions()
                .subscribeOn(backgroundScheduler)
                .observeOn(mainScheduler)
                .doOnSubscribe {
                    response.value = TransactionResponse.loading()
                }
                .doOnError { e ->
                    response.value = TransactionResponse.error(e)
                }
                .subscribe { t ->
                    Timber.d(t.toString())
                    response.value = TransactionResponse.success(t)
                }
        )

    }
}
