package simulacionTaller.factories;

import org.junit.jupiter.api.Test;
import simulacionTaller.models.PersonBrench;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;
import static simulacionTaller.factories.WorkShopFactory.getQuantityMulti;

class WorkShopFactoryTest {

    @Test
    void createTest() {
        PersonBrench[] workShop = WorkShopFactory.create(50, 10, 20, 20);
        // No nulo, para ver si se han asignado correctamente los datos
        assertNotNull(workShop);
    }

    @Test
    void getQuantityMultiTest() {
        int quantityMulti = getQuantityMulti(3);
        int[] correctValues = {0, 1, 2, 3};
        int countValue = 0;
        for (int i = 0; i < correctValues.length; i++) {
            if (correctValues[i] == quantityMulti) {
                countValue++;
            }
        }
        if (countValue != 1) {
            fail();
        }
    }
}