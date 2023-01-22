package simulacionParking.models;

import simulacionCine.enums.Color;

public class Conductor {

    // Constructor primario
    public final int id_AUTO;
    public final String nombre;
    public final String DNI;
    public Vehiculo[] ownerVehicle;
    public int quantityParking_AUTO;

    // Constructor secundario para poder instanciar conductores
    public Conductor(int idAuto, String nombre, String dni, Vehiculo[] ownerVehicle, int quantityPark) {
        this.id_AUTO = idAuto;
        this.nombre = nombre;
        this.DNI = dni;
        this.ownerVehicle = ownerVehicle;
        this.quantityParking_AUTO = quantityPark;
    }

    /**
     * Devuelve el ID del Conductor
     *
     * @return id_AUTO
     */
    public int getId() {
        return id_AUTO;
    }

    /**
     * Devuelve los vehículos que tenga en propiedad el Conductor
     *
     * @return ownerVehicle
     */
    public Vehiculo[] getOwnerVehicle() {
        return ownerVehicle;
    }

    /**
     * Establece un vehículo nuevo en la propiedad del Conductor
     *
     * @param vehiculoNuevo que queremos introducir en la propiedad del Conductor
     * @param indiceVector  la posición del vector donde queremos introducir el nuevo vehículo
     */
    public void setOwnerVehicle(int indiceVector, Vehiculo vehiculoNuevo) {
        ownerVehicle[indiceVector] = vehiculoNuevo;
    }

    /**
     * El conductor se presenta y da sus datos
     */
    public void presentarse() {
        System.out.println(Color.YELLOW_UNDERLINED.get() + "CONDUCTOR" + Color.RESET.get() + "-> Hola soy: " + nombre);
        System.out.println("DNI: " + DNI + ", vehículos aparcados: " + quantityParking_AUTO);
        imprimirVector();
        System.out.println();
    }

    /**
     * Datos de los vehículos que tiene en propiedad el Conductor
     */
    public void imprimirVector() {
        System.out.println(Color.YELLOW_UNDERLINED.get() + "VEHÍCULOS EN PROPIEDAD" + Color.RESET.get());
        for (int i = 0; i < ownerVehicle.length; i++) {
            System.out.print("VEHÍCULO " + (i + 1) + " ");
            System.out.println(ownerVehicle[i].toString() + " ");
        }
    }
}

