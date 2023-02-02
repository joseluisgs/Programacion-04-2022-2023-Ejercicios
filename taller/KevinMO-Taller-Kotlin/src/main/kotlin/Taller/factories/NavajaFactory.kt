package Taller.factories

import Taller.models.Chapista
import Taller.models.NavajaSuiza

object NavajaFactory {

    fun crearNavaja(): NavajaSuiza {
        val arrayNombres = arrayOf("Einar", "Snake", "Patil", "Orman", "Thorkell", "Thorfinn", "Knud", "Askeladd", "Leif", "Thors",
            "Ari", "Sigurd", "Floki", "Halfdan", "Bjorn", "Ketil", "Ragnar", "Fox", "Radgar")

        val horas = (1..25).random()
        val nombre = arrayNombres.random()
        val años = (0..10).random()

        return NavajaSuiza(horas, nombre, años)
    }
}