package repositories

import models.Reserva
import java.util.*

class ReservaRepositoryMemory: ReservaRepository {

    val incremento = 5

    var reservas: Array<Reserva?> = Array<Reserva?>(incremento){null}

    /**
     * función que sirve para obtener una reserva según su id
     * @param id el identificador de la reserva
     * @return la reserva encontrada o null si no encuentra nada
     */
    override fun getReservaById(id: UUID): Reserva? {
        var reserva: Reserva? = null
        val posicion = reservaNotExisting(id)
        if(posicion != -1){
            reserva = reservas[posicion]
        }
        return reserva
    }

    /**
     * función que sirve para conseguir un array con solo las reservas
     * @return el array que solo contiene reservas
     */
    override fun getAllReservas(): Array<Reserva?> {
        val array = Array<Reserva?>(numeroReservas()){null}
        var contador = 0
        for(reserva in reservas){
            if(reserva != null){
                array[contador] = reserva
                contador++
            }
        }
        return array
    }

    /**
     * función que sirve para crear una reserva y añadirla al array
     * @param reserva es la reserva que se quiere introducir al sistema
     * @return la reserva introducida al sistema o nulo si está no se introducio
     */
    override fun create(reserva: Reserva): Reserva? {
        var r: Reserva? = null
        if(numeroReservas() == reservas.size){
            redimensionarArray(incremento)
        }
        if(reservaNotExisting(reserva.id) == -1){
            reservas[numeroReservas()] = reserva
            r = reserva
        }
        return r
    }

    /**
     * función que sirve para actualizar una reserva
     * @param id es el identificador de la reserva a actualizar
     * @param reserva es la nueva reserva con la que actualizaremos la antigua
     * @return la reserva actualizada
     */
    override fun update(id: UUID, reserva: Reserva): Reserva? {
        var r: Reserva? = null
        val posicion = reservaNotExisting(id)
        if(posicion != -1){
            reservas[posicion] = reserva
            r = reserva
        }
        return r
    }

    /**
     * función que sirve para eliminar una reserva
     * @param id es el identificador de la reserva a eliminar
     * @return la reserva eliminada
     */
    override fun delete(id: UUID): Reserva? {
        var r: Reserva? = null
        val posicion = reservaNotExisting(id)
        if(posicion != -1){
            r = reservas[posicion]
            reservas[posicion] = null
            if(numeroReservas() + incremento <= reservas.size){
                redimensionarArray(-incremento)
            }
        }
        return r
    }

    /**
     * función que sirve para gaurdar un array de reservas
     * @param array es el array de reservas a guardar
     */
    override fun safeAll(array: Array<Reserva?>) {
        for(reserva in array){
            if(reserva != null) create(reserva)
        }
    }

    /**
     * función que sirve para borrar todas las reservas del array
     */
    override fun deleteAll() {
        for(reserva in reservas){
            if(reserva != null) delete(reserva.id)
        }
    }

    /**
     * función que sirve para comprobar si la reserva existe o no
     * @param id es el identificador de la reserva
     * @return -1 si no encuentra la reserva, o la posicion correspondiente a la casilla donde este la reserva
     */
    private fun reservaNotExisting(id: UUID): Int {
        var posicion = -1
        for(i in reservas.indices){
            if(reservas[i] != null && reservas[i]!!.id == id){
                posicion = i
                break
            }
        }
        return posicion
    }

    /**
     * función que sirve para conseguir el número de reservas actuales en el array
     * @return el numero de reservas
     */
    private fun numeroReservas(): Int {
        var contador = 0
        for(reserva in reservas){
            if(reserva != null){
                contador++
            }
        }
        return contador
    }

    /**
     * función que sirve para redimensionar el array de reservas, según el tamaño que se pase por parametro
     * @param tamaño es la cantidad con la que redimensionaremos el array, positiva y se ampliara, negativa y se restara
     */
    private fun redimensionarArray(tamaño: Int) {
        val array = Array<Reserva?>(reservas.size + tamaño){null}
        var contador = 0
        for(trabajador in reservas){
            if(trabajador != null){
                array[contador] = trabajador
                contador++
            }
        }
        reservas = array
    }
}