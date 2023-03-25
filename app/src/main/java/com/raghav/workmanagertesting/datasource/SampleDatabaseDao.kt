package com.raghav.workmanagertesting.datasource

import com.raghav.workmanagertesting.SampleResponseItem

interface SampleDatabaseDao {
    suspend fun saveItemsInDb(items: List<SampleResponseItem>)
}
