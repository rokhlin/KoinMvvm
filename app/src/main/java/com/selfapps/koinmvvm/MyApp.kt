package com.selfapps.koinmvvm

import android.app.Application
import com.selfapps.koinmvvm.repository.*
import com.selfapps.koinmvvm.repository.connectionprovider.ConnProvider
import com.selfapps.koinmvvm.repository.connectionprovider.ConnProviderImpl
import com.selfapps.koinmvvm.repository.localdatastore.DbProvider
import com.selfapps.koinmvvm.repository.localdatastore.DbProviderImpl
import com.selfapps.koinmvvm.repository.localdatastore.PrefProvider
import com.selfapps.koinmvvm.repository.localdatastore.PrefProviderImpl
import com.selfapps.koinmvvm.vm.MainActivityViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module
import java.util.Arrays.asList

class MyApp: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(asList(repositoryModule, mainModule))
        }
    }

    val repositoryModule = module {

        // single instances of Providers
        single<DbProvider> { DbProviderImpl() }
        single<PrefProvider> { PrefProviderImpl() }
        single<ConnProvider> { ConnProviderImpl() }

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

    val mainModule = module {
        viewModel { MainActivityViewModel(get()) }
    }
}