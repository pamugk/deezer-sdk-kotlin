package api.`object`.playable

import api.`object`.User
import api.`object`.search.SearchResponse
import api.`object`.util.bigPicture
import api.`object`.util.mediumPicture
import api.`object`.util.smallPicture
import api.`object`.util.xlPicture
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A playlist object
 */
@Serializable
data class Playlist(
    /**
     * The playlist's Deezer id
     */
    val id: Long,
    /**
     * The playlist's title
     */
    val title: String,

    /**
     * The playlist description
     */
    val description: String? = null,
    /**
     * The playlist's duration (seconds)
     */
    val duration: Int? = null,
    /**
     * If the playlist is public or not
     */
    val public: Boolean,
    /**
     * If the playlist is the love tracks playlist
     */
    @SerialName("is_loved_track") val isLovedTrack: Boolean? = null,
    /**
     * If the playlist is collaborative or not
     */
    val collaborative: Boolean? = null,
    /**
     * The playlist's rate
     */
    val rating: Int? = null,

    /**
     * Nb tracks in the playlist
     */
    @SerialName("nb_tracks") val trackCount: Int? = null,
    /**
     * Nb tracks not seen
     */
    @SerialName("unseen_track_count") val unseenTrackCount: Int? = null,
    /**
     * The number of playlist's fans
     */
    @SerialName("fans") val fanCount: Int? = null,

    /**
     * The url of the playlist on Deezer
     */
    val link: String,
    /**
     * The share link of the playlist on Deezer
     */
    val share: String? = null,

    /**
     * The url of the playlist's cover
     */
    val picture: String,
    /**
     * The url of the playlist's cover in size small.
     */
    @SerialName("picture_small") val pictureSmall: String = smallPicture(picture)!!,
    /**
     * The url of the playlist's cover in size medium.
     */
    @SerialName("picture_medium") val pictureMedium: String = mediumPicture(picture)!!,
    /**
     * The url of the playlist's cover in size big.
     */
    @SerialName("picture_big") val pictureBig: String = bigPicture(picture)!!,
    /**
     * The url of the playlist's cover in size xl.
     */
    @SerialName("picture_xl") val pictureXl: String = xlPicture(picture)!!,

    /**
     * The checksum for the track list
     */
    val checksum: String? = null,
    /**
     * User object containing : id, name
     */
    val creator: User,
    /**
     * list of track
     */
    val tracks: SearchResponse<Track>? = null
)