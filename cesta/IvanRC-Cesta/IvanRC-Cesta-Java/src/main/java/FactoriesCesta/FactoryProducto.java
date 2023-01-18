package FactoriesCesta;

import ModelsCesta.Producto;

public class FactoryProducto {

    public FactoryProducto(){}
    private static FactoryProducto instance = null;

    public static FactoryProducto getInstance(){
        if(instance == null){
            instance = new FactoryProducto();
        }
        return instance;
    }
    private static int contadorProducto = 1;
    private int nextId(){
        return contadorProducto++;
    }

    /**
     * función que sirve para crear un producto aleatoriamente
     * @return el producto cuyas propiedades se crearon al azar
     */
    public Producto crearProductoRandom() {
        final double[] precioUnitario = {12.0,2.32,4.3,4.56,76.44,22.0,12.43,24.3,8.56,7.44,16.0, 34.32,4.44,7.54,7.84,9.74,8.45,3.24,15.98,6.09,4.99};
        final String[] nombreProductos = {"gasolina", "coche", "moto", "camión", "mira", "telefono", "gato", "deberes", "sofa", "silla", "chalet", "garrafa", "garra", "portatil", "procesador", "rueda", "carrusel", "pinguino", "pera", "manzana", "aguacate"};
        return new Producto(nextId(), precioUnitario[(int) (Math.random()*precioUnitario.length)], nombreProductos[(int) (Math.random()*nombreProductos.length)]);
    }
}
