package org.example.factories;

import org.example.models.Producto;

import java.util.Random;

public final class ProductoFactory {
    //singleton
    private static ProductoFactory instance;

    public static ProductoFactory getInstance() {
        if (instance == null) {
            instance = new ProductoFactory();
        }
        return instance;
    }

    private final Random random = new Random();
    public float getPrecioRandom(){
        float randomFloat = random.nextFloat(1f,500f);
        return (float) Math.round(randomFloat * 100) / 100;
    }

    private String getNombreRandom(){
        String[] nombres = {"Mavic Air 2", "Mavic Mini 2", "Mavic Mini 3", "Mavic Mini 3 Pro", "Dji Avata", "Mavic 3", "Mavic 3 Classic"};
        return nombres[random.nextInt(nombres.length)];
    }

    public Producto createProductoRandom(){
        String nombre = getNombreRandom();
        float precio = getPrecioRandom();
        int stock = random.nextInt(1,25);
        return new Producto(nombre, precio, stock);
    }

    public void createProductosRandom(Producto[] array){
        for (int i = 0; i < array.length; i++)
        {
            Producto producto;
            do {
                producto = createProductoRandom();
                for (int j = 0; j < i; j++) {
                    /*if (array[j].equals(producto)) {
                        producto = null;
                        break;
                    }*/
                    if (array[j].getNombre().equals(producto.getNombre())) {
                        producto = null;
                        break;
                    }
                }
            }while (producto == null);
            array[i] = producto;
        }
    }

}
