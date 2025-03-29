package jayyo.myflight.model

class FlightRepository {
    suspend fun getFlights(airFlyLine: Int, airFlyIO: Int): List<Flight>? {
        val response = RetrofitInstance.apiFlight.getFlights(airFlyLine, airFlyIO)
        return if (response.isSuccessful) response.body()?.instantSchedule else null
    }
}
