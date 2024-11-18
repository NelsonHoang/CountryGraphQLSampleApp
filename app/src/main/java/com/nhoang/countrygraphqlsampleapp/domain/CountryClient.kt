package com.nhoang.countrygraphqlsampleapp.domain

import com.nhoang.CountryQuery

interface CountryClient {
    suspend fun getCountries(): List<SimpleCountry>

    suspend fun getCountry(code: String) : DetailedCountry?
}