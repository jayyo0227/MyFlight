package jayyo.myflight.model

class ExchangeRepository {
    suspend fun getLatestRates(apiKey: String, baseCurrency: String = "USD"): Map<String, Double>? {
        val response = RetrofitInstance.apiExchange.getLatestRates(apiKey, baseCurrency)
        return if (response.isSuccessful) response.body()?.data else null
    }
}
