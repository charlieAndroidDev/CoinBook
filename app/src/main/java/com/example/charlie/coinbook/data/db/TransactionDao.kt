package com.example.charlie.coinbook.data.db

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query
import com.example.charlie.coinbook.data.Transaction
import io.reactivex.Maybe

@Dao
interface TransactionDao {

    @Query("SELECT * FROM transactions")
    fun getAll() : Maybe<List<Transaction>>

    @Query("SELECT * FROM transactions WHERE currency = :coin")
    fun getByCurrency(coin : String) : Maybe<List<Transaction>>

    @Insert(onConflict = REPLACE)
    fun insert(transaction: Transaction)

    @Query("DELETE FROM transactions")
    fun deleteAll()

    @Delete
    fun delete(transaction: Transaction)
}