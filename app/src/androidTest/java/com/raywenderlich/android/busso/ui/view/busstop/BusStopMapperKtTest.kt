package com.raywenderlich.android.busso.ui.view.busstop

import com.raywenderlich.android.busso.model.BusStop
import com.raywenderlich.android.location.api.model.GeoLocation
import org.junit.Assert.assertEquals
import org.junit.Test

@Test
fun mapBusStop_givenCompleteBusStop_returnsCompleteBusStopViewModel() {

    val inputBusStop = BusStop(
        "id",
        "stopName",
        GeoLocation(1.0, 2.0),
        "direction",
        "indicator",
        123F
    )

    val expectedViewModel = BusStopViewModel(
        "id",
        "stopName",
        "direction",
        "indicator",
        "123 m"
    )

    assertEquals(expectedViewModel, mapBusStop(inputBusStop))
}