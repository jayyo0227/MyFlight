package jayyo.myflight.model

import com.google.gson.annotations.SerializedName

data class ExchangeResponse(
    @SerializedName("data")
    val data: Map<String, Double>
)
