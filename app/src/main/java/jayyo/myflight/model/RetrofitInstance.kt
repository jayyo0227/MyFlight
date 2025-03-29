package jayyo.myflight.model

import jayyo.myflight.data.ExchangeApiService
import jayyo.myflight.data.FlightApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val BASE_FLIGHT_URL = "https://www.kia.gov.tw/API/"

    val apiFlight: FlightApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_FLIGHT_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(FlightApiService::class.java)
    }

    private const val BASE_EXCHANGE_URL = "https://api.freecurrencyapi.com/v1/"

    val apiExchange: ExchangeApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_EXCHANGE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ExchangeApiService::class.java)
    }
}
