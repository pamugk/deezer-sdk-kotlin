package api.objects.playables

import kotlinx.serialization.Serializable

@Serializable
data class Genre(
    val id: Long, val type: String,
    val name: String,
    val picture: String,
    val pictureSmall: String,
    val pictureMedium: String,
    val pictureBig: String,
    val pictureXl: String
)