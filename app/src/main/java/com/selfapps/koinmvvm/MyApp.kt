package com.selfapps.koinmvvm

import android.app.Application
import com.selfapps.koinmvvm.repository.*
import com.selfapps.koinmvvm.repository.connectionprovider.Api
import com.selfapps.koinmvvm.repository.connectionprovider.ConnProvider
import com.selfapps.koinmvvm.repository.connectionprovider.ConnProviderImpl
import com.selfapps.koinmvvm.repository.connectionprovider.FixerApi
import com.selfapps.koinmvvm.repository.localdatastore.DbProvider
import com.selfapps.koinmvvm.repository.localdatastore.DbProviderImpl
import com.selfapps.koinmvvm.repository.localdatastore.PrefProvider
import com.selfapps.koinmvvm.repository.localdatastore.PrefProviderImpl
import com.selfapps.koinmvvm.vm.MainActivityViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.Arrays.asList
import okhttp3.OkHttpClient



class MyApp: Application() {
    val KEY = "05802094470ddc2d9fc11699cbfae648"



    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(asList(repositoryModule,retrofitModule, mainModule ))
        }
    }

    private val repositoryModule = module {
        // single instances of Providers
        single<DbProvider> { DbProviderImpl() }
        single<PrefProvider> { PrefProviderImpl() }
        single<ConnProvider> { ConnProviderImpl()}
        // single instance of Repository
        single<Repository> {
            RepositoryImpl(
                get(),
                get(),
                get()
            )
        }

//        // OR Simple Factory of Repository
//        factory<Repository> { RepositoryImpl(get(), get(), get()) }
    }

    private val mainModule = module {
        viewModel { MainActivityViewModel(get()) }
    }

    private val retrofitModule = module {
//        val httpClient = OkHttpClient.Builder()
//            httpClient.addInterceptor { chain ->
//                val original = chain.request()
//                val originalHttpUrl = original.url()
//
//                val url = originalHttpUrl.newBuilder()
//                    .addQueryParameter("access_key", KEY)
//                    .build()
//
//                // Request customization: add request headers
//                val requestBuilder = original.newBuilder()
//                    .url(url)
//
//                val request = requestBuilder.build()
//                chain.proceed(request)
//        }

        single<Retrofit> {(url: String,httpClient: OkHttpClient) ->
            Retrofit.Builder().baseUrl(url)
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
        }

        single { Api().fixer }
    }
}