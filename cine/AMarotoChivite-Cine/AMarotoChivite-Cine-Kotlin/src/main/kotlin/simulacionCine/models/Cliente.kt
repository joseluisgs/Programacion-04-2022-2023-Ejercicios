package simulacionCine.models

import simulacionCine.enums.EstadoTicket

// Clase que representa un cliente una vez realice una reserva o compra
class Cliente(
    private var nombre: String,
    private var apellido: String,
    var dni: String,
    private var telefono: String,
    var email: String,
    private var tarjetaCredito: String,
    var informacionTicket: Ticket
) {

    /**
     * Devuelve el ID de la sala asociada al ticket del cliente.
     *
     * @return ID de la sala asociada al ticket del cliente.
     */
    fun getIDsalaAsociadaCliente(): String {
        return informacionTicket.salaID
    }

    /**
     * Establece la tarjeta de crédito del cliente.
     *
     * @param tarjetaCliente Tarjeta de crédito del cliente.
     */
    fun setTarjetaCredito(tarjetaCliente: String) {
        this.tarjetaCredito = tarjetaCliente
    }

    /**
     * Establece el estado del ticket asociado al cliente.
     *
     * @param estadoTicket Estado del ticket asociado al cliente.
     */
    fun setEstadoTicketAsociado(estadoTicket: EstadoTicket) {
        this.informacionTicket.estado = estadoTicket
    }

    /**
     * Devuelve una cadena con información del cliente.
     *
     * @return Cadena con información del cliente.
     */
    override fun toString(): String {
        return "Cliente/Usuario -> (nombre='$nombre', apellido='$apellido', dni='$dni', telefono='$telefono', email='$email', tarjetaCredito='$tarjetaCredito',ticketID='${informacionTicket.ticketIDstring()}')"
    }
}