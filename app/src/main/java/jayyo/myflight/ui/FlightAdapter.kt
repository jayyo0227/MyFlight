package jayyo.myflight.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import jayyo.myflight.R
import jayyo.myflight.databinding.ItemFlightBinding
import jayyo.myflight.model.Flight

class FlightAdapter(private val flights: List<Flight>) :
    RecyclerView.Adapter<FlightAdapter.FlightViewHolder>() {

    inner class FlightViewHolder(private val binding: ItemFlightBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(flight: Flight) {
            binding.tvExpectTime.text = flight.expectTime
            binding.tvRealTime.text = flight.realTime
            binding.tvAirLineCode.text = flight.airLineCode
            binding.tvAirLineName.text = flight.airLineName
            binding.tvAirLineGate.text = flight.airBoardingGate
            binding.tvAirFlyStatus.text = flight.airFlyStatus
            binding.tvUpAirportCode.text = flight.upAirportCode
            binding.tvUpAirportName.text = flight.upAirportName

            Picasso.get()
                .load(flight.airLineLogo.ifEmpty { null })
                .placeholder(R.drawable.loading)
                .error(R.drawable.empty)
                .into(binding.iconAirLineName)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlightViewHolder {
        val binding = ItemFlightBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return FlightViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FlightViewHolder, position: Int) {
        holder.bind(flights[position])
    }

    override fun getItemCount(): Int = flights.size
}

