package simulacionCesta.utils;

import java.util.Random;

public class randomData {
    /**
     * Genera de manera aleatoria un producto dentro de nuestro catálogo
     *
     * @return storageProductos[num], es el producto aleatorio
     */
    public static String randomProductName() {
        Random r = new Random();
        int num = r.nextInt(24);
        String[] storageProductos = {
                "Pan", "Leche", "Miel", "Chocolate",
                "Manzana", "Melocotón", "Sandía", "Cereal",
                "Harina", "Agua", "Zumo", "Patata", "Zanahoria",
                "Papel", "Mantequilla", "Queso",
                "Jamón", "Yogur", "Flan", "Avellanas", "Sal",
                "Azúcar", "Lechuga", "Canónigos"
        };
        return storageProductos[num];
    }

    /**
     * Genera aleatoriamente un número entre decimal
     *
     * @return precio con decimales
     */
    public static double randomPrice() {
        // Estaremos en bucle hasta que un precio tenga x.xx€ para evitar decimales muy largos
        while (true) {
            double intPart = Math.round(Math.random());
            double decimalPart = Math.round(Math.random() * 100d) / 100d;
            String checkPrice = Double.toString(intPart + decimalPart);

            if (checkPrice.length() == 4) {
                // sumo 0.35 por si da el caso que me da un resultado 0
                return intPart + decimalPart + 0.35;
            }
        }
    }

    /**
     * Genera aleatoriamente un número entre 1 y 5 (incluidos)
     *
     * @return cantidad de un producto
     */
    public static int randomQuantity() {
        return (int) Math.round(Math.random() * 4 + 1);
    }

}

