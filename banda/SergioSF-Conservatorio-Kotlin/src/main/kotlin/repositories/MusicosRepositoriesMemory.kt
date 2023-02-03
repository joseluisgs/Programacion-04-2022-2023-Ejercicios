package repositories

import factories.MusicoFactories
import models.Especialidad
import models.Musico


class MusicosRepositoriesMemory : MusicosRepository {
    private val plazas = 50
    private val band = Array<Musico?>(this.plazas) { null }

    init {
        createCantante()
        createTrompetista()
        createGuitarrista()
        createBajistas()
        createTeclista()
        createPercusionista()
        createMultinstrumentista()
        createcantanteQueTocaLaGuitarra()
    }

    override fun getAll(): Array<Musico> {
        val result = Array<Musico?>(numberOfMusicos()) { null }
        var i = 0
        for (Musico in band) {
            if (Musico != null) {
                result[i] = Musico
                i++
            }
        }
        return result as Array<Musico>
    }

    override fun getSalarioTotal(): Int {
        var salarioTotal = 0
        for (Musico in band) {
            salarioTotal += Musico?.salario!!
        }
        return salarioTotal
    }

    override fun getSalarioMusico() {
        for (Musico in band) {
            println("Hola soy ${Musico?.nombre} toco ${Musico?.instrumento} y mi salario es: ${Musico?.salario!!}€")
        }
    }

    override fun getConocerMusico() {
        for (Musico in band) {
            println("Hola soy ${Musico?.nombre} ${Musico?.apellidos} toco ${Musico?.instrumento}, soy un/a ${Musico?.especialidad} y tengo ${Musico?.anosExperiencia} años de experiencia")
        }
    }

    override fun getBuscarByNombre(nombre: String) {
        var isMusicoExist = false
        for (Musico in band) {
            if (Musico?.nombre == nombre) {
                println("Hola soy ${Musico?.nombre} ${Musico?.apellidos} toco ${Musico?.instrumento}, soy un/a ${Musico?.especialidad} y tengo ${Musico?.anosExperiencia} años de experiencia")
                isMusicoExist = true
            }
        }
        if (!isMusicoExist) {
            println("Musico no encontrado")
        }
    }

    override fun getMusicoSalarioByEspecialidad() {
        for (Musico in band) {
            if (Musico?.especialidad == Especialidad.BAJISTA) {
                println("Salario de un ${Musico?.especialidad} cobro ${Musico.salario}€")
                break
            }
        }
        for (Musico in band) {
            if (Musico?.especialidad == Especialidad.TROMPETISTA) {
                println("Salario de un ${Musico?.especialidad} cobro ${Musico.salario}€")
                break
            }
        }
        for (Musico in band) {
            if (Musico?.especialidad == Especialidad.TECLISTA) {
                println("Salario de un ${Musico?.especialidad} cobro ${Musico.salario}€")
                break
            }
        }
        for (Musico in band) {
            if (Musico?.especialidad == Especialidad.PERCUSIONISTA) {
                println("Salario de un ${Musico?.especialidad} cobro ${Musico.salario}€")
                break
            }
        }
        for (Musico in band) {
            if (Musico?.especialidad == Especialidad.GUITARRISTA) {
                println("Salario de un ${Musico?.especialidad} cobro ${Musico.salario}€")
                break
            }
        }
        for (Musico in band) {
            if (Musico?.especialidad == Especialidad.MULTINSTRUMENTISTA) {
                println("Salario de un ${Musico?.especialidad} cobro ${Musico.salario}€")
                break
            }
        }
        for (Musico in band) {
            if (Musico?.especialidad == Especialidad.CANTANTE) {
                println("Salario de un ${Musico?.especialidad} cobro ${Musico.salario}€")
                break
            }
        }
    }

    private var representacion: Int = 0
    private var ocupacion = 0

    private fun createBajistas() {
        representacion = 10
        ocupacion = (plazas * representacion) / 100
        var contador: Int = 0
        for (i in 0 until plazas) {
            if (band[i] == null && ocupacion > contador) {
                band[i] = MusicoFactories.getInstance().createBajistaRandom()
                contador++
            }
        }


    }

    private fun createTrompetista() {
        representacion = 6
        ocupacion = (plazas * representacion) / 100
        var contador: Int = 0
        for (i in 0 until plazas) {
            if (band[i] == null && ocupacion > contador) {
                band[i] = MusicoFactories.getInstance().createTrompetistaRandom()
                contador++
            }
        }
    }

    private fun createCantante() {
        representacion = 20
        ocupacion = (plazas * representacion) / 100
        var contador: Int = 0
        for (i in 0 until plazas) {
            if (band[i] == null && ocupacion > contador) {
                band[i] = MusicoFactories.getInstance().createCantanteRandom()
                contador++
            }
        }
    }

    private fun createcantanteQueTocaLaGuitarra() {
        representacion = 16
        ocupacion = (plazas * representacion) / 100
        var contador: Int = 0
        for (i in 0 until plazas) {
            if (band[i] == null && ocupacion > contador) {
                band[i] = MusicoFactories.getInstance().createCantante_que_toca_la_guitarraRandom()
                contador++
            }
        }
    }

    private fun createGuitarrista() {
        representacion = 20
        ocupacion = (plazas * representacion) / 100
        var contador: Int = 0
        for (i in 0 until plazas) {
            if (band[i] == null && ocupacion > contador) {
                band[i] = MusicoFactories.getInstance().createGuitarristaRandom()
                contador++
            }
        }
    }

    private fun createMultinstrumentista() {
        representacion = 4
        ocupacion = (plazas * representacion) / 100
        var contador: Int = 0
        for (i in 0 until plazas) {
            if (band[i] == null && ocupacion > contador) {
                band[i] = MusicoFactories.getInstance().createMultinstrumentistaRandom()
                contador++
            }
        }
    }

    private fun createTeclista() {
        representacion = 10
        ocupacion = (plazas * representacion) / 100
        var contador: Int = 0
        for (i in 0 until plazas) {
            if (band[i] == null && ocupacion > contador) {
                band[i] = MusicoFactories.getInstance().createTeclistaRandom()
                contador++
            }
        }
    }

    private fun createPercusionista() {
        representacion = 14
        ocupacion = (plazas * representacion) / 100
        var contador: Int = 0
        for (i in 0 until plazas) {
            if (band[i] == null && ocupacion > contador) {
                band[i] = MusicoFactories.getInstance().createPercusionistaRandom()
                contador++
            }
        }
    }

    fun numberOfMusicos(): Int {
        var count = 0
        for (Musico in band) {
            if (Musico != null) {
                count++
            }
        }
        return count
    }
}
