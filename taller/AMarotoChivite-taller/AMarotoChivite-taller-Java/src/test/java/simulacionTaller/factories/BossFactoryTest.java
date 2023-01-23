package simulacionTaller.factories;

import org.junit.jupiter.api.Test;
import simulacionTaller.models.Boss;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class BossFactoryTest {

    @Test
    void createTest() {
        Boss boss = BossFactory.create();
        // No nulo, para ver si se han asignado correctamente los datos
        assertNotNull(boss);
    }
}