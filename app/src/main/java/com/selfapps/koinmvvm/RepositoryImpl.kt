package com.selfapps.koinmvvm

class RepositoryImpl(val prefProvider: PrefProvider,
                     val dbProvider: DbProvider,
                     val connProvider: ConnProvider): Repository {
}