package ModelsAparcamiento;

import java.util.Objects;
import java.util.Scanner;

public class Conductor {

    public static Scanner sc = new Scanner(System.in);

    private static int id = 0;
    private String nombre;
    private String dni;

    private int nextId(){
        id = id + 1;
        return id;
    }


    public Conductor(String nombre, String dni){
        this.id = nextId();
        this.nombre = nombre;
        this.dni = dni;
    }

    public static int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public static void setId(int id) {
        Conductor.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Conductor{" +
                "nombre='" + nombre + '\'' +
                ", dni='" + dni + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conductor conductor = (Conductor) o;
        return Objects.equals(nombre, conductor.nombre) && Objects.equals(dni, conductor.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, dni);
    }
}
