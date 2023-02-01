package factories

import models.Habitacion
import models.Reserva
import java.time.LocalDate

object FactoryReserva {

    /**
     * función que sirve para crear una reserva con los datos metidos por parámetros
     * @param persona es el nombre de la persona que creo la reserva
     * @param habitacion es la habitacion comprada/reservada
     * @param fechaEntrada es la fecha de entrada para la habitacion
     * @param fechaSalida es la fecha de salida para la habitacion
     * @return la reserva creada
     */
    fun create(persona: String, habitacion: Habitacion, fechaEntrada: LocalDate, fechaSalida: LocalDate): Reserva {
        return Reserva(persona = persona, habitacion = habitacion, fechaEntrada = fechaEntrada, fechaSalida = fechaSalida)
    }
}