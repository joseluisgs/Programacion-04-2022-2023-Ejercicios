package simulacionCesta.models;

public class Product {
    // Campo de clase para mantener el incremento
    private static int countProduct = 0;
    private final int idProduct = countProduct;

    public String name;
    public double unitaryPrice;
    public int quantity;

    public Product(String name, double unitaryPrice, int quantity) {
        this.name = name;
        this.unitaryPrice = unitaryPrice;
        this.quantity = quantity;
        autoCountProduct();
    }

    /**
     * Calcula el precio total de un producto
     *
     * @return precio total de un producto
     */
    public double calculateTotalPricePerProduct() {
        return (unitaryPrice * quantity);
    }

    @Override
    public String toString() {
        return "Product{" +
                "idProduct=" + (idProduct + 1) +
                ", name='" + name + '\'' +
                ", unitaryPrice=" + unitaryPrice +
                ", quantity=" + quantity +
                ", Total= " + calculateTotalPricePerProduct() +
                '}';
    }

    /**
     * Aumentamos un ID por cada producto que hemos creado, para disponer de un contador
     */
    private void autoCountProduct() {
        countProduct++;
    }


}