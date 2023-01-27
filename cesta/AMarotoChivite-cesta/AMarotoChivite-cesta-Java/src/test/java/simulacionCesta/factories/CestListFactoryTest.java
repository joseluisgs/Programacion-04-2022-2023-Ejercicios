package simulacionCesta.factories;

import org.junit.jupiter.api.Test;
import simulacionCesta.models.CestList;
import simulacionCesta.models.Product;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CestListFactoryTest {

    @Test
    public void cestListFactoryCreateTest() {
        CestList cestList = CestListFactory.create();
        // Comprobar que la longitud de la lista de la cesta es 10
        assertEquals(10, cestList.getStorageProducts().length);
    }

    @Test
    public void checkProductNoRepeatTest() {
        CestList cestList = CestListFactory.create();
        Product[] productsStorage = cestList.getStorageProducts();
        boolean noRepeat = true;
        for (int i = 0; i < productsStorage.length; i++) {
            for (int j = i + 1; j < productsStorage.length; j++) {
                if (productsStorage[i].name.equals(productsStorage[j].name)) {
                    noRepeat = false;
                    break;
                }
            }
        }
        assertTrue(noRepeat);
    }
}