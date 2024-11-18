package com.nhoang.countrygraphqlsampleapp.data

import com.nhoang.CountriesQuery
import com.nhoang.CountryQuery
import com.nhoang.countrygraphqlsampleapp.domain.DetailedCountry
import com.nhoang.countrygraphqlsampleapp.domain.SimpleCountry

fun CountryQuery.Country.toDetailedCountry() : DetailedCountry {
    return DetailedCountry(
        code = code,
        name = name,
        emoji = emoji,
        capital = capital ?: "No capital",
        currency = currency ?: "No currency",
        languages = languages.mapNotNull { it.name },
        continent = continent.name
    )
}

fun CountriesQuery.Country.toSimpleCountry() : SimpleCountry {
    return SimpleCountry(
        code = code,
        name = name,
        emoji = emoji,
        capital = capital ?: "No capital",
    )
}
