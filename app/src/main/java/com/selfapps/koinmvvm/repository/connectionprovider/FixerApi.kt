package com.selfapps.koinmvvm.repository.connectionprovider

import com.selfapps.koinmvvm.repository.CurrencyResponse
import io.reactivex.Observable
import retrofit2.http.GET


interface FixerApi {

    @GET("latest")
    fun getLatest() : Observable<CurrencyResponse>
}