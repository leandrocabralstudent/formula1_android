package com.leandroid.data.network

import android.content.Context
import com.leandroid.data.BuildConfig
import com.leandroid.data.R
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.jackson.JacksonConverterFactory

internal class RetrofitFactory {
    fun getRetrofitInstance(context: Context): Retrofit {
        val url = if (BuildConfig.DEBUG) {
            context.getString(R.string.URL_STAGING)
        } else {
            context.getString(R.string.URL_PRODUCTION)
        }

        return Retrofit.Builder()
            .baseUrl(url)
            .client(getOkHttpInstance())
            .addConverterFactory(JacksonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    private fun getOkHttpInstance(): OkHttpClient {
        return OkHttpClient()
            .newBuilder()
            .addInterceptor(getOkHttpLoggingInterceptorInstance())
            .build()
    }

    private fun getOkHttpLoggingInterceptorInstance(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor()
            .apply {
                if (BuildConfig.DEBUG) {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            }
    }
}