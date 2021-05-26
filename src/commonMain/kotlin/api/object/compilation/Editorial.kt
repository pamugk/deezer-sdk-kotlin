package api.`object`.compilation

import api.`object`.util.bigPicture
import api.`object`.util.mediumPicture
import api.`object`.util.smallPicture
import api.`object`.util.xlPicture
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  An editorial object
 */
@Serializable
data class Editorial(
    /**
     * The editorial's Deezer id
     */
    val id: Long,
    /**
     * The editorial's name
     */
    val name: String,

    /**
     * The url of the editorial picture.
     */
    val picture: String,
    /**
     * The url of the editorial picture in size small.
     */
    @SerialName("picture_small") val pictureSmall: String = smallPicture(picture)!!,
    /**
     * The url of the editorial picture in size medium.
     */
    @SerialName("picture_medium") val pictureMedium: String = mediumPicture(picture)!!,
    /**
     * The url of the editorial picture in size big.
     */
    @SerialName("picture_big") val pictureBig: String = bigPicture(picture)!!,
    /**
     * The url of the editorial picture in size xl.
     */
    @SerialName("picture_xl") val pictureXl: String = xlPicture(picture)!!
)