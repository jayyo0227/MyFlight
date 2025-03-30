package jayyo.myflight.viewModel

import jayyo.myflight.model.Flight
import org.junit.Assert.assertEquals
import org.junit.Test

class FlightViewModelTest {
    @Test
    fun test() {
        val viewModel = FlightViewModel()
        val flight = Flight(
            expectTime = "08:55",
            realTime = "08:59",
            airLineName = "立榮航空",
            airLineCode = "UIA",
            airLineLogo = "https://www.kia.gov.tw/images/airlines/B7.gif",
            airLineUrl = "https://www.kia.gov.tw/AirFlyCompany.aspx?Code=UIA",
            airLineNum = "B78690",
            upAirportCode = "MZG",
            upAirportName = "澎湖",
            airPlaneType = "AT76",
            airBoardingGate = "17",
            airFlyStatus = "抵達Arrived",
            airFlyDelayCause = ""
        )
        var expected: List<Flight>? = null
        var actual: Flight? = null

        if (viewModel.getFlights().isInitialized) {
            expected = listOf(flight)
            actual = viewModel.getFlights().value?.get(0)
        }

        assertEquals(expected, actual)
    }
}