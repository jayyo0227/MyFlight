package jayyo.myflight.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import jayyo.myflight.databinding.FragmentFlightBinding
import jayyo.myflight.viewModel.FlightViewModel

class FlightFragment : Fragment() {
    private var _binding: FragmentFlightBinding? = null
    private val binding get() = _binding!!
    private val flightViewModel: FlightViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFlightBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.progressBar.visibility = View.VISIBLE

        flightViewModel.getFlights().observe(viewLifecycleOwner) { flights ->
            binding.recyclerView.adapter = FlightAdapter(flights ?: emptyList())
            binding.progressBar.visibility = View.GONE
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

