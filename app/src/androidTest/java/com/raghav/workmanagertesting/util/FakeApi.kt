package com.raghav.workmanagertesting.util

import com.raghav.workmanagertesting.SampleResponseItem

class FakeApi {

//    to mock successful response
//    fun getItemsFromApi() = listOf(
//        SampleResponseItem(1, "title1"),
//        SampleResponseItem(1, "title2")
//    )

    //    to mock failure response
    fun getItemsFromApi(): List<SampleResponseItem>? = null
}
