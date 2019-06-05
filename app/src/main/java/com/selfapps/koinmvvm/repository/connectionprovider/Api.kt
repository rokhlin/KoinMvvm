package com.selfapps.koinmvvm.repository.connectionprovider

import okhttp3.OkHttpClient
import org.koin.core.KoinComponent
import org.koin.core.inject
import org.koin.core.parameter.parametersOf
import retrofit2.Retrofit


class Api : KoinComponent {
    private val url = "http://data.fixer.io/api/latest"
    val KEY = "05802094470ddc2d9fc11699cbfae648"

    val httpClient = OkHttpClient.Builder()
                        .addInterceptor { chain ->
                            val original = chain.request()
                            val originalHttpUrl = original.url()

                            val url = originalHttpUrl.newBuilder()
                                .addQueryParameter("access_key", KEY)
                                .build()

                            // Request customization: add request headers
                            val requestBuilder = original.newBuilder()
                                .url(url)

                            val request = requestBuilder.build()
                            chain.proceed(request)
                        }.build()


    private val retrofit: Retrofit by inject{ parametersOf(url, httpClient)}

    val fixer: FixerApi = retrofit.create(FixerApi::class.java)
}