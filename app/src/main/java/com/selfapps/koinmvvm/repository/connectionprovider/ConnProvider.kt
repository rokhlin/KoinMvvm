package com.selfapps.koinmvvm.repository.connectionprovider

import com.selfapps.koinmvvm.repository.CurrencyResponse
import io.reactivex.Observable

interface ConnProvider {

    fun getLatest(): Observable<CurrencyResponse>
}