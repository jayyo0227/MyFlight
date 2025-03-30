package jayyo.myflight.model

class FlightRepository {
    suspend fun getFlights(): List<Flight>? {
        val response = RetrofitInstance.apiFlight.getFlights()
        return if (response.isSuccessful) response.body()?.instantSchedule else null
    }
}
