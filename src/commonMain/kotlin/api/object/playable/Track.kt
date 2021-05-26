package api.`object`.playable

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A track object
 */
@Serializable
data class Track(
    /**
     * The track's Deezer id
     */
    val id: Long,
    /**
     * If the track is readable in the player for the current user
     */
    val readable: Boolean,

    /**
     * The track's fulltitle
     */
    val title: String,
    /**
     * The track's short title
     */
    @SerialName("title_short") val titleShort: String,
    /**
     * The track version
     */
    @SerialName("title_version") val titleVersion: String,

    /**
     * The track unseen status
     */
    val unseen: Boolean? = null,
    /**
     * The track isrc
     */
    val isrc: String? = null,

    /**
     * The url of the track on Deezer
     */
    val link: String,
    /**
     * The share link of the track on Deezer
     */
    val share: String? = null,

    /**
     * The track's duration in seconds
     */
    val duration: Int,
    /**
     * The position of the track in its album
     */
    @SerialName("track_position") val trackPosition: Int? = null,
    /**
     * The track's album's disk number
     */
    @SerialName("disk_number") val diskNumber: Int? = null,
    /**
     * The track's Deezer rank
     */
    val rank: Int,
    /**
     * The track's release date
     */
    @SerialName("release_date") val releaseDate: LocalDate? = null,

    /**
     * Whether the track contains explicit lyrics
     */
    @SerialName("explicit_lyrics") val explicitLyrics: Boolean,
    /**
     * The explicit content lyrics
     */
    @SerialName("explicit_content_lyrics") val explicitContentLyrics: Explicity? = null,
    /**
     * The explicit cover value
     */
    @SerialName("explicit_content_cover") val explicitContentCover: Int? = null,

    /**
     * The url of track's preview file.
     * This file contains the first 30 seconds of the track
     */
    val preview: String,
    /**
     * Beats per minute
     */
    val bpm: Float? = null,
    /**
     * Signal strength
     */
    val gain: Float? = null,
    /**
     * List of countries where the track is available
     */
    @SerialName("available_countries") val availableCountries: List<String>? = null,
    /**
     * Return an alternative readable track if the current track is not readable
     */
    val alternative: Track? = null,

    /**
     * Return a list of contributors on the track
     */
    val contributors: List<Artist>? = null,
    @SerialName("md5_image") val md5Image: String? = null,
    /**
     * Artist object
     */
    val artist: Artist,
    /**
     * Album object
     */
    val album: Album? = null
)