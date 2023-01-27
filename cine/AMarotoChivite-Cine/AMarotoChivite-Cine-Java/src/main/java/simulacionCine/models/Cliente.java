package simulacionCine.models;

import simulacionCine.enums.EstadoTicket;

// Clase que representa un cliente una vez realice una reserva o compra
public class Cliente {
    private final String nombre;
    private final String apellido;
    private final String telefono;
    public String dni;
    public String email;
    public Ticket informacionTicket;
    private String tarjetaCredito;

    public Cliente(String nombre, String apellido, String dni, String telefono, String email, String tarjetaCredito, Ticket informacionTicket) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.telefono = telefono;
        this.email = email;
        this.tarjetaCredito = tarjetaCredito;
        this.informacionTicket = informacionTicket;
    }

    /**
     * Devuelve el ID de la sala asociada al ticket del cliente.
     *
     * @return ID de la sala asociada al ticket del cliente.
     */
    public String getIDsalaAsociadaCliente() {
        return informacionTicket.salaID;
    }

    /**
     * Establece la tarjeta de crédito del cliente.
     *
     * @param tarjetaCliente Tarjeta de crédito del cliente.
     */
    public void setTarjetaCredito(String tarjetaCliente) {
        this.tarjetaCredito = tarjetaCliente;
    }

    /**
     * Establece el estado del ticket asociado al cliente.
     *
     * @param estadoTicket Estado del ticket asociado al cliente.
     */
    public void setEstadoTicketAsociado(EstadoTicket estadoTicket) {
        this.informacionTicket.estado = estadoTicket;
    }

    /**
     * Devuelve una cadena con información del cliente.
     *
     * @return Cadena con información del cliente.
     */
    @Override
    public String toString() {
        return "Cliente -> (" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", telefono='" + telefono + '\'' +
                ", dni='" + dni + '\'' +
                ", email='" + email + '\'' +
                ", tarjetaCredito='" + tarjetaCredito + '\'' +
                "\n" + informacionTicket + '\'' +
                ')';
    }
}
