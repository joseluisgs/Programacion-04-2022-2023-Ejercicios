package simulacionCesta.models;

import java.time.LocalDate;

public class FinalCest {
    // Campo de clase para mantener el incremento
    private static int countFinalCest = 0;
    private final int idFinalCest = countFinalCest;
    public LocalDate creationDate;
    public CestList productsStorage;

    public FinalCest(LocalDate creationDate, CestList productsStorage) {
        this.creationDate = creationDate;
        this.productsStorage = productsStorage;
        autoCountFinalCest();
    }

    /**
     * Imprime en pantalla la cesta completa en detalle
     */
    public void printCompleteCest() {
        System.out.println("==============================================================");
        System.out.println("====== |CESTA " + (idFinalCest + 1) + "| |CREADA = " + creationDate + "| ======");
        System.out.println("==============================================================");
        productsStorage.printProducts();
        System.out.println("==============================================================");
        System.out.println("Cantidad de productos a comprar: " + calculateQuantityProducts());
        System.out.println("Por un precio de: " + calculateTotalPrice() + " €");
        System.out.println("==============================================================");
    }

    /**
     * Calcula el precio total que nos costará comprar todos los productos de la cesta
     *
     * @return totalQuantity cantidad de productos en total
     */
    public double calculateTotalPrice() {
        double totalPrice = 0;
        for (int i = 0; i < productsStorage.getStorageProducts().length; i++) {
            if (productsStorage.getStorageProducts()[i] != null) {
                totalPrice = totalPrice + productsStorage.getStorageProducts()[i].calculateTotalPricePerProduct();
            }
        }
        return totalPrice;
    }

    /**
     * Calcula la cantidad de productos en total que disponemos en la cesta
     *
     * @return totalQuantity cantidad de productos en total
     */
    public int calculateQuantityProducts() {
        int totalQuantity = 0;
        for (int i = 0; i < productsStorage.getStorageProducts().length; i++) {
            if (productsStorage.getStorageProducts()[i] != null) {
                totalQuantity = totalQuantity + productsStorage.getStorageProducts()[i].quantity;
            }
        }
        return totalQuantity;
    }

    /**
     * Aumentamos un ID por cada producto que hemos creado, para disponer de un contador
     */
    private void autoCountFinalCest() {
        countFinalCest++;
    }
}