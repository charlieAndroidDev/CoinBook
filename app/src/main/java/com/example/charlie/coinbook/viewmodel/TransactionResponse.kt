package com.example.charlie.coinbook.viewmodel

import com.example.charlie.coinbook.data.Transaction

class TransactionResponse(
        val status: Status,
        val data : Any?,
        val error : Throwable?) {

    companion object {

        fun loading(): TransactionResponse {
            return TransactionResponse(Status.LOADING, null, null)
        }

        fun success(data: List<Transaction>): TransactionResponse {
            return TransactionResponse(Status.SUCCESS, data, null)
        }

        fun error(error: Throwable): TransactionResponse {
            return TransactionResponse(Status.ERROR, null, error)
        }

    }

}