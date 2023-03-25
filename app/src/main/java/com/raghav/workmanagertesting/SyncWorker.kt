package com.raghav.workmanagertesting

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.raghav.workmanagertesting.repository.IRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject

@HiltWorker
class SyncWorker @AssistedInject constructor(
    @Assisted ctx: Context,
    @Assisted params: WorkerParameters,
    private val repository: IRepository
) : CoroutineWorker(ctx, params) {

    override suspend fun doWork(): Result {
        return if (repository.refreshLocalDatabase()) {
            Result.success()
        } else {
            Result.failure()
        }
    }

    companion object {
        private const val TAG = "SyncWorker"
    }
}
