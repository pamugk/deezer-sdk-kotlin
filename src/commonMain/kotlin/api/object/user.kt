package api.`object`

import api.`object`.util.bigPicture
import api.`object`.util.mediumPicture
import api.`object`.util.smallPicture
import api.`object`.util.xlPicture
import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  A user object
 */
@Serializable
data class User(
    /**
     * The user's Deezer ID
     */
    val id: Long,
    /**
     * The user's Deezer nickname
     */
    val name: String,

    /**
     * The user's last name
     */
    val lastname: String? = null,
    /**
     * The user's first name
     */
    val firstname: String? = null,

    /**
     * The user's email
     */
    val email: String? = null,
    /**
     * The user's status
     */
    val status: Int? = null,
    /**
     * The user's birthday
     */
    val birthday: String? = null,
    /**
     * The user's inscription date
     */
    @SerialName("inscription_date") val inscriptionDate: LocalDate? = null,
    /**
     * The user's gender
     */
    val gender: Gender? = null,
    /**
     * The url of the profil for the user on Deezer
     */
    val link: String? = null,

    /**
     * The url of the user's profil picture
     */
    val picture: String? = null,
    /**
     * The url of the user's profil picture in size small.
     */
    @SerialName("picture_small") val pictureSmall: String? = smallPicture(picture),
    /**
     * The url of the user's profil picture in size medium.
     */
    @SerialName("picture_medium") val pictureMedium: String? = mediumPicture(picture),
    /**
     * The url of the user's profil picture in size big.
     */
    @SerialName("picture_big") val pictureBig: String? = bigPicture(picture),
    /**
     * The url of the user's profil picture in size xl.
     */
    @SerialName("picture_xl") val pictureXl: String? = xlPicture(picture),

    /**
     * The user's country
     */
    val country: String? = null,
    /**
     * The user's language
     */
    val lang: String? = null,

    /**
     * If the user is a kid or not
     */
    @SerialName("is_kid") val isKid: Boolean? = null,
    /**
     * The user's explicit content level according to his country
     */
    @SerialName("explicit_content_level") val explicitContentLevel: String? = null,
    /**
     * The user's available explicit content levels according to his country
     */
    @SerialName("explicit_content_levels_available") val explicitContentLevelsAvailable: List<String>? = null,

    /**
     * API Link to the flow of this user
     */
    val tracklist: String? = null
)

@Serializable
enum class Gender {
    @SerialName("M") MALE,
    @SerialName("F") FEMALE
}

@Serializable
enum class ContentExplicity {
    @SerialName("explicit_display") EXPLICIT_DISPLAY,
    @SerialName("explicit_no_recommendation") EXPLICIT_NO_RECCOMMENDATION,
    @SerialName("explicit_hide") EXPLICIT_HIDE
}