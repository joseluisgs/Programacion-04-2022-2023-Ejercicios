package simulacionCine.models;

import simulacionCine.enums.EstadoTicket;

import java.util.Arrays;
import java.util.UUID;

// Clase que representa un ticket de compra o reserva para una película.
public class Ticket {
    private final UUID id = UUID.randomUUID();
    public EstadoTicket estado;
    public String salaID;
    public Butaca[] butacas;
    String cantidadEntradas;
    String pelicula;

    // Constructor para un UUID
    public Ticket(EstadoTicket estado, String salaID, String cantidadEntradas, String pelicula, Butaca[] butacas) {
        this.estado = estado;
        this.salaID = salaID;
        this.cantidadEntradas = cantidadEntradas;
        this.pelicula = pelicula;
        this.butacas = butacas;
    }


    /**
     * Devuelve la cantidad de entradas compradas.
     *
     * @return Cantidad de entradas compradas.
     */
    public String getCantidadEntradas() {
        return cantidadEntradas;
    }

    /**
     * Devuelve el identificador del ticket como una cadena.
     *
     * @return Identificador del ticket en formato de cadena.
     */
    public String ticketIDstring() {
        return id.toString();
    }

    /**
     * Devuelve una representación en forma de cadena del objeto ticket.
     *
     * @return Representación en forma de cadena del objeto ticket.
     */
    @Override
    public String toString() {
        return "Ticket -> (" +
                "estado=" + estado +
                ", salaID='" + salaID + '\'' +
                ", butacas=" + Arrays.toString(butacas) +
                ", cantidadEntradas='" + cantidadEntradas + '\'' +
                ", pelicula='" + pelicula + '\'' +
                ", id=" + id +
                ')';
    }
}
