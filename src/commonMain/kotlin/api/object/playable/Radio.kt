package api.`object`.playable

import api.`object`.util.bigPicture
import api.`object`.util.mediumPicture
import api.`object`.util.smallPicture
import api.`object`.util.xlPicture
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A radio object
 */
@Serializable
data class Radio(
    /**
     * The radio deezer ID
     */
    val id: Long,
    /**
     * The radio title
     */
    val title: String,
    /**
     * The radio description
     */
    val description: String,
    /**
     * The share link of the radio on Deezer
     */
    val share: String,

    /**
     * The url of the radio picture
     */
    val picture: String,
    /**
     * The url of the radio picture in size small.
     */
    @SerialName("picture_small") val pictureSmall: String = smallPicture(picture)!!,
    /**
     * The url of the radio picture in size medium.
     */
    @SerialName("picture_medium") val pictureMedium: String = mediumPicture(picture)!!,
    /**
     * The url of the radio picture in size big.
     */
    @SerialName("picture_big") val pictureBig: String = bigPicture(picture)!!,
    /**
     * The url of the radio picture in size xl.
     */
    @SerialName("picture_xl") val pictureXl: String = xlPicture(picture)!!,

    /**
     * API Link to the tracklist of this radio
     */
    val tracklist: String,

    @SerialName("md5_image") val md5Image: String
)