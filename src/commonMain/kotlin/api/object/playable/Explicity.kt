package api.`object`.playable

import api.`object`.util.ExplicitySerializer
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable

@ExperimentalSerializationApi
@Serializable(with = ExplicitySerializer::class)
enum class Explicity(val value: Int) {
    NOT_EXPLICIT(0),
    EXPLICIT(1),
    UNKNOWN(2),
    EDITED(3),
    PARTIALLY_EXPLICIT(4),
    PARTIALLY_UNKNOWN(5),
    NO_ADVICE_AVAILABLE(6),
    PARTIALLY_NO_ADVICE_AVAILABLE(7);

    companion object {
        fun valueOf(value: Int): Explicity = when(value) {
            0 -> NOT_EXPLICIT
            1 -> EXPLICIT
            2 -> UNKNOWN
            3 -> EDITED
            4 -> PARTIALLY_EXPLICIT
            5 -> PARTIALLY_UNKNOWN
            6 -> NO_ADVICE_AVAILABLE
            7 -> PARTIALLY_NO_ADVICE_AVAILABLE
            else -> throw Exception("Value is out of enum bounds")
        }
    }
}