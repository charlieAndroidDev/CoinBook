package com.example.charlie.coinbook.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.example.charlie.coinbook.data.Transaction

@Database(entities = [Transaction::class], version = 2)
abstract class CoinDataDatabase : RoomDatabase() {

    abstract fun transactionDao() : TransactionDao

}