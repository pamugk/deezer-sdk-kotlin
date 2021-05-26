package api.objects.playables

import api.objects.User
import api.objects.search.SearchResponse
import kotlinx.serialization.Serializable

@Serializable
data class Playlist(
    val id: Long, val type: String,
    val link: String, val share: String,
    val title: String,
    val description: String,
    val duration: Int,
    val _public: Boolean,
    val isLovedTrack: Boolean,
    val collaborative: Boolean,
    val rating: Int,
    val nbTracks: Int,
    val unseenTrackCount: Int,
    val fans: Int,
    val picture: String,
    val pictureSmall: String,
    val pictureMedium: String,
    val pictureBig: String,
    val pictureXl: String,
    val checksum: String,
    val creator: User,
    val tracks: SearchResponse<Track>
)