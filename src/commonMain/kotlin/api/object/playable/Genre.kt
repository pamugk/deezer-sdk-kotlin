package api.`object`.playable

import api.`object`.util.bigPicture
import api.`object`.util.mediumPicture
import api.`object`.util.smallPicture
import api.`object`.util.xlPicture
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A genre object
 */
@Serializable
data class Genre(
    /**
     * The editorial's Deezer id
     */
    val id: Long,
    /**
     * The editorial's name
     */
    val name: String,

    /**
     * The url of the genre picture
     */
    val picture: String,
    /**
     * The url of the genre picture in size small
     */
    @SerialName("picture_small") val pictureSmall: String = smallPicture(picture)!!,
    /**
     * The url of the genre picture in size medium.
     */
    @SerialName("picture_medium") val pictureMedium: String = mediumPicture(picture)!!,
    /**
     * The url of the genre picture in size big.
     */
    @SerialName("picture_big") val pictureBig: String = bigPicture(picture)!!,
    /**
     * The url of the genre picture in size xl.
     */
    @SerialName("picture_xl") val pictureXl: String = xlPicture(picture)!!
)