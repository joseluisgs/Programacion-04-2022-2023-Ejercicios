package simulacionCine.models

import simulacionCine.enums.EstadoTicket
import java.util.*

// Clase que representa un ticket de compra o reserva para una película.
class Ticket(
    private var id: UUID,
    var estado: EstadoTicket,
    var salaID: String,
    private var cantidadEntradas: String,
    private var pelicula: String,
    var butacas: Array<Butaca>
) {

    // Constructor secundario para la creación de un ticket.
    constructor(
        estado: EstadoTicket, salaID: String, cantidadEntradas: String, pelicula: String, butacas: Array<Butaca>
    ) : this(
        UUID.randomUUID(), estado, salaID, cantidadEntradas, pelicula, butacas
    )

    /**
     * Devuelve la cantidad de entradas compradas.
     *
     * @return Cantidad de entradas compradas.
     */
    fun getCantidadEntradas(): String {
        return cantidadEntradas
    }

    /**
     * Devuelve el identificador del ticket como una cadena.
     *
     * @return Identificador del ticket en formato de cadena.
     */
    fun ticketIDstring(): String {
        return id.toString()
    }

    /**
     * Devuelve una cadena con la información de las butacas asignadas al cliente.
     *
     * @return Cadena con la información de las butacas asignadas al cliente.
     */
    private fun imprimirButacasCliente(): String {
        val cadenaButacas: StringBuilder = StringBuilder()

        for (i in butacas.indices) {
            cadenaButacas.append(butacas[i].getPosicionCompletaButaca())
            if (butacas[i].getBooleanButacaVip()){
                cadenaButacas.append("(VIP)")
            }
            if (!butacas[i].getBooleanButacaVip()){
                cadenaButacas.append("(ESTÁNDAR)")
            }
            cadenaButacas.append(" ")

        }

        return """Butacas -> $cadenaButacas"""
    }

    /**
     * Devuelve una representación en forma de cadena del objeto ticket.
     *
     * @return Representación en forma de cadena del objeto ticket.
     */
    override fun toString(): String {
        return "Ticket -> (id=$id, estado=$estado, sala='$salaID', cantidadEntradas='$cantidadEntradas', película='$pelicula')]" +
                "\n${imprimirButacasCliente()}"
    }
}