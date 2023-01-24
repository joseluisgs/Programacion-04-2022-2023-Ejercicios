package simulacionCesta.factories;

import org.junit.jupiter.api.Test;
import simulacionCesta.models.Product;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class ProductFactoryTest {

    @Test
    public void prodcutFactoryCreateTest() {
        Product product = ProductFactory.create();
        // Comprobar que la cesta final contiene una cesta no vacía
        assertNotNull(product);
    }
}