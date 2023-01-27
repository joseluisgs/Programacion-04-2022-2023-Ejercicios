package simulacionBandaMusica.utils

import simulacionBandaMusica.enums.TipoGuitarra
import simulacionBandaMusica.enums.TipoPercusion
import java.util.*

object sorteoDatos {
    /**
     * Genera de manera aleatoria un nombre dentro de nuestro catálogo
     *
     * @return catalogoNombre[num], es el nombre aleatorio
     */
    fun randomName(): String {
        val r = Random()
        val num = r.nextInt(24)
        val catalogoNombres = arrayOf(
            "Pedro", "Alexandra", "Angel", "José",
            "Elena", "Ricardo", "Domingo", "Patricia",
            "Maribel", "Mariana", "Ivan", "Luis", "Mario", "Jorge", "Adrián", "Marcos", "Lara",
            "Marta", "Maria", "Claudia", "Sandra", "Fernando", "Roberto", "Marisa"
        )
        return catalogoNombres[num]
    }

    /**
     * Genera un número entre 1 y 35 (incluidos)
     *
     * @return años de experiencia
     */
    fun randomAnno(): Int {
        return (Math.random() * 35 + 1).toInt()
    }

    /**
     * Genera un número entre 1 y 10 (incluidos)
     *
     * @return capacidad pulmonar, evaluada como si fuera un examen del 1 al 10
     */
    fun randomPulmonarCapacity(): Int {
        return (Math.random() * 10 + 1).toInt()
    }

    /**
     * Genera un tipo de guitarra aleatoria (acústica y eléctrica)
     *
     * @return TipoGuitarra
     */
    fun randomTipoGuitarra(): TipoGuitarra {
        val sorteo = (Math.random() * 2 + 1).toInt()
        return if (sorteo == 1) {
            TipoGuitarra.ACUSTICA
        } else TipoGuitarra.ELECTRICA
    }

    /**
     * Genera un número entre 1 y 6 (incluidos)
     *
     * @return número de cuerdas que tendrá un bajista
     */
    fun randomNumCuerdas(): Int {
        return (Math.random() * 6 + 1).toInt()
    }

    /**
     * Genera un número entre 35 y 60 (incluidos)
     *
     * @return número de cuerdas que tendrá un bajista
     */
    fun randomNumTeclas(): Int {
        return (Math.random() * 25 + 35).toInt()
    }

    /**
     * Genera un tipo de percusión aleatoria
     *
     * @return TipoPercusion
     */
    fun randomTipoPercusion(): TipoPercusion {
        val sorteo = (Math.random() * 8 + 1).toInt()
        if (sorteo == 1) {
            return TipoPercusion.TAMBOR
        }
        if (sorteo == 2) {
            return TipoPercusion.TIMBAL
        }
        if (sorteo == 3) {
            return TipoPercusion.XILOFONO
        }
        if (sorteo == 4) {
            return TipoPercusion.CAMPANA
        }
        if (sorteo == 5) {
            return TipoPercusion.CROTALOS
        }
        if (sorteo == 6) {
            return TipoPercusion.CELESTA
        }
        return if (sorteo == 7) {
            TipoPercusion.CAJON
        } else TipoPercusion.TRIANGULO
    }
}