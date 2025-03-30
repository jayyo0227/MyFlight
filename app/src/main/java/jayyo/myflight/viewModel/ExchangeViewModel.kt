package jayyo.myflight.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import jayyo.myflight.model.ExchangeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay

class ExchangeViewModel : ViewModel() {
    private val repository = ExchangeRepository()
    private val API_KEY = "fca_live_rvEqZHL4BufHuTPGXqXyFCcL07fZwpt6YqRIOKRa"
    private val selectedCurrencies = listOf("USD", "JPY", "EUR", "CNY", "AUD", "KRW")

    fun getConvertedRates(amount: Double, baseCurrency: String) = liveData(Dispatchers.IO) {
        while (true) {
            val rates = repository.getLatestRates(API_KEY, baseCurrency)
            val filteredRates =
                rates?.filterKeys { it in selectedCurrencies }?.mapValues { it.value * amount }
                    ?: emptyMap()
            emit(filteredRates)

            delay(10_000)
        }
    }
}
