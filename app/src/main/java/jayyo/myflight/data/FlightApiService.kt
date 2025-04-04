package jayyo.myflight.data

import jayyo.myflight.model.InstantScheduleResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface FlightApiService {

    @GET("InstantSchedule.ashx")
    suspend fun getFlights(
        @Query("AirFlyLine") airFlyLine: Int = 2,
        @Query("AirFlyIO") airFlyIO: Int = 2
    ): Response<InstantScheduleResponse>
}