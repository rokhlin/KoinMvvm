package com.selfapps.koinmvvm

import android.app.Application
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
        single<DbProvider> {DbProviderImpl() }
        single<PrefProvider> {PrefProviderImpl() }
        single<ConnProvider> {ConnProviderImpl() }

        // single instance of Repository
        single<Repository> { RepositoryImpl(get(), get(), get()) }

//        // OR Simple Factory of Repository
//        factory<Repository> { RepositoryImpl(get(), get(), get()) }
    }

    val mainModule = module {
        viewModel { MainActivityViewModel(get()) }
    }
}