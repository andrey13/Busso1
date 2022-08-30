package com.raywenderlich.android.busso.ui.view.busarrival

import com.raywenderlich.android.busso.model.BusArrival
import com.raywenderlich.android.busso.model.BusArrivalGroup
import com.raywenderlich.android.busso.model.BusArrivals
import com.raywenderlich.android.busso.ui.view.busstop.mapBusStop
import java.text.SimpleDateFormat
import java.util.*

/**
 * The ViewModel for the BusArrivals
 */
internal fun mapBusArrivals(busArrivals: BusArrivals): BusArrivalsViewModel =
    BusArrivalsViewModel(
        mapBusStop(busArrivals.busStop),
        busArrivals
            .arrivalGroups
            .map(::mapBusArrivalGroup)
    )

/**
 * Maps the BusArrivalGroup into a BusArrivalGroupViewModel adding some decorations
 */
internal fun mapBusArrivalGroup(busArrivalGroup: BusArrivalGroup): BusArrivalGroupViewModel {
    return BusArrivalGroupViewModel(
        lineName = busArrivalGroup.lineName,
        destination = busArrivalGroup.destination,
        arrivals = busArrivalGroup.arrivals.map(::mapBusArrival)
    )
}

/**
 * Maps the list of arrivals group into their viewmodel
 */
internal fun mapBusArrivalGroup(arrivals: List<BusArrivalGroup>): List<BusArrivalGroupViewModel> =
    arrivals.map(::mapBusArrivalGroup)

/**
 * Maps an arrival times group into its viewmodel
 */
internal fun mapBusArrival(arrival: BusArrival): BusArrivalViewModel =
    BusArrivalViewModel(
        expectedTime = expectedTime(arrival.expectedArrival),
        vehicleId = arrival.vehicleId ?: "-",
        destination = arrival.destinationName
    )

/**
 * Maps the list of arrival times group into their viewmodel
 */
fun mapBusArrival(arrivals: List<BusArrival>): List<BusArrivalViewModel> =
    arrivals.map(::mapBusArrival)

val DATE_FORMATTER = SimpleDateFormat("HH:mm")

private fun expectedTime(expectedTime: Date) = DATE_FORMATTER.format(expectedTime)

