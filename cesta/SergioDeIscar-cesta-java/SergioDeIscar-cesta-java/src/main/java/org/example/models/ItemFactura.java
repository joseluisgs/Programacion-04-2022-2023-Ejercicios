package org.example.models;

public final class ItemFactura {
    private int cantidad;
    private Producto producto;
    private final float precioUnitario;

    public ItemFactura(Producto producto, int cantidad) {
        if (producto == null)
            throw new IllegalArgumentException("El producto no puede ser nulo");
        if (cantidad <= 0)
            throw new IllegalArgumentException("La cantidad debe ser mayor a 0");
        setCantidad(cantidad);
        setProducto(producto);
        precioUnitario = producto.getPrecio();
    }

    //region Getters
    public int getCantidad() {
        return cantidad;
    }
    public Producto getProducto() {
        return producto;
    }
    public float getPrecioUnitario() {
        return precioUnitario;
    }
    //endregion
    //region Setters
    public void setCantidad(int cantidad) {
        if (cantidad <= 0)
            throw new IllegalArgumentException("La cantidad debe ser mayor a 0");
        this.cantidad = cantidad;
    }
    public void setProducto(Producto producto) {
        if (producto == null)
            throw new IllegalArgumentException("El producto no puede ser nulo");
        this.producto = producto;
    }
    //endregion

    public float calcularImporte() {
        return this.cantidad * precioUnitario;
    }

    @Override
    public String toString() {
        return "ItemFactura -> Producto -> " + this.producto + ", Cantidad -> " + this.cantidad + ", Precio Unitario -> " + precioUnitario;
    }
}
