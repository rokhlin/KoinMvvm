package com.selfapps.koinmvvm.repository

import com.selfapps.koinmvvm.repository.connectionprovider.ConnProvider
import com.selfapps.koinmvvm.repository.localdatastore.DbProvider
import com.selfapps.koinmvvm.repository.localdatastore.PrefProvider

class RepositoryImpl(val prefProvider: PrefProvider,
                     val dbProvider: DbProvider,
                     val connProvider: ConnProvider
): Repository {
}