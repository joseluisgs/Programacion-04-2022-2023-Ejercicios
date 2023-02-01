package models

import java.time.LocalDate
import java.util.*

data class Reserva(
    var id: UUID = UUID.randomUUID(),
    val persona: String,
    val habitacion: Habitacion,
    val fechaEntrada: LocalDate,
    val fechaSalida: LocalDate
) {
    override fun toString(): String {
        return "Reserva(id=$id, persona='$persona', habitacion=$habitacion, fechaEntrada=$fechaEntrada, fechaSalida=$fechaSalida)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Reserva

        if (persona != other.persona) return false
        if (habitacion != other.habitacion) return false
        if (fechaEntrada != other.fechaEntrada) return false
        if (fechaSalida != other.fechaSalida) return false

        return true
    }
}