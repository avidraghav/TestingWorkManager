package com.raghav.workmanagertesting

import com.raghav.workmanagertesting.repository.IRepository
import com.raghav.workmanagertesting.util.FakeApi
import com.raghav.workmanagertesting.util.FakeDao

class FakeRepository(
    private val fakeApi: FakeApi = FakeApi(),
    private val fakeDao: FakeDao = FakeDao()
) : IRepository {
    override suspend fun refreshLocalDatabase(): Boolean {
        return try {
            val items = fakeApi.getItemsFromApi()
            if (items.isNullOrEmpty()) {
                throw Exception("Error occurred while fetching response")
            }
            fakeDao.saveItemsInDatabase(items)
            true
        } catch (e: Exception) {
            false
        }
    }
}
