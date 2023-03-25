package com.raghav.workmanagertesting.repository

interface IRepository {
    suspend fun refreshLocalDatabase(): Boolean
}
