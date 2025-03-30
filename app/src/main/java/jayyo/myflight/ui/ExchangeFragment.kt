package jayyo.myflight.ui

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import jayyo.myflight.databinding.FragmentExchangeBinding
import jayyo.myflight.viewModel.ExchangeViewModel

class ExchangeFragment : Fragment() {
    private var _binding: FragmentExchangeBinding? = null
    private val binding get() = _binding!!
    private val exchangeViewModel: ExchangeViewModel by viewModels()

    private val updateHandler = Handler(Looper.getMainLooper())
    private val updateRunnable = object : Runnable {
        override fun run() {
            exchangeViewModel.getConvertedRates(1.0, "USD").observe(viewLifecycleOwner) { rates ->
                binding.recyclerView.adapter = ExchangeAdapter(rates ?: emptyMap())
                binding.progressBar.visibility = View.GONE
            }

            updateHandler.postDelayed(this, 10_000)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentExchangeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.progressBar.visibility = View.VISIBLE

        updateHandler.post(updateRunnable)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        updateHandler.removeCallbacks(updateRunnable)
    }
}
