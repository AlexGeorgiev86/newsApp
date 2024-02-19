package com.sales.newsinshort.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.sales.newsinshort.ui.components.Loader
import com.sales.newsinshort.ui.viewmodel.NewsViewModel
import com.sales.utilities.ResourceState

const val TAG = "HomeScreen"

@Composable
fun HomeScreen(
    newsViewModel: NewsViewModel = hiltViewModel()
) {
    val newsRes by newsViewModel.news.collectAsState()


    Surface(modifier = Modifier.fillMaxSize()) {

        when (newsRes) {
            is ResourceState.Loading -> {
                Log.d(TAG, "Inside_Loading")
                Loader()
            }

            is ResourceState.Success -> {
                Log.d(TAG, "Inside_Success")
            }

            is ResourceState.Error -> {
                Log.d(TAG, "Inside_Error")
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}