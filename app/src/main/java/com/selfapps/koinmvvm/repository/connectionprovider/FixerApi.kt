package com.selfapps.koinmvvm.repository.connectionprovider

import io.reactivex.Observable
import retrofit2.http.GET


interface FixerApi {

    @GET("latest")
    fun getLatest() : Observable<String>
}