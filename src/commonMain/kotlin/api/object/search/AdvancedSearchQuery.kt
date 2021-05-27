package api.`object`.search

class AdvancedSearchQuery(
    val artist: String? = null,
    val album: String? = null,
    val track: String? = null,
    val label: String? = null,
    val durMin: Int? = null,
    val durMax: Int? = null,
    val bpmMin: Int? = null,
    val bpmMax: Int? = null
) {
    private fun String.parameter(parameterName: String, parameter: String?) =
        if (parameter == null) this else "${this}${if (this.length == 0) "" else " "}$parameterName: ${parameter}"

    private fun String.parameter(parameterName: String, parameter: Int?) =
        if (parameter == null) this else "${this}${if (this.length == 0) "" else " "}$parameterName:$parameter"

    private val queryString = ""
        .parameter("artist", artist)
        .parameter("album", album)
        .parameter("track", track)
        .parameter("label", label)
        .parameter("dur_min", durMin)
        .parameter("dur_max", durMax)
        .parameter("bpm_min", bpmMin)
        .parameter("bpmMax", bpmMax)

    override fun toString(): String {
        return queryString
    }
}