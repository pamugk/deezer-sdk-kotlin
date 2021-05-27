package api

import api.`object`.user.User
import api.`object`.compilation.Chart
import api.`object`.compilation.Editorial
import api.`object`.playable.*
import api.`object`.search.AdvancedSearchQuery
import api.`object`.search.PartialSearchResponse
import api.`object`.search.SearchOrder
import api.`object`.search.SearchResponse
import api.`object`.service.Infos
import api.`object`.service.Options
import api.`object`.user.Folder
import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.request.*

class Deezer {
    private companion object {
        const val API_LINK = "https://api.deezer.com"

        const val ALBUM = "album"
        const val ARTIST = "artist"
        const val CHART = "chart"
        const val EDITORIAL = "editorial"
        const val GENRE = "genre"
        const val PLAYLIST = "playlist"
        const val RADIO = "radio"
        const val SEARCH = "search"
        const val TRACK = "track"
        const val USER = "user"

        const val ALBUMS = "albums"
        const val ARTISTS = "artists"
        const val CHARTS = "charts"
        const val FANS =  "fans"
        const val PLAYLISTS = "playlists"
        const val RADIOS = "radios"
        const val RECOMMENDATIONS = "recommendations"
        const val TRACKS = "tracks"

        fun chooseUser(id: Long? = null) = if (id != null) id else "me"
    }

    private val httpClient = HttpClient {
        install(JsonFeature)
    }

    private suspend fun <T> getPartial(url: String, index: Int? = null, limit: Int? = null):PartialSearchResponse<T> =
        httpClient.get(url) {
            parameter("index", index)
            parameter("limit", limit)
        }

    suspend fun getAlbum(id: Long): Album = httpClient.get("$API_LINK/$ALBUM/$id")

    /**
     * Return a list of album's fans
     */
    suspend fun getAlbumFans(id: Long, index: Int? = null, limit: Int?): PartialSearchResponse<User> =
        getPartial("$API_LINK/$ALBUM/$id/$FANS", index, limit)

    /**
     * Return a list of album's tracks
     */
    suspend fun getAlbumTracks(id: Long): SearchResponse<User> = httpClient.get("$API_LINK/$ALBUM/$id/$TRACKS")

    suspend fun getArtist(id: Long): Artist = httpClient.get("$API_LINK/$ARTIST/$id")

    /**
     * Get the top 5 tracks of an artist
     */
    suspend fun getArtistTop(id: Long): SearchResponse<Track> = httpClient.get("$API_LINK/$ARTIST/$id/top")

    /**
     * Return a list of artist's albums
     */
    suspend fun getArtistAlbums(id: Long, index: Int? = null, limit: Int?): PartialSearchResponse<Album> =
        getPartial("$API_LINK/$ARTIST/$id/$ALBUMS", index, limit)

    /**
     * Return a list of artist's fans
     */
    suspend fun getArtistFans(id: Long, index: Int? = null, limit: Int?): PartialSearchResponse<User> =
        getPartial("$API_LINK/$ARTIST/$id/$FANS", index, limit)

    /**
     * Return a list of related artists
     */
    suspend fun getArtistRelated(id: Long, index: Int? = null, limit: Int?): PartialSearchResponse<Artist> =
        getPartial("$API_LINK/$ARTIST/$id/related", index, limit)

    /**
     * Return a list of tracks
     */
    suspend fun getArtistRadio(id: Long, index: Int? = null, limit: Int?): PartialSearchResponse<Track> =
        getPartial("$API_LINK/$ARTIST/$id/$RADIO", index, limit)

    /**
     * Return a list of artist's playlists
     */
    suspend fun getArtistPlaylists(id: Long, index: Int? = null, limit: Int?): PartialSearchResponse<Playlist> =
        getPartial("$API_LINK/$ARTIST/$id/$PLAYLISTS", index, limit)

    suspend fun getChart(): Chart = httpClient.get("$API_LINK/$CHART")

    /**
     * Returns the Top tracks.
     */
    suspend fun getChartTracks(id: Long, index: Int? = null, limit: Int?): PartialSearchResponse<Track> =
        getPartial("$API_LINK/$CHART/$id/$TRACKS", index, limit)

    /**
     * Returns the Top albums.
     */
    suspend fun getChartAlbums(id: Long, index: Int? = null, limit: Int?): PartialSearchResponse<Album> =
        getPartial("$API_LINK/$CHART/$id/$ALBUMS", index, limit)

    /**
     * Returns the Top artists.
     */
    suspend fun getChartArtists(id: Long, index: Int? = null, limit: Int?): PartialSearchResponse<Artist> =
        getPartial("$API_LINK/$CHART/$id/$ARTISTS", index, limit)

