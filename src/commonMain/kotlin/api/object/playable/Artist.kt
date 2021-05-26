package api.`object`.playable

import api.`object`.util.bigPicture
import api.`object`.util.mediumPicture
import api.`object`.util.smallPicture
import api.`object`.util.xlPicture
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  An artist object
 */
@Serializable
data class Artist(
    /**
     * The artist's Deezer id
     */
    val id: Long,
    /**
     * The artist's name
     */
    val name: String,

    /**
     * The url of the artist on Deezer
     */
    val link: String? = null,
    /**
     * The share link of the artist on Deezer
     */
    val share: String? = null,

    /**
     * The url of the artist picture
     */
    val picture: String? = null,
    /**
     * The url of the artist picture in size small.
     */
    @SerialName("picture_small") val pictureSmall: String? = smallPicture(picture),
    /**
     * The url of the artist picture in size medium.
     */
    @SerialName("picture_medium") val pictureMedium: String? = mediumPicture(picture),
    /**
     * The url of the artist picture in size big.
     */
    @SerialName("picture_big") val pictureBig: String? = bigPicture(picture),
    /**
     * The url of the artist picture in size xl.
     */
    @SerialName("picture_xl") val pictureXl: String? = xlPicture(picture),

    /**
     * The number of artist's albums
     */
    @SerialName("nb_album") val albumCount: Int? = null,
    /**
     * The number of artist's fans
     */
    @SerialName("nb_fan") val fanCount: Int? = null,
    /**
     * If the artist has a smartradio
     */
    val radio: Boolean? = null,
    /**
     * API Link to the top of this artist
     */
    val tracklist: String? = null
)