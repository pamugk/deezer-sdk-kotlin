package api.objects.playables

import kotlinx.serialization.Serializable

@Serializable
data class Radio(
    val id: Long, val type: String,
    val link: String, val share: String,
    val title: String,
    val description: String,
    val picture: String,
    val pictureSmall: String,
    val pictureMedium: String,
    val pictureBig: String,
    val pictureXl: String,
    val tracklist: String
)