    /**
     * Returns the Top playlists.
     */
    suspend fun getChartPlaylists(id: Long, index: Int? = null, limit: Int?): PartialSearchResponse<Playlist> =
        getPartial("$API_LINK/$CHART/$id/$PLAYLISTS", index, limit)

    /**
     * Returns the Top albums.
     */
    suspend fun getChartPodcasts(id: Long, index: Int? = null, limit: Int?): PartialSearchResponse<Podcast> =
        getPartial("$API_LINK/$CHART/$id/podcasts", index, limit)

    suspend fun getEditorial(index: Int? = null, limit: Int?): PartialSearchResponse<Editorial> =
        getPartial("$API_LINK/$EDITORIAL", index, limit)

    suspend fun getEditorial(id: Long): Editorial = httpClient.get("$API_LINK/$EDITORIAL/$id")

    /**
     * Return a list of albums selected every week by the Deezer Team.
     */
    suspend fun getEditorialSelection(id: Long): SearchResponse<Album> =
        httpClient.get("$API_LINK/$EDITORIAL/$id/selection")

    /**
     * This method returns four lists : Top track, Top album, Top artist and Top playlist.
     */
    suspend fun getEditorialCharts(id: Long): Chart = httpClient.get("$API_LINK/$EDITORIAL/$id/$CHARTS")

    /**
     * This method returns the new releases per genre for the current country
     */
    suspend fun getEditorialReleases(id: Long, index: Int? = null, limit: Int?): PartialSearchResponse<Album> =
        getPartial("$API_LINK/$CHART/$id/releases")

    suspend fun getGenre(id: Long): Genre = httpClient.get("$API_LINK/$GENRE/$id")

    /**
     * Returns all artists for a genre
     */
    suspend fun getGenreArtists(id: Long): SearchResponse<Artist> = httpClient.get("$API_LINK/$GENRE/$id/$ARTISTS")

    /**
     * Returns all radios for a genre
     */
    suspend fun getGenreRadios(id: Long): SearchResponse<Radio> = httpClient.get("$API_LINK/$GENRE/$id/radios")

    /**
     *  Get the information about the API in the current country
     */
    suspend fun getInfos(): Infos = httpClient.get("$API_LINK/infos")

    suspend fun getPlaylist(id: Long): Playlist = httpClient.get("$API_LINK/$PLAYLIST/$id")

    /**
     * Return a list of playlist's fans
     */
    suspend fun getPlaylistFans(id: Long, index: Int? = null, limit: Int?): PartialSearchResponse<User> =
        getPartial("$API_LINK/$PLAYLIST/$id/$FANS", index, limit)

    /**
     * Return a list of playlist's tracks
     */
    suspend fun getPlaylistTracks(id: Long): SearchResponse<Track> = httpClient.get("$API_LINK/$PLAYLIST/$id/$TRACKS")

    /**
     * Return a list of playlist's recommendation tracks
     */
    suspend fun getPlaylistRadio(id: Long): SearchResponse<Track> = httpClient.get("$API_LINK/$PLAYLIST/$id/$RADIO")

    suspend fun getRadio(): SearchResponse<Radio> = httpClient.get("$API_LINK/$RADIO")

    suspend fun getRadio(id: Long): Radio = httpClient.get("$API_LINK/$RADIO/$id")

    /**
     * Returns a list of radio splitted by genre
     */
    suspend fun getRadioGenres(): SearchResponse<Genre> = httpClient.get("$API_LINK/$RADIO/genres")

    /**
     * Return the top radios (default to 25 radios)
     */
    suspend fun getRadioTop(index: Int? = null, limit: Int? = null): PartialSearchResponse<Radio> =
        getPartial("$API_LINK/$RADIO/top", index, limit)

    /**
     * Get first 40 tracks in the radio
     */
    suspend fun getRadioTracks(id: Long): SearchResponse<Track> = httpClient.get("$API_LINK/$RADIO/$TRACKS")

    /**
     * Returns a list of personal radio splitted by genre (as MIX in website)
     */
    suspend fun getRadioLists(index: Int? = null, limit: Int? = null): PartialSearchResponse<Radio> =
        getPartial("$API_LINK/$RADIO/lists", index, limit)

    suspend fun getTrack(id: Long): Track = httpClient.get("$API_LINK/$TRACK/$id")

    suspend fun getUser(id: Long? = null): User = httpClient.get("$API_LINK/$USER/${chooseUser(id)}")

    suspend fun getUserChartsAlbums(id: Long? = null, index: Int? = null, limit: Int? = null): PartialSearchResponse<Album> =
        getPartial("$API_LINK/$USER/${chooseUser(id)}/$CHARTS/$ALBUMS", index, limit)

