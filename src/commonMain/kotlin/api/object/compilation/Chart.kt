package api.`object`.compilation

import api.`object`.playable.*
import api.`object`.search.SearchResponse
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable

/**
 * Charts of a specified genre
 */
@ExperimentalSerializationApi
@Serializable
data class Chart(
    /**
     * List of track
     */
    val tracks: SearchResponse<Track>,
    /**
     * List of album
     */
    val albums: SearchResponse<Album>,
    /**
     * List of artist
     */
    val artists: SearchResponse<Artist>,
    /**
     * List of playlist
     */
    val playlists: SearchResponse<Playlist>,
    /**
     * List of podcast
     */
    val podcasts: SearchResponse<Podcast>? = null
)