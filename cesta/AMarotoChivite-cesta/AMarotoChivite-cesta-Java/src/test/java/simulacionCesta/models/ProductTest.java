package simulacionCesta.models;

import org.junit.jupiter.api.Test;
import simulacionCesta.factories.ProductFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductTest {

    @Test
    void calculateTotalPricePerProductTest() {
        Product productTest = ProductFactory.create();
        productTest.unitaryPrice = 2;
        productTest.quantity = 2;
        assertEquals(4, productTest.calculateTotalPricePerProduct());
    }
}