package api.objects.playables

import api.objects.search.SearchResponse
import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable

@Serializable
data class Album(
    val id: Long, val type: String,
    val link: String, val share: String,
    val title: String,
    val upc: String,
    val cover: String,
    val coverSmall: String,
    val coverMedium: String,
    val coverBig: String,
    val coverXl: String,
    val genreId: Long,
    val genres: SearchResponse<Genre>,
    val label: String,
    val nbTracks: Int,
    val duration: Int,
    val fans: Int,
    val rating: Int,
    val releaseDate: LocalDate,
    val recordType: String,
    val isAvailable: String,
    val alternative: Album?,
    val tracklist: String,
    val explicitLyrics: Boolean,
    val explicitContentLyrics: Int,
    val explicitContentCover: Int,
    val contributors: List<Artist>?,
    val artist: Artist,
    val tracks: SearchResponse<Track>,
)