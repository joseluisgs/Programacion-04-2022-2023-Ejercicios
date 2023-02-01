package controllers

import exceptions.ReservaAlreadyExisting
import exceptions.ReservaBadRequest
import exceptions.ReservaEmpty
import exceptions.ReservaNotFound
import models.Habitacion
import models.Reserva
import repositories.ReservaRepository
import java.time.LocalDate
import java.util.*

class ReservaController(
    private val repository: ReservaRepository
) {

    /**
     * función que sirve para conseguir una reserva según su id
     * @param id el identificador de la reserva a buscar
     * @return la reserva conseguida
     * @throws ReservaNotFound si no se encontro la reserva
     */
    fun getReservaById(id: UUID): Reserva {
        comprobarArrayNoEstaVacio()
        return repository.getReservaById(id) ?: throw ReservaNotFound("Error del sistema: No se ha encontrado la reserva pedida.")
    }

    /**
     * función que sirve para conseguir un array con solo las reservas
     * @return el array que solo contiene reservas
     */
    fun getAllReservas(): Array<Reserva?> {
        comprobarArrayNoEstaVacio()
        return repository.getAllReservas()
    }

    /**
     * función que sirve para  añadir una reserva
     * @param reserva es la reserva que se quiere introducir al sistema
     * @return la reserva introducida al sistema
     * @throws ReservaNotFound si no se encontro la reserva
     */
    fun create(reserva: Reserva): Reserva {
        comprobarDatosReserva(reserva)
        return repository.create(reserva) ?: throw ReservaAlreadyExisting("Error del sistema: La reserva introducida ya existía.")
    }

    /**
     * función que sirve para actualizar una reserva
     * @param id es el identificador de la reserva a actualizar
     * @param reserva es la nueva reserva con la que actualizaremos la antigua
     * @return la reserva actualizada
     * @throws ReservaNotFound si no se encontro la reserva
     */
    fun update(id: UUID, reserva: Reserva): Reserva {
        comprobarArrayNoEstaVacio()
        comprobarDatosReserva(reserva)
        return repository.update(id, reserva) ?: throw ReservaNotFound("Error del sistema: No se ha encontrado la reserva pedida.")
    }

    /**
     * función que sirve para eliminar una reserva
     * @param id es el identificador de la reserva a eliminar
     * @return la reserva eliminada
     * @throws ReservaNotFound si no se encontro la reserva
     */
    fun delete(id: UUID): Reserva? {
        comprobarArrayNoEstaVacio()
        return repository.delete(id) ?: throw ReservaNotFound("Error del sistema: No se ha encontrado la reserva pedida")
    }

    /**
     * función que sirve para gaurdar un array de reservas
     * @param array es el array de reservas a guardar
     */
    fun safeAll(array: Array<Reserva?>) {
        for(reserva in array){
            comprobarDatosReserva(reserva!!)
        }
        repository.safeAll(array)
    }

    /**
     * función que sirve para borrar todas las reservas del array
     */
    fun deleteAll() {
        repository.deleteAll()
    }

    /**
     * función que sirve para comprobar que el array de reservas no este vacio
     * @throws ReservaEmpty si el array de reservas ya está vacio
     */
    private fun comprobarArrayNoEstaVacio() {
        require(repository.getAllReservas()[0] != null){ throw ReservaEmpty("Error del sistema: No hay reservas en el repositorio.")}
    }

    /**
     * función que sirve para válidar la entrada de los datos de una reserva
     * @throws ReservaBadRequest si algún dato es inválido
     */
    private fun comprobarDatosReserva(reserva: Reserva) {
        val todayDate: LocalDate = LocalDate.now()
        require(reserva.persona.isNotEmpty()) { throw ReservaBadRequest("Error del sistema: El nombre de la persona no puede ser nulo.") }
        require(reserva.fechaEntrada <= reserva.fechaSalida) { throw ReservaBadRequest("Error del sistema: No se ha introducido una fecha de entrada válida.") }
        require(reserva.fechaSalida >= todayDate) { throw ReservaBadRequest("Error del sistema: No se ha introducido una fecha de salida válida.") }
    }
}