package jayyo.myflight.data

import jayyo.myflight.model.ExchangeResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ExchangeApiService {

    @GET("latest")
    suspend fun getLatestRates(
        @Query("apikey") apiKey: String,
        @Query("base_currency") baseCurrency: String = "USD"
    ): Response<ExchangeResponse>
}
