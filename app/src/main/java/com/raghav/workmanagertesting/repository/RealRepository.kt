package com.raghav.workmanagertesting.repository

import com.raghav.workmanagertesting.datasource.SampleApi
import com.raghav.workmanagertesting.datasource.SampleDatabaseDao
import javax.inject.Inject

class RealRepository @Inject constructor(
    private val api: SampleApi,
    private val dao: SampleDatabaseDao
) : IRepository {

    override suspend fun refreshLocalDatabase(): Boolean {
        return try {
            val items = api.getItemsFromApi()
            dao.saveItemsInDb(items)
            true
        } catch (e: Exception) {
            false
        }
    }
}
