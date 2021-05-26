package api.objects.compilations

import kotlinx.serialization.Serializable

@Serializable
data class Editorial(
    val id: Long, val type: String,
    var name: String,
    var picture: String,
    var pictureSmall: String,
    var pictureMedium: String,
    var pictureBig: String,
    var pictureXl: String
)