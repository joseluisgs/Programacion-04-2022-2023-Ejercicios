package factories

import models.*

class MusicoFactories private constructor() {

    companion object {
        private var instace: MusicoFactories? = null
        fun getInstance(): MusicoFactories {
            if (instace == null) {
                instace = MusicoFactories()
            }
            return instace!!
        }
    }


    private val arrayNombres = arrayOf(
        "Aaran",
        "Aaren",
        "Aarez",
        "Bertie",
        "Bevin",
        "Loche",
        "Lochlan",
        "Lochlann",
        "Lochlan-Oliver",
        "Lock",
        "Lockey",
        "Logan",
        "Logann",
        "Logan-Rhys",
        "Loghan",
        "Lokesh",
        "Loki",
        "Lomond",
        "Lorcan",
        "Lorenz",
    )
    private val arrayApellidos = arrayOf(
        "Schaefer",
        "Madden",
        "Waller",
        "Dunn",
        "Erickson",
        "Barber",
        "Watson",
        "Wilson",
        "Evans",
        "Mcconnell",
        "Barber"
    )
    private val arrayEdad = arrayOf(10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60, 65, 70, 75, 80, 85)
    private val arrayAnosExperiencia = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9)


    fun createCantanteRandom(): Cantante {
        val nombre = arrayNombres.random()
        val apellido = arrayApellidos.random()
        val edad = arrayEdad.random()
        val anosExperiencia = arrayAnosExperiencia.random()

        return Cantante(nombre, apellido, edad, anosExperiencia)
    }

    fun createBajistaRandom(): Bajista {
        val nombre = arrayNombres.random()
        val apellido = arrayApellidos.random()
        val edad = arrayEdad.random()
        val anosExperiencia = arrayAnosExperiencia.random()

        return Bajista(nombre, apellido, edad, anosExperiencia)
    }

    fun createGuitarristaRandom(): Guitarrista {
        val nombre = arrayNombres.random()
        val apellido = arrayApellidos.random()
        val edad = arrayEdad.random()
        val anosExperiencia = arrayAnosExperiencia.random()

        return Guitarrista(nombre, apellido, edad, anosExperiencia)
    }

    fun createCantante_que_toca_la_guitarraRandom(): Cantante_que_toca_la_guitarra {
        val nombre = arrayNombres.random()
        val apellido = arrayApellidos.random()
        val edad = arrayEdad.random()
        val anosExperiencia = arrayAnosExperiencia.random()

        return Cantante_que_toca_la_guitarra(nombre, apellido, edad, anosExperiencia)
    }

    fun createMultinstrumentistaRandom(): Multinstrumentista {
        val nombre = arrayNombres.random()
        val apellido = arrayApellidos.random()
        val edad = arrayEdad.random()
        val anosExperiencia = arrayAnosExperiencia.random()

        return Multinstrumentista(nombre, apellido, edad, anosExperiencia)
    }


    fun createPercusionistaRandom(): Percusionista {
        val nombre = arrayNombres.random()
        val apellido = arrayApellidos.random()
        val edad = arrayEdad.random()
        val anosExperiencia = arrayAnosExperiencia.random()

        return Percusionista(nombre, apellido, edad, anosExperiencia)
    }

    fun createTeclistaRandom(): Teclista {
        val nombre = arrayNombres.random()
        val apellido = arrayApellidos.random()
        val edad = arrayEdad.random()
        val anosExperiencia = arrayAnosExperiencia.random()

        return Teclista(nombre, apellido, edad, anosExperiencia)
    }

    fun createTrompetistaRandom(): Trompetista {
        val nombre = arrayNombres.random()
        val apellido = arrayApellidos.random()
        val edad = arrayEdad.random()
        val anosExperiencia = arrayAnosExperiencia.random()

        return Trompetista(nombre, apellido, edad, anosExperiencia)
    }


}