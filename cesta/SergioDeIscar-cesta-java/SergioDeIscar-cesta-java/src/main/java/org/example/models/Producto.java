package org.example.models;

public final class Producto {
    private String nombre;
    private Float precio;
    private int stock;

    public Producto(String nombre, Float precio, int stock) {
        if (nombre == null || nombre.isEmpty())
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacío");
        if (precio <= 0)
            throw new IllegalArgumentException("El precio debe ser mayor a 0");
        if (stock <= 0)
            throw new IllegalArgumentException("El stock debe ser mayor a 0");
        setNombre(nombre);
        setPrecio(precio);
        setStock(stock);
    }

    //region Getters
    public String getNombre() {
        return nombre;
    }
    public Float getPrecio() {
        return precio;
    }
    public int getStock() {
        return stock;
    }
    //endregion
    //region Setters
    public void setNombre(String nombre) {
        if (nombre == null || nombre.isEmpty())
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacío");
        this.nombre = nombre;
    }
    public void setPrecio(Float precio) {
        if (precio <= 0)
            throw new IllegalArgumentException("El precio debe ser mayor a 0");
        this.precio = precio;
    }
    public void setStock(int stock) {
        if (stock <= 0)
            throw new IllegalArgumentException("El stock debe ser mayor a 0");
        this.stock = stock;
    }
    //endregion

    @Override
    public String toString() {
        return "Producto -> Nombre: " + this.nombre + ", Precio -> " + this.precio + ", Stock -> " + this.stock;
    }
}
