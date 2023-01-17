package ModelsCesta;

import java.util.Objects;

public class Producto {

    private int idProducto;
    private double precioUitario;
    private String nombre;

    public Producto(int idProducto, double precioUitario, String nombre) {
        this.idProducto = idProducto;
        this.precioUitario = precioUitario;
        this.nombre = nombre;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public Producto setIdProducto(int idProducto) {
        this.idProducto = idProducto;
        return this;
    }

    public double getPrecioUitario() {
        return precioUitario;
    }

    public Producto setPrecioUitario(double precioUitario) {
        this.precioUitario = precioUitario;
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public Producto setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return nombre.equals(producto.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    @Override
    public String toString() {
        return "Producto{" +
                "idProducto=" + idProducto +
                ", precioUitario=" + precioUitario +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