    suspend fun getUserChartsPlaylists(id: Long? = null, index: Int? = null, limit: Int? = null): PartialSearchResponse<Playlist> =
        getPartial("$API_LINK/$USER/${chooseUser(id)}/$CHARTS/$PLAYLISTS", index, limit)

    suspend fun getUserChartsTracks(id: Long? = null, index: Int? = null, limit: Int? = null): PartialSearchResponse<Track> =
        getPartial("$API_LINK/$USER/${chooseUser(id)}/$CHARTS/$TRACKS", index, limit)

    /**
     * Return a list of user's favorite albums
     */
    suspend fun getUserFavoriteAlbums(id: Long? = null): PartialSearchResponse<Album> =
        getPartial("$API_LINK/$USER/${chooseUser(id)}/$ALBUMS")

    /**
     * Return a list of user's favorite artists
     */
    suspend fun getUserFavoriteArtists(id: Long? = null): PartialSearchResponse<Artist> =
        getPartial("$API_LINK/$USER/${chooseUser(id)}/$ARTISTS")

    /**
     * Return a list of user's favorite Radios
     */
    suspend fun getUserFavoriteRadios(id: Long?, index: Int? = null, limit: Int? = null): PartialSearchResponse<Radio> =
        getPartial("$API_LINK/$USER/${chooseUser(id)}/$RADIOS", index, limit)

    /**
     * Return a list of user's favorite tracks
     */
    suspend fun getUserFavoriteTracks(id: Long?, index: Int? = null, limit: Int? = null): PartialSearchResponse<Radio> =
        getPartial("$API_LINK/$USER/${chooseUser(id)}/$TRACKS", index, limit)

    /**
     * Return a list of user's Folder
     */
    suspend fun getUserFolders(): SearchResponse<Folder> = httpClient.get("$API_LINK/$USER/${chooseUser()}/folders")

    /**
     * Return a list of user's followings
     */
    suspend fun getUserFollowings(id: Long?, index: Int? = null, limit: Int? = null): PartialSearchResponse<User> =
        getPartial("$API_LINK/$USER/${chooseUser(id)}/followings", index, limit)

    /**
     * Return a list of user's followers
     */
    suspend fun getUserFollowers(id: Long?, index: Int? = null, limit: Int? = null): PartialSearchResponse<User> =
        getPartial("$API_LINK/$USER/${chooseUser(id)}/followers", index, limit)

    suspend fun getUserFlow(id: Long? = null): SearchResponse<Track> = httpClient.get("$API_LINK/$USER/${chooseUser(id)}/flow")

    /**
     * Returns a list of the recently played tracks
     */
    suspend fun getUserHistory(index: Int? = null, limit: Int? = null): PartialSearchResponse<Track> =
        getPartial("$API_LINK/$USER/${chooseUser()}/history", index, limit)

    /**
     * Alias of /options
     */
    suspend fun getUserOptions(): Options = httpClient.get("$API_LINK/$USER/${chooseUser()}/options")

    /**
     * Return the user's Permissions granted to the application
     */
    suspend fun getUserPermissions(): SearchResponse<String> =
        httpClient.get("$API_LINK/$USER/${chooseUser()}/permissions")

    /**
     * Return a list of user's personnal song
     */
    suspend fun getUserPersonalSongs(index: Int? = null, limit: Int? = null): PartialSearchResponse<Track> =
        getPartial("$API_LINK/$USER/${chooseUser()}/personal_songs", index, limit)

    /**
     * Return a list of user's public Playlist.
     * Permission is needed to return private playlists
     */
    suspend fun getUserPlaylists(id: Long?, index: Int? = null, limit: Int? = null): PartialSearchResponse<Playlist> =
        getPartial("$API_LINK/$USER/${chooseUser(id)}/$PLAYLISTS", index, limit)

    /**
     * Return a list of albums recommendations
     */
    suspend fun getUserRecommendedAlbums(index: Int? = null, limit: Int? = null): PartialSearchResponse<Album> =
        getPartial("$API_LINK/$USER/${chooseUser()}/$RECOMMENDATIONS/$ALBUMS", index, limit)

    /**
     *  Return a list of artists recommendations
     */
    suspend fun getUserRecommendedArtists(index: Int? = null, limit: Int? = null): PartialSearchResponse<Artist> =
        getPartial("$API_LINK/$USER/${chooseUser()}/$RECOMMENDATIONS/$ARTISTS", index, limit)

