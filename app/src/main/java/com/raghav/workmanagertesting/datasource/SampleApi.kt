package com.raghav.workmanagertesting.datasource

import com.raghav.workmanagertesting.SampleResponseItem

interface SampleApi {
    suspend fun getItemsFromApi(): List<SampleResponseItem>
}
