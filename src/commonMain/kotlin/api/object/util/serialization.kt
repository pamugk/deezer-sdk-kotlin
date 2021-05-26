package api.`object`.util

import api.`object`.playable.Explicity
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

@ExperimentalSerializationApi
@Serializer(forClass = Explicity::class)
object ExplicitySerializer {
    override fun deserialize(decoder: Decoder): Explicity {
        return Explicity.valueOf(decoder.decodeInt())
    }

    override val descriptor: SerialDescriptor
        get() = PrimitiveSerialDescriptor("Explicity", PrimitiveKind.INT)

    override fun serialize(encoder: Encoder, value: Explicity) {
        encoder.encodeInt(value.value)
    }

}