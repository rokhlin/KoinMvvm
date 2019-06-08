package com.selfapps.koinmvvm.repository.connectionprovider

import com.selfapps.koinmvvm.repository.CurrencyResponse
import io.reactivex.Observable
import org.koin.core.KoinComponent
import org.koin.core.inject


class ConnProviderImpl: ConnProvider, KoinComponent{
    val fixerApi : FixerApi by inject()
    override fun getLatest(): Observable<CurrencyResponse> {
       return fixerApi.getLatest()
    }


}