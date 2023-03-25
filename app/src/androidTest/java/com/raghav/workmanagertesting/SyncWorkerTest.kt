package com.raghav.workmanagertesting

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.work.ListenableWorker.Result
import androidx.work.testing.TestListenableWorkerBuilder
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import org.junit.Test

class SyncWorkerTest {

    @Test
    fun ifErrorInFetchingResponseThenReturnFailure() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val worker = TestListenableWorkerBuilder<SyncWorker>(
            context = context
        ).setWorkerFactory(TestWorkerFactory())
            .build()

        runBlocking {
            val result = worker.doWork()
            assertThat(result).isEqualTo(Result.failure())
        }
    }
}
