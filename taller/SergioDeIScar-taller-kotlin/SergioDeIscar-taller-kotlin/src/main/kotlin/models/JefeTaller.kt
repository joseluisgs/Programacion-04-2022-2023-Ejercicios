package taller.models

class JefeTaller(nombre: String, experiencia: Int): Persona(nombre, experiencia) {
    override val salario: Int = 2500
    constructor(nombre: String, experiencia: Int, trabajadores: Array<Trabajador>): this(nombre, experiencia){
        require(trabajadores.size in 1..this.trabajadores.size)
        for (i in trabajadores){
            addTrabajador(i)
        }
    }
    constructor(nombre: String, experiencia: Int, trabajadoresCount: Int): this(nombre, experiencia){
        this.trabajadores = Array(trabajadoresCount){ null }
    }

    private val trabajadoresCount = when(experiencia){
        in 0..5 -> 5
        in 6..15 -> 15
        else ->25
    }
    private var trabajadores = Array<Trabajador?>(trabajadoresCount){ null }
    override fun saludar() {
        println("El jefe $nombre saluda.")
    }

    fun darLatigazo(trabajador: Trabajador){
        if (!exitsTrabajador(trabajador)){
            println("El trabajador no esta bajo su cargo.")
            return
        }
        println("El jefe $nombre da latigazos a ${trabajador.nombre}")
    }

    //region CRUD
    fun addTrabajador(trabajador: Trabajador): Trabajador?{
        for (i in trabajadores.indices){
            if (trabajadores[i] == null){
                trabajadores[i] = trabajador
                return trabajador
            }
        }
        return null
    }

    fun removeTrabajador(trabajador: Trabajador): Boolean{
        val index = findTrabajador(trabajador)
        if (index == -1) return false
        return removeTrabajador(index)
    }

    fun removeTrabajador(index: Int): Boolean{
        if (index !in trabajadores.indices) return false
        trabajadores[index] = null
        return true
    }

    fun updateTrabajador(oldTrabajador: Trabajador, newTrabajador: Trabajador): Boolean{
        val index = findTrabajador(oldTrabajador)
        if (index == -1) return false
        return updateTrabajador(index, newTrabajador)
    }

    fun updateTrabajador(index: Int, newTrabajador: Trabajador): Boolean{
        if (!removeTrabajador(index)) return false
        trabajadores[index] = newTrabajador
        return true
    }

    fun findTrabajador(trabajador: Trabajador): Int{
        return trabajadores.indexOf(trabajador)
    }

    fun exitsTrabajador(trabajador: Trabajador): Boolean{
        return findTrabajador(trabajador) != -1
    }

    fun getTrabajador(index: Int): Trabajador?{
        require(index in trabajadores.indices)
        return trabajadores[index]
    }
    //endregion
}