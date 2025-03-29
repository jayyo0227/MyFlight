package jayyo.myflight.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import jayyo.myflight.model.FlightRepository
import kotlinx.coroutines.Dispatchers

class FlightViewModel : ViewModel() {
    private val repository = FlightRepository()

    fun getFlights(airFlyLine: Int, airFlyIO: Int) = liveData(Dispatchers.IO) {
        val flights = repository.getFlights(airFlyLine, airFlyIO)
        emit(flights)
    }
}
