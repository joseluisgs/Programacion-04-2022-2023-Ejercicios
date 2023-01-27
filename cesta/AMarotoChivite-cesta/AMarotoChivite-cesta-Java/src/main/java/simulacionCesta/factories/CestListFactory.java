package simulacionCesta.factories;

import simulacionCesta.models.CestList;
import simulacionCesta.models.Product;

public class CestListFactory {
    public static CestList create() {
        // Por defecto presenta un tamaño 10 de máximo
        int randomSize = 10;
        Product[] productsStorage = new Product[randomSize];

        do {
            // Introducimos productos aleatorios en la línea de cesta
            for (int i = 0; i < productsStorage.length; i++) {
                productsStorage[i] = ProductFactory.create();
            }
            // No saldremos hasta que genere por cada línea de producto un producto distinto
        } while (!checkProductNoRepeat(productsStorage));

        return new CestList(randomSize, productsStorage);
    }

    /**
     * Verificamos que se generen por cada línea de producto un producto distinto
     *
     * @param productsStorage el almacén que ha generado productos para verificar
     * @return true si no hay productos iguales, false en caso contrario
     */
    public static boolean checkProductNoRepeat(Product[] productsStorage) {
        for (int i = 0; i < productsStorage.length; i++) {
            for (int j = i + 1; j < productsStorage.length; j++) {
                if (productsStorage[i].name.equals(productsStorage[j].name)) {
                    return false;
                }
            }
        }
        return true;
    }
}
