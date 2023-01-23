package ModelsAparcamiento;

import java.util.Objects;
import java.util.Scanner;

public class Vehiculo {

    private static Scanner sc = new Scanner(System.in);

    public Conductor conductor;
    public int id;
    private String matricula;
    private int añoFabricacion;
    private tipoVehiculo tipo;

    private static int contador = 1;
    private int nextId(){
        return contador++;
    }

    public Vehiculo(String matricula, int añoFabricacion, tipoVehiculo tipo, Conductor conductor) {
        this.id = nextId();
        this.matricula = matricula;
        this.añoFabricacion = añoFabricacion;
        this.tipo = tipo;
        this.conductor = conductor;
    }

    public String getMatricula() {
        return matricula;
    }

    public int getAñoFabricacion() {
        return añoFabricacion;
    }

    public String getTipo() {
        String tipoV = null;
        switch (this.tipo){
            case coche -> tipoV = "coche";
            case moto -> tipoV = "moto";
            case patinete -> tipoV = "patinete";
        }
        return tipoV;
    }

    public Conductor getConductor() {
        return conductor;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "conductor=" + conductor +
                ", matricula='" + matricula + '\'' +
                ", añoFabricacion=" + añoFabricacion +
                ", tipo='" + tipo + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehiculo vehiculo = (Vehiculo) o;
        return añoFabricacion == vehiculo.añoFabricacion && Objects.equals(conductor, vehiculo.conductor) && Objects.equals(matricula, vehiculo.matricula) && Objects.equals(tipo, vehiculo.tipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(conductor, matricula, añoFabricacion, tipo);
    }
}
