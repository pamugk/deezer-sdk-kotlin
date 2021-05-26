package api.`object`.playable

import api.`object`.search.SearchResponse
import api.`object`.util.bigPicture
import api.`object`.util.mediumPicture
import api.`object`.util.smallPicture
import api.`object`.util.xlPicture
import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  An album object
 */
@Serializable
data class Album(
    /**
     * The Deezer album id
     */
    val id: Long,
    /**
     * The album title
     */
    val title: String,
    /**
     * The album UPC
     */
    val upc: String? = null,

    /**
     * The url of the album on Deezer
     */
    val link: String,
    /**
     * The share link of the album on Deezer
     */
    val share: String? = null,

    /**
     * The url of the album's cover
     */
    val cover: String,
    /**
     * The url of the album's cover in size small.
     */
    @SerialName("cover_small") val coverSmall: String = smallPicture(cover)!!,
    /**
     * The url of the album's cover in size medium.
     */
    @SerialName("cover_medium") val coverMedium: String = mediumPicture(cover)!!,
    /**
     * The url of the album's cover in size big.
     */
    @SerialName("cover_big") val coverBig: String = bigPicture(cover)!!,
    /**
     * The url of the album's cover in size xl.
     */
    @SerialName("cover_xl") val coverXl: String = xlPicture(cover)!!,
    @SerialName("md5_image") val md5Image: String? = null,

    /**
     * The album's first genre id (You should use the genre list instead). NB : -1 for not found
     */
    @SerialName("genre_id") val genreId: Long? = null,
    /**
     * List of genre object
     */
    val genres: SearchResponse<Genre>? = null,

    /**
     * The album's label name
     */
    val label: String,
    @SerialName("nb_tracks") val trackCount: Int? = null,
    /**
     * The album's duration (seconds)
     */
    val duration: Int? = null,
    /**
     * The number of album's Fans
     */
    @SerialName("fans") val fanCount: Int? = null,
    /**
     * The album's rate
     */
    val rating: Int? = null,
    /**
     * The album's release date
     */
    @SerialName("release_date") val releaseDate: LocalDate? = null,

    /**
     * The record type of the album (EP / ALBUM / etc..)
     */
    @SerialName("record_type") val recordType: String? = null,
    val available: Boolean,
    /**
     * Return an alternative album object if the current album is not available
     */
    val alternative: Album? = null,

    /**
     * API Link to the tracklist of this album
     */
    val tracklist: String? = null,

    /**
     * Whether the album contains explicit lyrics
     */
    @SerialName("explicit_lyrics") val explicitLyrics: Boolean? = null,
    /**
     * 	The explicit content lyrics values
     */
    @SerialName("explicit_content_lyrics") val explicitContentLyrics: Explicity? = null,
    /**
     * The explicit cover values
     */
    @SerialName("explicit_content_cover") val explicitContentCover: Explicity? = null,

    /**
     * The position of the album in the charts
     */
    val position: Int? = null,
    /**
     * Return a list of contributors on the album
     */
    val contributors: List<Artist>? = null,
    /**
     * Artist object
     */
    val artist: Artist? = null,
    /**
     * List of track
     */
    val tracks: SearchResponse<Track>? = null,
)