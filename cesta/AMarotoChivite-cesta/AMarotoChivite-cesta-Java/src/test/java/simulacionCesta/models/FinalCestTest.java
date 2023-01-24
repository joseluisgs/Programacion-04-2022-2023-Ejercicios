package simulacionCesta.models;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;


class FinalCestTest {

    @Test
    public void calculateTotalPriceTest() {
        LocalDate dateCreation = LocalDate.now();
        Product product1 = new Product("Agua", 1.0, 2);
        Product product2 = new Product("Pan", 2.0, 1);

        Product[] products = {product1, product2};
        CestList cestList = new CestList(2, products);
        FinalCest finalCest = new FinalCest(dateCreation, cestList);
        assertEquals(4.0, finalCest.calculateTotalPrice());
    }

    @Test
    void calculateQuantityProductsTest() {
        LocalDate dateCreation = LocalDate.now();
        Product product1 = new Product("Agua", 1.0, 2);
        Product product2 = new Product("Pan", 2.0, 1);

        Product[] products = {product1, product2};
        CestList cestList = new CestList(2, products);
        FinalCest finalCest = new FinalCest(dateCreation, cestList);
        assertEquals(3, finalCest.calculateQuantityProducts());
    }
}