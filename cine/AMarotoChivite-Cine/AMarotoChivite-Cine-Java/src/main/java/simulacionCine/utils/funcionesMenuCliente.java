package simulacionCine.utils;

import simulacionCine.enums.EstadoButaca;
import simulacionCine.enums.EstadoTicket;
import simulacionCine.models.Butaca;
import simulacionCine.models.Cliente;
import simulacionCine.models.Sala;
import simulacionCine.models.Ticket;

import java.util.Scanner;

import static simulacionCine.simulacionCine.*;
import static simulacionCine.utils.filtradoDatos.*;
import static simulacionCine.utils.funcionesEsteticaDeConsola.*;

public class funcionesMenuCliente {

    /**
     * Menú de opciones para el cliente.
     *
     * @param cine            Array de objetos Sala con las salas del cine
     * @param almacenClientes Array de objetos Cliente con la información de todos los clientes del cine
     */
    public static void menuCliente(Sala[] cine, Cliente[] almacenClientes) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            portadaCinesAngel();
            System.out.println("(USUARIO) -> Selecciona la opción deseada: ");
            System.out.println();
            System.out.println("1: Mostrar cine completo (salas/películas/butacas)");
            System.out.println("2: Comprar entrada (Compra directa)");
            System.out.println("3: Reservar entrada (CUIDADO: posteriormente se debe formalizar la reserva!)");
            System.out.println("4: Formalizar reserva (Finaliza tu reserva pendiente para comprar la entrada)");
            System.out.println("5: Anular reserva");
            System.out.println("6: Anular compra (Devolución/reembolso)");
            System.out.println("7: Buscar información sobre compra/reserva realizada");
            System.out.println("0: Salir");

