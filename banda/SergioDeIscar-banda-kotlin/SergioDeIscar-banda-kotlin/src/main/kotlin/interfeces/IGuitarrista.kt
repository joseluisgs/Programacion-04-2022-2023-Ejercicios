package bandamusical.interfeces

import bandamusical.models.GuitarraType

interface IGuitarrista {
    val guitarra: GuitarraType
    fun guitarrear()
}