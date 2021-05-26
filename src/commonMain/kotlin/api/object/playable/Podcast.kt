package api.`object`.playable

import api.`object`.util.bigPicture
import api.`object`.util.mediumPicture
import api.`object`.util.smallPicture
import api.`object`.util.xlPicture
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Podcast(
    /**
     * The podcast's Deezer id
     */
    val id: Long,
    /**
     * The podcast's title
     */
    val title: String,

    /**
     * The podcast's description
     */
    val description: String,
    /**
     * If the podcast is available or not
     */
    val available: Boolean,
    /**
     * The playlist's rate
     */
    val rating: Int,
    /**
     * The number of playlist's fans
     */
    @SerialName("fans") val fanCount: Int,

    /**
     * The url of the podcast on Deezer
     */
    val link: String,
    /**
     * The share link of the podcast on Deezer
     */
    val share: String,

    /**
     * The url of the artist picture
     */
    val picture: String,
    /**
     * The url of the artist picture in size small.
     */
    @SerialName("picture_small") val pictureSmall: String = smallPicture(picture)!!,
    /**
     * The url of the artist picture in size medium.
     */
    @SerialName("picture_medium") val pictureMedium: String = mediumPicture(picture)!!,
    /**
     * The url of the artist picture in size big.
     */
    @SerialName("picture_big") val pictureBig: String = bigPicture(picture)!!,
    /**
     * The url of the artist picture in size xl.
     */
    @SerialName("picture_xl") val pictureXl: String = xlPicture(picture)!!,

    /**
     * The position of the podcasts in the charts
     */
    val position: Int
)