            String option = scanner.nextLine();
            switch (option) {
                case "1" -> {
                    falsoBorradoDeConsola();
                    mostrarCine(cine);
                    while (!volverAlMenu()) {
                        // No saldremos del bucle hasta que introduzcamos "menu"
                    }
                    falsoBorradoDeConsola();
                    break;
                }
                case "2" -> {
                    falsoBorradoDeConsola();
                    comprarEntrada(cine, almacenClientes);
                    while (!volverAlMenu()) {
                        // No saldremos del bucle hasta que introduzcamos "menu"
                    }
                    falsoBorradoDeConsola();
                    break;
                }
                case "3" -> {
                    falsoBorradoDeConsola();
                    reservarEntrada(cine, almacenClientes);
                    while (!volverAlMenu()) {
                        // No saldremos del bucle hasta que introduzcamos "menu"
                    }
                    falsoBorradoDeConsola();
                    break;
                }
                case "4" -> {
                    falsoBorradoDeConsola();
                    formalizarReserva(cine, almacenClientes);
                    falsoBorradoDeConsola();
                    break;
                }
                case "5" -> {
                    falsoBorradoDeConsola();
                    anularReserva(cine, almacenClientes);
                    falsoBorradoDeConsola();
                    break;
                }
                case "6" -> {
                    falsoBorradoDeConsola();
                    anularCompra(cine, almacenClientes);
                    falsoBorradoDeConsola();
                    break;
                }
                case "7" -> {
                    falsoBorradoDeConsola();
                    buscarInformacionClientes(almacenClientes);
                    falsoBorradoDeConsola();
                    break;
                }
                // Salir
                case "0" -> {
                    falsoBorradoDeConsola();
                    menuEleccionUsuario(cine, almacenClientes);
                }
            }
        }
    }

    /**
     * Muestra la información de todos los clientes del cine.
     *
     * @param almacenClientes Array de objetos Cliente con la información de todos los clientes del cine
     */
    public static void buscarInformacionClientes(Cliente[] almacenClientes) {
        do {
            demostrarInformacionGeneral(almacenClientes);
        } while (repetir("¿Quieres volver a realizar una búsqueda (S/N)?"));
    }

    /**
     * Anula la compra de una entrada y devuelve el dinero al cliente.
     *
     * @param cine            Array de objetos Sala con las salas del cine
     * @param almacenClientes Array de objetos Cliente con la información de todos los clientes del cine
     */
    public static void anularCompra(Sala[] cine, Cliente[] almacenClientes) {
        do {
            existenciaCompraParaAnular(cine, almacenClientes);
        } while (repetir("¿Quieres volver a realizar una búsqueda (S/N)?"));
    }

    /**
     * Comprueba si existe alguna compra realizada con el DNI, email o ID_Ticket proporcionado por el usuario.
     *
     * @param cine            Array de objetos Sala con las salas del cine
     * @param almacenClientes Array de objetos Cliente con la información de todos los clientes del cine
     */
    public static void existenciaCompraParaAnular(Sala[] cine, Cliente[] almacenClientes) {
        System.out.println("Puedes realizar la búsqueda de tu compra mediante -> DNI, email o ID_Ticket: ");
        Scanner scanner = new Scanner(System.in);
        String entradaUsuario = scanner.nextLine();

        for (int i = 0; i < almacenClientes.length; i++) {
            if (almacenClientes[i].informacionTicket.estado.equals(EstadoTicket.COMPRA)) {
                if (almacenClientes[i].email.equals(entradaUsuario)) {
                    System.out.println(almacenClientes[i]);
                    anularUnaCompra(cine, almacenClientes, i);
                    return;
                }
                if (almacenClientes[i].dni.equals(entradaUsuario)) {
                    System.out.println(almacenClientes[i]);
                    anularUnaCompra(cine, almacenClientes, i);
                    return;
                }
                if (almacenClientes[i].informacionTicket.ticketIDstring().equals(entradaUsuario)) {
                    System.out.println(almacenClientes[i]);
                    anularUnaCompra(cine, almacenClientes, i);
                    return;
                }
            }
        }
        System.out.println("No hay ninguna compra realizada con los datos que nos proporcionas!");
        System.out.println();
    }


    /**
     * Anula la compra de una entrada y devuelve el dinero al cliente.
     *
     * @param cine            Array de objetos Sala con las salas del cine
     * @param almacenClientes Array de objetos Cliente con la información de todos los clientes del cine
     * @param posicionCliente Índice del cliente en el array almacenClientes
     */
    public static void anularUnaCompra(Sala[] cine, Cliente[] almacenClientes, int posicionCliente) {
        String mensaje = "¿Está seguro que desea anular su compra (S/N)?";
        if (deseaAnular(mensaje)) {
            System.out.println("¡Compra anulada!");
            //System.out.println("Con una devolución de: " + (double) almacenClientes[posicionCliente].informacionTicket.getCantidadEntradas() * 5.25 + "€");
            // Cambiamos el estado de la/s butaca/s a libre/s
            String salaParaActualizar = almacenClientes[posicionCliente].informacionTicket.salaID;
            Butaca[] posicionButacasParaActualizar = almacenClientes[posicionCliente].informacionTicket.butacas;
            for (int i = 0; i < cine.length; i++) {
                if (cine[i].id.equals(salaParaActualizar)) {
                    for (int k = 0; k < posicionButacasParaActualizar.length; k++) {
                        cine[i].liberarButaca(posicionButacasParaActualizar[k].getPosicionCompletaButaca());
                    }
                }
            }
            // Establecemos un cliente plantilla por defecto inicial
            Cliente usuarioClientePorDefecto = new Cliente(
                    " ", " ", " ", " ", " ", " ",
                    new Ticket(
                            EstadoTicket.INACTIVO, " ", " ", " ",
                            new Butaca[BUTACAS_FILA_MAX * BUTACAS_COLUMNA_MAX]
                    )
            );
            almacenClientes[posicionCliente] = usuarioClientePorDefecto;
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }


    /**
     * Anula la reserva de una entrada.
     *
     * @param cine            Array de objetos Sala con las salas del cine
     * @param almacenClientes Array de objetos Cliente con la información de todos los clientes del cine
     */
    public static void anularReserva(Sala[] cine, Cliente[] almacenClientes) {
        do {
            existenciaReservaParaAnular(cine, almacenClientes);
        } while (repetir("¿Quieres volver a realizar una búsqueda (S/N)?"));
    }

    /**
     * Comprueba si existe alguna reserva realizada con el DNI, email o ID_Ticket proporcionado por el usuario.
     *
     * @param cine            Array de objetos Sala con las salas del cine
     * @param almacenClientes Array de objetos Cliente con la información de todos los clientes del cine
     */
    public static void existenciaReservaParaAnular(Sala[] cine, Cliente[] almacenClientes) {
        System.out.println("Puedes realizar la búsqueda de tu reserva mediante -> DNI, email o ID_Ticket: ");
        Scanner scanner = new Scanner(System.in);
        String entradaUsuario = scanner.nextLine();
        boolean encontrado = false;
        for (int i = 0; i < almacenClientes.length; i++) {
            if (almacenClientes[i].informacionTicket.estado.equals(EstadoTicket.RESERVA)) {
                if (almacenClientes[i].email.equals(entradaUsuario)) {
                    System.out.println(almacenClientes[i]);
                    anularUnaReserva(cine, almacenClientes, i);
                    encontrado = true;
                    break;
                }
                if (almacenClientes[i].dni.equals(entradaUsuario)) {
                    System.out.println(almacenClientes[i]);
                    anularUnaReserva(cine, almacenClientes, i);
                    encontrado = true;
                    break;
                }
                if (almacenClientes[i].informacionTicket.ticketIDstring().equals(entradaUsuario)) {
                    System.out.println(almacenClientes[i]);
                    anularUnaReserva(cine, almacenClientes, i);
                    encontrado = true;
                    break;
                }
            }
        }
        if (!encontrado) {
            System.out.println("No hay ninguna compra o reserva realizada con los datos que nos proporcionas!");
            System.out.println();
        }
    }

    /**
     * Anula la reserva de una entrada y libera las butacas.
     *
     * @param cine            Array de objetos Sala con las salas del cine
     * @param almacenClientes Array de objetos Cliente con la información de todos los clientes del cine
     * @param posicionCliente Índice del cliente en el array almacenClientes
     */
    public static void anularUnaReserva(Sala[] cine, Cliente[] almacenClientes, int posicionCliente) {
        String mensaje = "¿Está seguro que desea anular su reserva (S/N)?";
        if (deseaAnular(mensaje)) {
            // Cambiamos el estado de la/s butaca/s a libre/s
            String salaParaActualizar = almacenClientes[posicionCliente].informacionTicket.salaID;
            Butaca[] posicionButacasParaActualizar = almacenClientes[posicionCliente].informacionTicket.butacas;
            for (int i = 0; i < cine.length; i++) {
                if (cine[i].id.equals(salaParaActualizar)) {
                    for (int k = 0; k < posicionButacasParaActualizar.length; k++) {
                        cine[i].liberarButaca(posicionButacasParaActualizar[k].getPosicionCompletaButaca());
                    }
                }
            }
            // Y establecemos un cliente plantilla por defecto inicial
            Cliente usuarioClientePorDefecto = new Cliente(
                    " ", " ", " ", " ", " ", " ",
                    new Ticket(
                            EstadoTicket.INACTIVO, " ", " ", " ",
                            new Butaca[BUTACAS_FILA_MAX * BUTACAS_COLUMNA_MAX]
                    )
            );
            almacenClientes[posicionCliente] = usuarioClientePorDefecto;

            System.out.println("¡Reserva anulada!");
            try {
                Thread.sleep(2250);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }


    /**
     * Pide al usuario que indique si desea anular algo o no.
     *
     * @param mensaje Mensaje que se mostrará al usuario para pedirle que indique si desea anular algo o no
     * @return "true" si el usuario desea anular, "false" si no lo desea
     */
    public static Boolean deseaAnular(String mensaje) {
        while (true) {
            System.out.println(mensaje);
            Scanner scanner = new Scanner(System.in);
            String entradaUsuario = scanner.nextLine();

            if (entradaUsuario.equals("s")) {
                falsoBorradoDeConsola();
                return true;
            }
            if (entradaUsuario.equals("n")) {
                falsoBorradoDeConsola();
                return false;
            }
            falsoBorradoDeConsola();
            System.out.println("Debe introducir (S/N)!");
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            falsoBorradoDeConsola();
        }
    }

    /**
     * Formaliza una reserva previamente realizada por un usuario.
     *
     * @param cine            Array de salas del cine.
     * @param almacenClientes Array de clientes del cine.
     */
    public static void formalizarReserva(Sala[] cine, Cliente[] almacenClientes) {
        do {
            existenciaReservaParaFormalizar(cine, almacenClientes);
        } while (repetir("¿Quieres volver a realizar una búsqueda (S/N)?"));
    }

    /**
     * Función que permite a un usuario formalizar su reserva.
     *
     * @param cine            Array de objetos Sala que almacena todas las salas del cine
     * @param almacenClientes Array de objetos Cliente que almacena todos los clientes del cine
     *                        <p>
     *                        El usuario puede realizar la búsqueda de su reserva mediante su DNI, email o ID del ticket.
     *                        Si se encuentra la reserva, se procede al pago y se cambia el estado del ticket a "COMPRA".
     *                        Además, se cambian las butacas de la sala correspondiente a "OCUPADAS".
     */
    static void existenciaReservaParaFormalizar(Sala[] cine, Cliente[] almacenClientes) {
        System.out.println("Puedes realizar la búsqueda de tu reserva mediante -> DNI, email o ID_Ticket: ");
        Scanner scanner = new Scanner(System.in);
        String entradaUsuario = scanner.nextLine();
        boolean encontrado = false;
        for (int i = 0; i < almacenClientes.length; i++) {
            if (almacenClientes[i].informacionTicket.estado.equals(EstadoTicket.RESERVA)) {
                if (almacenClientes[i].email.equals(entradaUsuario)) {
                    System.out.println(almacenClientes[i]);
                    procederPagoDeUnaReserva(almacenClientes, i);
                    encontrado = true;
                    // Cambiamos reserva a comprada, en el ticket
                    almacenClientes[i].setEstadoTicketAsociado(EstadoTicket.COMPRA);
                    // Cambiamos butacas de la sala a OCUPADAS
                    String salaIDParaCambiar = almacenClientes[i].getIDsalaAsociadaCliente();
                    for (int j = 0; j < cine.length; j++) {
                        // Filtro para únicamente cambiar las butacas de la sala que el cliente tiene las butacas reservadas
                        if (cine[j].id.equals(salaIDParaCambiar)) {
                            // Recorremos el vector de butacas seleccionadas previamente por el cliente y las asignamos a ocupadas
                            Butaca[] butacasSeleccionas = almacenClientes[i].informacionTicket.butacas;
                            for (int k = 0; k < butacasSeleccionas.length; k++) {
                                cine[j].ocuparButaca(butacasSeleccionas[k].getPosicionCompletaButaca());
                            }
                        }
                    }
                    break;
                }
                if (almacenClientes[i].dni.equals(entradaUsuario)) {
                    System.out.println(almacenClientes[i]);
                    procederPagoDeUnaReserva(almacenClientes, i);
                    encontrado = true;
                    // Cambiamos reserva a comprada, en el ticket
                    almacenClientes[i].setEstadoTicketAsociado(EstadoTicket.COMPRA);

                    // Cambiamos butacas de la sala a OCUPADAS
                    String salaIDParaCambiar = almacenClientes[i].getIDsalaAsociadaCliente();
                    for (int j = 0; j < cine.length; j++) {
                        // Filtro para únicamente cambiar las butacas de la sala que el cliente tiene las butacas reservadas
                        if (cine[j].id.equals(salaIDParaCambiar)) {
                            // Recorremos el vector de butacas seleccionadas previamente por el cliente y las asignamos a ocupadas
                            Butaca[] butacasSeleccionas = almacenClientes[i].informacionTicket.butacas;
                            for (int k = 0; k < butacasSeleccionas.length; k++) {
                                cine[j].ocuparButaca(butacasSeleccionas[k].getPosicionCompletaButaca());
                            }
                        }
                    }
                    break;
                }
            }
        }
        if (!encontrado) {
            System.out.println("No hay ninguna compra o reserva realizada con los datos que nos proporcionas!");
            System.out.println();
        }
    }

    /**
     * Realiza el pago de una reserva a través de tarjeta de crédito.
     *
     * @param almacenClientes Arreglo de objetos de tipo Cliente.
     * @param posicionCliente Índice del cliente en el Array almacenClientes.
     */
    static void procederPagoDeUnaReserva(Cliente[] almacenClientes, int posicionCliente) {
        if (deseaPagar()) {
            Cliente clienteActualizar = almacenClientes[posicionCliente];
            while (true) {
                System.out.println("Tarjeta de Crédito (*Obligatorio):");
                Scanner scanner = new Scanner(System.in);
                String tarjetaCliente = scanner.nextLine();
                if (filtroTarjetaCredito(tarjetaCliente)) {
                    // Si superamos el filtro actualizamos la tarjeta
                    clienteActualizar.setTarjetaCredito(tarjetaCliente);
                    falsoBorradoDeConsola();
                    System.out.println("Acaba de formalizar la compra de " + clienteActualizar.informacionTicket.getCantidadEntradas() + " entradas.");
                    // System.out.println( "Precio total cobrado: " + clienteActualizar.informacionTicket.getCantidadEntradas() * 5.25 + "€");
                    System.out.println();
                    break;
                }
            }
        }
    }


    /**
     * Muestra la información general de un cliente y su reserva.
     *
     * @param almacenClientes Array de objetos de tipo Cliente.
     */
    public static void demostrarInformacionGeneral(Cliente[] almacenClientes) {

        System.out.println("Puedes realizar la búsqueda de tu compra/reserva mediante -> DNI, email o ID_Ticket: ");
        Scanner scanner = new Scanner(System.in);
        String entradaUsuario = scanner.nextLine();
        boolean encontrado = false;

        for (int i = 0; i < almacenClientes.length; i++) {
            if (almacenClientes[i].email.equals(entradaUsuario)) {
                System.out.println(almacenClientes[i]);
                System.out.println(almacenClientes[i].informacionTicket);
                System.out.println(" ");
                encontrado = true;
            }
            if (almacenClientes[i].dni.equals(entradaUsuario)) {
                System.out.println(almacenClientes[i]);
                System.out.println(almacenClientes[i].informacionTicket);
                System.out.println(" ");
                encontrado = true;
            }
            if (almacenClientes[i].informacionTicket.ticketIDstring().equals(entradaUsuario)) {
                System.out.println(almacenClientes[i]);
                System.out.println(almacenClientes[i].informacionTicket);
                System.out.println(" ");
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No hay ninguna compra o reserva realizada con los datos que nos proporcionas!");
            System.out.println();
        }
    }

    /**
     * Permite seleccionar las butacas que se quieren reservar.
     *
     * @param cine             Arreglo de objetos de tipo Sala.
     * @param idSala           Identificador de la sala a la que pertenecen las butacas.
     * @param cantidadEntradas Número de butacas a reservar.
     * @return Un arreglo de objetos de tipo Butaca con las butacas seleccionadas y reservadas.
     */
    public static Butaca[] seleccionButacasReservadas(Sala[] cine, String idSala, String cantidadEntradas) {
        Butaca[] almacenSeleccionButacas = new Butaca[Integer.parseInt(cantidadEntradas)];
        for (int i = 0; i < almacenSeleccionButacas.length; i++) {
            almacenSeleccionButacas[i] = new Butaca(EstadoButaca.LIBRE, "A", "0", false);
        }
        int contadorButaca = 1;
        for (int i = 0; i < Integer.parseInt(cantidadEntradas); i++) {
            boolean salirBucle = false;
            while (!salirBucle) {
                mostrarSala(cine, idSala);
                System.out.println("Seleccione BUTACA número " + contadorButaca + " para reservar (ejemplo -> A1):");
                Scanner scanner = new Scanner(System.in);
                String entradaButacaReservada = scanner.nextLine();
                if (filtradoButacas(cine, idSala, entradaButacaReservada)) {
                    contadorButaca += 1;
                    for (int j = 0; j < cine.length; j++) {
                        if (cine[j].id.equals(idSala)) {
                            // Introducimos la butaca filtrada en nuestro almacén, donde haya una LIBRE
                            for (int k = 0; k < almacenSeleccionButacas.length; k++) {
                                if (almacenSeleccionButacas[k].getEstadoButaca() == EstadoButaca.LIBRE) {
                                    almacenSeleccionButacas[k] = new Butaca(
                                            EstadoButaca.RESERVADO,
                                            String.valueOf(entradaButacaReservada.charAt(0)),
                                            String.valueOf(entradaButacaReservada.charAt(1)),
                                            // Asignamos si era VIP con anterioridad o no
                                            cine[j].getBooleanButacaVipDesdeSala(entradaButacaReservada)
                                    );
                                    break;
                                }
                            }
                            // Asignamos reservada la butaca en la sala específica seleccionada
                            cine[j].reservarButaca(entradaButacaReservada);
                            salirBucle = true;
                            break;
                        }
                    }
                }
            }
            mostrarSala(cine, idSala);
        }
        return almacenSeleccionButacas;
    }

    /**
     * Selecciona una cantidad determinada de butacas ocupadas en una sala de cine específica.
     *
     * @param cine             Array de objetos de la clase Sala que representa el cine completo.
     * @param idSala           Identificador de la sala de cine en la que se desean seleccionar las butacas.
     * @param cantidadEntradas Cantidad de butacas a seleccionar.
     * @return Array de objetos de la clase Butaca que representa las butacas seleccionadas.
     */
    public static Butaca[] seleccionButacasOcupadas(Sala[] cine, String idSala, String cantidadEntradas) {
        Butaca[] almacenSeleccionButacas = new Butaca[Integer.parseInt(cantidadEntradas)];

        for (int i = 0; i < almacenSeleccionButacas.length; i++) {
            almacenSeleccionButacas[i] = new Butaca(EstadoButaca.LIBRE, "A", "0", false);
        }
        int contadorButaca = 1;

        for (int i = 0; i < Integer.parseInt(cantidadEntradas); i++) {
            boolean salirBucle = false;
            while (!salirBucle) {
                mostrarSala(cine, idSala);
                System.out.println("Seleccione BUTACA número " + contadorButaca + " para comprar (ejemplo -> A1):");
                Scanner scanner = new Scanner(System.in);
                String entradaButacaOcupada = scanner.nextLine();
                if (filtradoButacas(cine, idSala, entradaButacaOcupada)) {
                    contadorButaca += 1;
                    for (int j = 0; j < cine.length; j++) {
                        if (cine[j].id.equals(idSala)) {
                            // Introducimos la butaca filtrada en nuestro almacén, donde haya una LIBRE
                            for (int k = 0; k < almacenSeleccionButacas.length; k++) {
                                if (almacenSeleccionButacas[k].getEstadoButaca() == EstadoButaca.LIBRE) {
                                    almacenSeleccionButacas[k] = new Butaca(
                                            EstadoButaca.OCUPADO,
                                            String.valueOf(entradaButacaOcupada.charAt(0)),
                                            String.valueOf(entradaButacaOcupada.charAt(1)),
                                            // Asignamos si era VIP con anterioridad o no
                                            cine[j].getBooleanButacaVipDesdeSala(entradaButacaOcupada)
                                    );
                                    break;
                                }
                            }
                            // Asignamos ocupada la butaca en la sala específica seleccionada
                            cine[j].ocuparButaca(entradaButacaOcupada);
                            salirBucle = true;
                            break;
                        }
                    }
                }
            }
            mostrarSala(cine, idSala);
        }
        return almacenSeleccionButacas;
    }

    /**
     * Pregunta al usuario si desea realizar el pago.
     *
     * @return true si el usuario quiere realizar el pago, false en caso contrario.
     */
    public static boolean deseaPagar() {
        while (true) {
            System.out.println("¿Quiere realizar el pago (S/N)?");
            Scanner scanner = new Scanner(System.in);
            String entradaUsuario = scanner.nextLine().toLowerCase();

            if (entradaUsuario.equals("s")) {
                falsoBorradoDeConsola();
                return true;
            }
            if (entradaUsuario.equals("n")) {
                falsoBorradoDeConsola();
                return false;
            }
            falsoBorradoDeConsola();
            System.out.println("Debe introducir (S/N)!");
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            falsoBorradoDeConsola();
        }
    }

    /**
     * Permite a un cliente reservar entradas para una película.
     *
     * @param cine            Array de objetos de tipo Sala.
     * @param almacenClientes Array de objetos de tipo Cliente.
     */
    static void reservarEntrada(Sala[] cine, Cliente[] almacenClientes) {
        // Almacén donde guardaré las elecciones de mi usuario
        final String[] almacenElecciones = new String[3];

        boolean salirBucle = false;
        while (!salirBucle) {
            mostrarCatalogo(cine);
            System.out.println("Introduzca el ID de la sala de la película que quieras ver:");
            Scanner scanner = new Scanner(System.in);
            String entradaIDsala = scanner.nextLine();
            falsoBorradoDeConsola();

            // Filtro para elegir un ID existente
            for (int i = 0; i < cine.length; i++) {
                if (entradaIDsala.equals(cine[i].id)) {
                    almacenElecciones[0] = entradaIDsala;
                    salirBucle = true;
                    break;
                }
                if (i == cine.length - 1) {
                    if (!entradaIDsala.equals(cine[i].id)) {
                        System.out.println("ID inválido! Debe existir la sala en el CINE!");
                        try {
                            Thread.sleep(2250);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        falsoBorradoDeConsola();
                        break;
                    }
                }
            }
        }

        while (true) {
            int maxButacas = cine[0].cantidadButacasTotal();

            System.out.println("Introduzca la cantidad de entradas que quiere reservar:");
            Scanner scanner = new Scanner(System.in);
            String cantidadEntradas = scanner.nextLine();

            if (filtroCantidadEntradas(cantidadEntradas, maxButacas)) {
                almacenElecciones[1] = cantidadEntradas;
                break;
            }
        }

        // Seleccionar butacas donde quiera reservar
        String entradaIDsala = almacenElecciones[0];
        String cantidadEntradas = almacenElecciones[1];
        // Tienen filtros de entrada por consola las butacas en la selección
        Butaca[] seleccionButacas = seleccionButacasReservadas(cine, entradaIDsala, cantidadEntradas);

        String[] datosCliente = new String[6];
        System.out.println("Introduzca sus datos para realizar la reserva:");
        System.out.println();

        while (true) {
            System.out.println("Nombre (*Obligatorio):");
            Scanner scanner = new Scanner(System.in);
            String nombreCliente = scanner.nextLine();
            if (filtroMaxLetras(nombreCliente)) {
                datosCliente[0] = nombreCliente;
                break;
            }
        }

        while (true) {
            System.out.println("Apellido (*Obligatorio):");
            Scanner scanner = new Scanner(System.in);
            String apellidoCliente = scanner.nextLine();
            if (filtroMaxLetras(apellidoCliente)) {
                datosCliente[1] = apellidoCliente;
                break;
            }
        }

        while (true) {
            System.out.println("DNI (*Obligatorio):");
            Scanner scanner = new Scanner(System.in);
            String dniCliente = scanner.nextLine();
            if (filtroDNI(dniCliente)) {
                datosCliente[2] = dniCliente;
                break;
            }
        }

        while (true) {
            System.out.println("Teléfono:");
            Scanner scanner = new Scanner(System.in);
            String telefonoCliente = scanner.nextLine();
            if (filtroTelefono(telefonoCliente)) {
                datosCliente[3] = telefonoCliente;
                break;
            }
        }

        while (true) {
            System.out.println("Email (*Obligatorio):");
            Scanner scanner = new Scanner(System.in);
            String emailCliente = scanner.nextLine();
            if (filtroEmail(emailCliente)) {
                datosCliente[4] = emailCliente;
                break;
            }
        }

        // No asignamos tarjeta de crédito en la reserva! datosCliente[5] = NADA

        // Una vez superado los filtrados y es correcto:
        for (int i = 0; i < cine.length; i++) {
            if (cine[i].id.equals(almacenElecciones[0])) {
                almacenElecciones[2] = cine[i].pelicula.nombrePeliculaString();
            }
        }
        // Generamos ticket de reserva
        Ticket ticketNuevo = new Ticket(
                EstadoTicket.RESERVA,
                almacenElecciones[0],
                almacenElecciones[1],
                almacenElecciones[2],
                seleccionButacas
        );

        // Creamos nuevo cliente con todos los datos anteriores
        Cliente clienteNuevo = new Cliente(
                datosCliente[0],
                datosCliente[1],
                datosCliente[2],
                datosCliente[3],
                datosCliente[4],
                "EN ESPERA DE FORMALIZAR RESERVA",
                ticketNuevo
        );
        System.out.println("Sus datos son:");
        System.out.println(clienteNuevo);


        // Almacenamos nuestro cliente en nuestra base de datos volátil únicamente viva hasta parar el programa
        for (int i = 0; i < almacenClientes.length; i++) {
            if (almacenClientes[i].dni.equals(" ")) {
                almacenClientes[i] = clienteNuevo;
                break;
            }
        }

        // Vemos si son VIP o no nuestras butacas para calcular su precio:
        int contadorButacasVIP = 0;
        int contadorButacasEstandar = 0;
        for (int i = 0; i < seleccionButacas.length; i++) {
            if (seleccionButacas[i].getBooleanButacaVip()) {
                contadorButacasVIP += 1;
            } else {
                contadorButacasEstandar += 1;
            }
        }
        Double precioTotalCobrar = (contadorButacasEstandar * PRECIO_ESTANDAR) + (contadorButacasVIP * PRECIO_VIP);

        System.out.println();
        System.out.println("Acaba de formalizar una reserva de " + almacenElecciones[1] + " entradas.");
        System.out.println(contadorButacasEstandar + " entradas ESTÁNDAR");
        System.out.println(contadorButacasVIP + " entradas VIP");
        System.out.println("Precio total para cobrar: " + precioTotalCobrar + "€");
        System.out.println("IMPORTANTE: debe formalizar la reserva antes de 30 minutos! Si no se le anulará la reserva!");
        System.out.println();
    }

    /**
     * Permite a un cliente comprar entradas para una película.
     *
     * @param cine            Array de objetos de tipo Sala.
     * @param almacenClientes Array de objetos de tipo Cliente.
     */
    public static void comprarEntrada(Sala[] cine, Cliente[] almacenClientes) {
        // Almacén donde guardaré las elecciones de mi usuario
        String[] almacenElecciones = new String[3];

        boolean salirBucle = false;
        while (!salirBucle) {
            mostrarCatalogo(cine);
            System.out.println("Introduzca el ID de la sala de la película que quieras ver:");
            Scanner scanner = new Scanner(System.in);
            String entradaIDsala = scanner.nextLine();
            falsoBorradoDeConsola();

            // Filtro para elegir una, id existente
            for (int i = 0; i < cine.length; i++) {
                if (entradaIDsala.equals(cine[i].id)) {
                    almacenElecciones[0] = entradaIDsala;
                    salirBucle = true;
                    break;
                }
                if (i == cine.length - 1) {
                    if (!entradaIDsala.equals(cine[i].id)) {
                        System.out.println("Inválido ID! La sala debe existir en el cine!");
                        try {
                            Thread.sleep(2250);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        falsoBorradoDeConsola();
                        break;
                    }
                }
            }
        }

        while (true) {
            int maxButacas = cine[0].cantidadButacasTotal();

            System.out.println("Introduzca la cantidad de entradas que quiere comprar:");
            Scanner scanner = new Scanner(System.in);
            String cantidadEntradas = scanner.nextLine();

            if (filtroCantidadEntradas(cantidadEntradas, maxButacas)) {
                almacenElecciones[1] = cantidadEntradas;
                break;
            }
        }

        // Seleccionar butacas donde quiera comprar
        String entradaIDsala = almacenElecciones[0];
        String cantidadEntradas = almacenElecciones[1];
        // Ya están filtrados dentro
        Butaca[] seleccionButacas = seleccionButacasOcupadas(cine, entradaIDsala, cantidadEntradas);

        String[] datosCliente = new String[6];
        for (int i = 0; i < datosCliente.length; i++) {
            datosCliente[i] = " ";
        }
        System.out.println("Introduzca sus datos para realizar la compra:");

        while (true) {
            System.out.println("Nombre (*Obligatorio):");
            Scanner scanner = new Scanner(System.in);
            String nombreCliente = scanner.nextLine();
            if (filtroMaxLetras(nombreCliente)) {
                datosCliente[0] = nombreCliente;
                break;
            }
        }

        while (true) {
            System.out.println("Apellido (*Obligatorio):");
            Scanner scanner = new Scanner(System.in);
            String apellidoCliente = scanner.nextLine();
            if (filtroMaxLetras(apellidoCliente)) {
                datosCliente[1] = apellidoCliente;
                break;
            }
        }

        while (true) {
            System.out.println("DNI (*Obligatorio):");
            Scanner scanner = new Scanner(System.in);
            String dniCliente = scanner.nextLine();
            if (filtroDNI(dniCliente)) {
                datosCliente[2] = dniCliente;
                break;
            }
        }

        while (true) {
            System.out.println("Teléfono:");
            Scanner scanner = new Scanner(System.in);
            String telefonoCliente = scanner.nextLine();
            if (filtroTelefono(telefonoCliente)) {
                datosCliente[3] = telefonoCliente;
                break;
            }
        }

        while (true) {
            System.out.println("Email (*Obligatorio):");
            Scanner scanner = new Scanner(System.in);
            String emailCliente = scanner.nextLine();
            if (filtroEmail(emailCliente)) {
                datosCliente[4] = emailCliente;
                break;
            }
        }

        while (true) {
            System.out.println("Tarjeta de Crédito (*Obligatorio):");
            Scanner scanner = new Scanner(System.in);
            String tarjetaCliente = scanner.nextLine();
            if (filtroTarjetaCredito(tarjetaCliente)) {
                datosCliente[5] = tarjetaCliente;
                break;
            }
        }

        // Una vez superado los filtrados y es correcto
        // Generamos ticket
        for (int i = 0; i < cine.length; i++) {
            if (cine[i].id.equals(almacenElecciones[0])) {
                almacenElecciones[2] = cine[i].pelicula.nombrePeliculaString();
            }
        }
        Ticket ticketNuevo = new Ticket(
                EstadoTicket.COMPRA,
                almacenElecciones[0],
                almacenElecciones[1],
                almacenElecciones[2],
                seleccionButacas
        );

        // Creamos nuevo cliente con todos los datos anteriores
        Cliente clienteNuevo = new Cliente(
                datosCliente[0],
                datosCliente[1],
                datosCliente[2],
                datosCliente[3],
                datosCliente[4],
                datosCliente[5],
                ticketNuevo
        );

        System.out.println("Sus datos son:");
        System.out.println(clienteNuevo);

        // Almacenamos nuestro cliente en nuestra base de datos volátil únicamente viva hasta parar el programa
        for (int i = 0; i < almacenClientes.length; i++) {
            if (almacenClientes[i].dni.equals(" ")) {
                almacenClientes[i] = clienteNuevo;
                break;
            }
        }

        // Vemos si son VIP o no nuestras butacas para calcular su precio:
        int contadorButacasVIP = 0;
        int contadorButacasEstandar = 0;
        for (int i = 0; i < seleccionButacas.length; i++) {
            if (seleccionButacas[i].getBooleanButacaVip()) {
                contadorButacasVIP += 1;
            } else {
                contadorButacasEstandar += 1;
            }
        }
        double precioTotalCobrar = (contadorButacasEstandar * PRECIO_ESTANDAR) + (contadorButacasVIP * PRECIO_VIP);
        System.out.println();
        System.out.println("Acaba de formalizar la compra de " + almacenElecciones[1] + " entradas.");
        System.out.println(contadorButacasEstandar + " entradas ESTÁNDAR");
        System.out.println(contadorButacasVIP + " entradas VIP");
        System.out.println("Precio total cobrado: " + precioTotalCobrar + "€");
        System.out.println();
    }
}
