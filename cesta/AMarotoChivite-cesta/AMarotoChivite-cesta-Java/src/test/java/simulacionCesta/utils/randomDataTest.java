package simulacionCesta.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static simulacionCesta.utils.randomData.*;

class randomDataTest {

    @Test
    public void randomProductNameTest() {
        String productName = randomProductName();
        // Comprobar que el producto devuelto está dentro del catálogo
        String[] storageProductos = {
                "Pan", "Leche", "Miel", "Chocolate",
                "Manzana", "Melocotón", "Sandía", "Cereal",
                "Harina", "Agua", "Zumo", "Patata", "Zanahoria",
                "Papel", "Mantequilla", "Queso",
                "Jamón", "Yogur", "Flan", "Avellanas", "Sal",
                "Azúcar", "Lechuga", "Canónigos"
        };
        boolean isInCatalog = false;
        for (String i : storageProductos) {
            if (i.equals(productName)) {
                isInCatalog = true;
                break;
            }
        }
        assertTrue(isInCatalog);
    }

    @Test
    public void randomPriceTest() {
        // Comprobar que el precio generado está entre 0.35 y 2.34 = (1.99+0.35)
        for (int i = 0; i < 20; i++) {
            double priceTest = randomPrice();
            assertTrue(priceTest >= 0.35 && priceTest <= 2.34);
        }
    }

    @Test
    public void randomQuantityTest() {
        // Comprobar que la cantidad devuelta está entre 1 y 5 (incluidos)
        for (int i = 0; i < 20; i++) {
            int quantity = randomQuantity();
            assertTrue(quantity >= 1 && quantity <= 5);
        }
    }
}