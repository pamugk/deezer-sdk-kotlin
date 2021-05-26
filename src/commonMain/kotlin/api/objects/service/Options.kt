package api.objects.service

import kotlinx.serialization.Serializable

@Serializable
data class Options(
    val streaming: Boolean,
    val streamingDuration: Int,
    val offline: Boolean,
    val hq: Boolean,
    val adsDisplay: Boolean,
    val adsAudio: Boolean,
    val tooManyDevices: Boolean,
    val canSubscribe: Boolean,
    val radioSkips: Int,
    val lossless: Boolean,
    val preview: Boolean,
    val radio: Boolean
)