package gameCatan.factories;

import gameCatan.models.Map;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class MapFactoryTest {

    @Test
    void create() {
        Map mapTest = MapFactory.create();
        assertNotNull(mapTest);
    }
}