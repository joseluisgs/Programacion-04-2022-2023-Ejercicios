package repositories

import models.Reserva
import java.util.*

interface ReservaRepository {
     fun getReservaById(id: UUID): Reserva?

     fun getAllReservas(): Array<Reserva?>

     fun create(reserva: Reserva): Reserva?

     fun update(id: UUID, reserva: Reserva): Reserva?

     fun delete(id: UUID): Reserva?

     fun safeAll(array: Array<Reserva?>)

     fun deleteAll()
}