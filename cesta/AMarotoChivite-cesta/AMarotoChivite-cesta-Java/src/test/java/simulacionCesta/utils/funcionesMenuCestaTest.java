package simulacionCesta.utils;

import org.junit.jupiter.api.Test;
import simulacionCesta.models.CestList;
import simulacionCesta.models.FinalCest;
import simulacionCesta.models.Product;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static simulacionCesta.utils.funcionesMenuCesta.*;

class funcionesMenuCestaTest {

    @Test
    public void listByNameTest() {
        Product product1 = new Product("Manzana", 2.0, 4);
        Product product2 = new Product("Cereal", 2.5, 2);
        Product product3 = new Product("Zanahoria", 1.5, 1);
        Product product4 = new Product("Agua", 1, 2);

        Product[] productsTest = {product1, product2, product3, product4};
        CestList cestListTest = new CestList(4, productsTest);
        FinalCest finalCestTest = new FinalCest(LocalDate.now(), cestListTest);
        listByNameAscendent(finalCestTest);

        // Verificar que los productos están ordenados correctamente
        assertEquals("Agua", finalCestTest.productsStorage.getStorageProducts()[0].name);
        assertEquals("Cereal", finalCestTest.productsStorage.getStorageProducts()[1].name);
        assertEquals("Manzana", finalCestTest.productsStorage.getStorageProducts()[2].name);
        assertEquals("Zanahoria", finalCestTest.productsStorage.getStorageProducts()[3].name);
    }

    @Test
    public void listByPriceTest() {
        Product product1 = new Product("Manzana", 2.0, 4);
        Product product2 = new Product("Cereal", 2.5, 6);
        Product product3 = new Product("Zanahoria", 1.5, 1);
        Product product4 = new Product("Agua", 1, 2);

        Product[] productsTest = {product1, product2, product3, product4};
        CestList cestListTest = new CestList(4, productsTest);
        FinalCest finalCestTest = new FinalCest(LocalDate.now(), cestListTest);
        listByPriceDescendent(finalCestTest);

        // Verificar que los productos están ordenados correctamente
        assertEquals("Cereal", finalCestTest.productsStorage.getStorageProducts()[0].name);
        assertEquals("Manzana", finalCestTest.productsStorage.getStorageProducts()[1].name);
        assertEquals("Agua", finalCestTest.productsStorage.getStorageProducts()[2].name);
        assertEquals("Zanahoria", finalCestTest.productsStorage.getStorageProducts()[3].name);
    }

    @Test
    public void deleteProductTest() throws InterruptedException {
        // Creamos una cesta de prueba
        Product[] productsStorage = new Product[2];
        productsStorage[0] = new Product("Manzana", 1, 3);
        productsStorage[1] = new Product("Leche", 2, 1);
        CestList cestList = new CestList(2, productsStorage);
        FinalCest cest = new FinalCest(LocalDate.now(), cestList);

        // Eliminamos el primer producto (Manzana)
        deleteProduct(cest, 0);

        // Comprobamos que se ha eliminado correctamente
        assertEquals("Leche", cest.productsStorage.getStorageProducts()[0].name);
        assertEquals(1, cest.productsStorage.getStorageProducts()[0].quantity);
        assertEquals(2, cest.productsStorage.getStorageProducts()[0].unitaryPrice);
    }

    @Test
    public void newCestTest() throws InterruptedException {
        // Crear una cesta de prueba
        Product product1 = new Product("Agua", 1, 2);
        Product[] products = {product1};
        Product[] products2 = products.clone();
        CestList cestList = new CestList(1, products);
        CestList cestList2 = new CestList(1, products2);

        FinalCest cest = new FinalCest(LocalDate.now(), cestList);

        newCest(cest);
        assertNotEquals(cestList2, cest.productsStorage);
    }


    @Test
    public void checkIntegerTest() throws InterruptedException {
        String correctAnswer1 = "1";
        String correctAnswer2 = "5";
        String correctAnswer3 = "10";
        String correctAnswer4 = "50";
        String incorrectAnswer1 = ".";
        String incorrectAnswer2 = "a";
        assertTrue(checkInteger(correctAnswer1));
        assertTrue(checkInteger(correctAnswer2));
        assertTrue(checkInteger(correctAnswer3));
        assertTrue(checkInteger(correctAnswer4));
        assertFalse(checkInteger(incorrectAnswer1));
        assertFalse(checkInteger(incorrectAnswer2));
    }
}