package api.objects.service

import kotlinx.serialization.Serializable

@Serializable
data class Infos(
    val countryIso: String,
    val country: String,
    val isOpen: Boolean,
    val pop: String,
    val uploadToken: String,
    val uploadTokenLifetime: Long,
    val userToken: String,
    val offers: Array<Offer>
)