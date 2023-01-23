package simulacionCesta.factories;

import simulacionCesta.models.Product;

import static simulacionCesta.utils.randomData.*;

public class ProductFactory {
    public static Product create() {
        String name = randomProductName();
        double price = randomPrice();
        int quantity = randomQuantity();

        return new Product(name, price, quantity);
    }
}
