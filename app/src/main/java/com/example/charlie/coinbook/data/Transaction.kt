package com.example.charlie.coinbook.data

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.util.*

@Entity(tableName = "transactions")
data class Transaction(@PrimaryKey(autoGenerate = true) val tId : Long,
                       val date : String,
                       val amount : Int,
                       val currency : String)