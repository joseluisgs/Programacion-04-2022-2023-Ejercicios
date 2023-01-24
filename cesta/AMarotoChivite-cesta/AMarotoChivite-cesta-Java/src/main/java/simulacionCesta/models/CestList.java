package simulacionCesta.models;

public class CestList {
    public int maxSizeStorage;
    public Product[] storageProducts;

    public CestList(int maxSizeStorage, Product[] storageProducts) {
        this.maxSizeStorage = maxSizeStorage;
        this.storageProducts = storageProducts;
    }

    public Product[] getStorageProducts() {
        return storageProducts;
    }
    
    public void printProducts() {
        for (int i = 0; i < storageProducts.length; i++) {
            System.out.println(storageProducts[i]);
        }
    }

}