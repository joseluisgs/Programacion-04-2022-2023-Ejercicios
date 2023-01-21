package bandamusical.interfeces

import bandamusical.models.TonoType

interface ICantante {
    val tono: TonoType
    fun cantar()
}