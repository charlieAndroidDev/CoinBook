package com.example.charlie.coinbook.di

import android.app.Application
import android.arch.persistence.room.Room
import com.example.charlie.coinbook.db.CoinDataDatabase
import com.example.charlie.coinbook.db.TransactionDao
import com.example.charlie.coinbook.remote.api.CryptoCompareAPI
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class])
class ServiceModule {

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit) : CryptoCompareAPI = retrofit.create(CryptoCompareAPI::class.java)

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient) : Retrofit = Retrofit.Builder()
            .baseUrl("https://min-api.cryptocompare.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build()

    @Singleton
    @Provides
    fun provideOkHttp(loggingInterceptor: HttpLoggingInterceptor) : OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()

    @Singleton
    @Provides
    fun provideLoggingInterceptor() : HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return loggingInterceptor
    }

    @Singleton
    @Provides
    fun provideDb(application: Application) : CoinDataDatabase {
        return Room
                .databaseBuilder(application, CoinDataDatabase::class.java, "coindata.db")
                .fallbackToDestructiveMigration()
                .build()
    }

    @Singleton
    @Provides
    fun provideTransactionDao(db : CoinDataDatabase) : TransactionDao {
        return db.transactionDao()
    }

}