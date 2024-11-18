package com.nhoang.countrygraphqlsampleapp.data

import com.apollographql.apollo3.ApolloClient
import com.nhoang.CountriesQuery
import com.nhoang.CountryQuery
import com.nhoang.countrygraphqlsampleapp.domain.CountryClient
import com.nhoang.countrygraphqlsampleapp.domain.DetailedCountry
import com.nhoang.countrygraphqlsampleapp.domain.SimpleCountry

class ApolloCountryClient(
    private val apolloClient: ApolloClient
) : CountryClient {
    override suspend fun getCountries(): List<SimpleCountry> {
        return apolloClient
            .query(CountriesQuery())
            .execute()
            .data
            ?.countries
            ?.map { it.toSimpleCountry() }
            ?: emptyList()
    }

    override suspend fun getCountry(code: String): DetailedCountry? {
        return apolloClient
            .query(CountryQuery(code))
            .execute()
            .data
            ?.country
            ?.toDetailedCountry()
    }

}