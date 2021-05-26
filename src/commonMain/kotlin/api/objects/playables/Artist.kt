package api.objects.playables

import kotlinx.serialization.Serializable

@Serializable
data class Artist(
    val id: Long, val type: String,
    val link: String, val share: String,
    val name: String,
    val picture: String,
    val pictureSmall: String,
    val pictureMedium: String,
    val pictureBig: String,
    val pictureXl: String,
    val nbAlbum: Int,
    val nbFan: Int,
    val radio: Boolean,
    val tracklist: String
)