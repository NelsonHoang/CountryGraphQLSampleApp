package com.nhoang.countrygraphqlsampleapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.nhoang.countrygraphqlsampleapp.presentation.CountriesScreen
import com.nhoang.countrygraphqlsampleapp.presentation.CountriesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel = hiltViewModel<CountriesViewModel>()
            val state by viewModel.state.collectAsState()
            CountriesScreen(
                state = state,
                onSelectCountry = viewModel::selectCountry,
                onDismissCountryDialog = viewModel::dismissCountryDialog
            )
        }
    }
}