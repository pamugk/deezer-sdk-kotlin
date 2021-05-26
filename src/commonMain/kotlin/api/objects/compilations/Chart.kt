package api.objects.compilations

import api.objects.playables.Album
import api.objects.playables.Artist
import api.objects.playables.Playlist
import api.objects.playables.Track
import api.objects.search.SearchResponse
import kotlinx.serialization.Serializable

@Serializable
data class Chart(
    val id: Long, val type: String,
    val tracks: SearchResponse<Track>,
    val albums: SearchResponse<Album>,
    val artists: SearchResponse<Artist>,
    val playlists: SearchResponse<Playlist>
)