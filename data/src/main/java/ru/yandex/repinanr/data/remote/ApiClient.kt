package ru.yandex.repinanr.data.remote

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.yandex.repinanr.data.BuildConfig

object ApiClient {
    private const val BASE_URL = "https://random-data-api.com/api/v2/"

    val client = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().apply {
            if (BuildConfig.DEBUG) {
                level = HttpLoggingInterceptor.Level.HEADERS
                level = HttpLoggingInterceptor.Level.BODY
            }
        })
        .addInterceptor(
            object : Interceptor {
                override fun intercept(chain: Interceptor.Chain): Response = chain.run {
                    proceed(
                        request()
                            .newBuilder()
                            .header("X-App-Version", "1")
                            .header("X-Platform", "Android")
                            .build()
                    )
                }

            }
        )
        .build()

    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService = retrofit.create(RandomDataService::class.java)
}