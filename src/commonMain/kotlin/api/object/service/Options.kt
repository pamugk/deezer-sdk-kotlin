package api.`object`.service

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * User's options
 */
@Serializable
data class Options(
    /**
     * If the user can stream on the platform
     */
    val streaming: Boolean,
    /**
     * The streaming duration of the user
     */
    @SerialName("streaming_duration") val streamingDuration: Int,
    /**
     * The user can listen to the music in offline mode
     */
    val offline: Boolean,
    /**
     * The HQ can be activated
     */
    val hq: Boolean,

    /**
     * Displays ads
     */
    @SerialName("ads_display") val adsDisplay: Boolean,
    /**
     * Activates audio ads
     */
    @SerialName("ads_audio") val adsAudio: Boolean,

    /**
     * If the user reached the limit of linked devices
     */
    @SerialName("too_many_devices") val tooManyDevices: Boolean,
    /**
     * If the user can subscribe to the service
     */
    @SerialName("can_subscribe") val canSubscribe: Boolean,
    /**
     * The limit of radio skips. 0 = no limit
     */
    @SerialName("radio_skips") val radioSkips: Int,
    /**
     * Lossless is available
     */
    val lossless: Boolean,

    /**
     * Allows to display the preview of the tracks
     */
    val preview: Boolean,
    /**
     * Allows to stream the radio
     */
    val radio: Boolean
)