package jayyo.myflight.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import jayyo.myflight.data.Exchange
import jayyo.myflight.databinding.ItemExchangeBinding

class ExchangeAdapter(private val rates: Map<String, Double>) :
    RecyclerView.Adapter<ExchangeAdapter.ExchangeViewHolder>() {

    inner class ExchangeViewHolder(private val binding: ItemExchangeBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(currency: String, convertedAmount: Double) {
            binding.tvExchangeCurrency.text = currency
            binding.tvExchangeRate.text = "%.2f %s".format(convertedAmount, currency)
            binding.layoutExchange.setOnClickListener({
                Exchange.currency = currency

                println("amount: ${Exchange.amount}")
                println("currency: ${Exchange.currency}")
            })
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExchangeViewHolder {
        val binding = ItemExchangeBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ExchangeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ExchangeViewHolder, position: Int) {
        val currency = rates.keys.elementAt(position)
        val convertedAmount = rates[currency] ?: 0.0
        holder.bind(currency, convertedAmount)
    }

    override fun getItemCount(): Int = rates.size
}
