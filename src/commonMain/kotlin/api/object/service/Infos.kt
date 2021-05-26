package api.`object`.service

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Information about the API in the current country
 */
@Serializable
data class Infos(
    /**
     * The current country ISO code
     */
    @SerialName("country_iso") val countryIso: String,
    /**
     * The current country name
     */
    val country: String,
    /**
     * Indicates if Deezer is open in the current country or not
     */
    val open: Boolean,
    /**
     * An array of available offers in the current country
     */
    val offers: List<Offer>
)