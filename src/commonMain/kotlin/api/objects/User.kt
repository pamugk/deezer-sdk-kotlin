package api.objects

import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable

@Serializable
data class User(
    val id: Long, val type: String,
    val name: String,
    val lastname: String,
    val firstname: String,
    val email: String,
    val status: Int,
    val birthday: String,
    val inscriptionDate: LocalDate,
    val gender: String,
    val link: String,
    val picture: String,
    val pictureSmall: String,
    val pictureMedium: String,
    val pictureBig: String,
    val pictureXl: String,
    val country: String,
    val lang: String,
    val isKid: Boolean,
    val explicitContentLevel: String,
    val explicitContentLevelsAvailable: Array<String>,
    val tracklist: String
)