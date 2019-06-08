package com.selfapps.koinmvvm.repository

data class CurrencyResponse(
    val timestamp: Long,
    val base: String,
    val date: String,
    val rates: Map<String, Double>
)