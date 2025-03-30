package jayyo.myflight.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import jayyo.myflight.model.FlightRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay

class FlightViewModel : ViewModel() {
    private val repository = FlightRepository()

    fun getFlights() = liveData(Dispatchers.IO) {
        while (true) {
            val flights = repository.getFlights()
            emit(flights)

            delay(10_000)
        }
    }
}