    /**
     *  Return a list of playlists recommendations
     */
    suspend fun getUserRecommendedPlaylists(index: Int? = null, limit: Int? = null): PartialSearchResponse<Playlist> =
        getPartial("$API_LINK/$USER/${chooseUser()}/$RECOMMENDATIONS/$PLAYLISTS", index, limit)

    /**
     *  Return a list of radios recommendations
     */
    suspend fun getUserRecommendedRadios(index: Int? = null, limit: Int? = null): PartialSearchResponse<Radio> =
        getPartial("$API_LINK/$USER/${chooseUser()}/$RECOMMENDATIONS/$RADIOS", index, limit)

    /**
     * Return a list of released albums recommendations
     */
    suspend fun getUserRecommendedReleases(index: Int? = null, limit: Int? = null): PartialSearchResponse<Album> =
        getPartial("$API_LINK/$USER/${chooseUser()}/$RECOMMENDATIONS/releases", index, limit)

    /**
     *  Return a list of tracks recommendations
     */
    suspend fun getUserRecommendedTracks(index: Int? = null, limit: Int? = null): PartialSearchResponse<Track> =
        getPartial("$API_LINK/$USER/${chooseUser()}/$RECOMMENDATIONS/$TRACKS", index, limit)

    private suspend fun <T> search(
        url: String, query: String,
        index: Int? = null, limit: Int? = null,
        /**
         * Disable the fuzzy mode
         */
        strict: Boolean? = null,
        order: SearchOrder? = null): PartialSearchResponse<T> =
        httpClient.get(url) {
            parameter("q", query)
            parameter("strict", if (strict == null) null else if(strict) "on" else "off")
            parameter("order", order)
            parameter("index", index)
            parameter("limit", limit)
        }

    suspend fun search(
        query: String,
        index: Int? = null, limit: Int? = null,
        /**
         * Disable the fuzzy mode
         */
        strict: Boolean? = null,
        order: SearchOrder? = null): PartialSearchResponse<Track> =
        search("$API_LINK/$SEARCH", query, index, limit, strict, order)

    suspend fun search(
        query: AdvancedSearchQuery,
        index: Int? = null, limit: Int? = null,
        /**
         * Disable the fuzzy mode
         */
        strict: Boolean? = null,
        order: SearchOrder? = null): PartialSearchResponse<Track> =
        search("$API_LINK/$SEARCH", query.toString(), index, limit, strict, order)

    /**
     * Search albums
     */
    suspend fun searchAlbums(
        query: String,
        index: Int? = null, limit: Int? = null,
        /**
         * Disable the fuzzy mode
         */
        strict: Boolean? = null,
        order: SearchOrder? = null): PartialSearchResponse<Album> =
        search("$API_LINK/$SEARCH/$ALBUM", query, index, limit, strict, order)

    /**
     * Search artists
     */
    suspend fun searchArtists(
        query: String,
        index: Int? = null, limit: Int? = null,
        /**
         * Disable the fuzzy mode
         */
        strict: Boolean? = null,
        order: SearchOrder? = null): PartialSearchResponse<Artist> =
        search("$API_LINK/$SEARCH/$ARTIST", query, index, limit, strict, order)

    /**
     * Search playlists
     */
    suspend fun searchPlaylists(
        query: String,
        index: Int? = null, limit: Int? = null,
        /**
         * Disable the fuzzy mode
         */
        strict: Boolean? = null,
        order: SearchOrder? = null): PartialSearchResponse<Playlist> =
        search("$API_LINK/$SEARCH/$PLAYLIST", query, index, limit, strict, order)

    /**
     * Search radio
     */
    suspend fun searchRadio(
        query: String,
        index: Int? = null, limit: Int? = null,
        /**
         * Disable the fuzzy mode
         */
        strict: Boolean? = null,
        order: SearchOrder? = null): PartialSearchResponse<Radio> =
        search("$API_LINK/$SEARCH/$RADIO", query, index, limit, strict, order)

    /**
     * Search tracks
     */
    suspend fun searchTracks(
        query: String,
        index: Int? = null, limit: Int? = null,
        /**
         * Disable the fuzzy mode
         */
        strict: Boolean? = null,
        order: SearchOrder? = null): PartialSearchResponse<Track> =
        search("$API_LINK/$SEARCH/$TRACKS", query, index, limit, strict, order)

    /**
     * Search users
     */
    suspend fun searchUsers(
        query: String,
        index: Int? = null, limit: Int? = null,
        /**
         * Disable the fuzzy mode
         */
        strict: Boolean? = null,
        order: SearchOrder? = null): PartialSearchResponse<User> =
        search("$API_LINK/$SEARCH/$USER", query, index, limit, strict, order)

}