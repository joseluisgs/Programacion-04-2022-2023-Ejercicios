package gameCatan.factories;

import gameCatan.models.Box;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class BoxFactoryTest {

    @Test
    void create() {
        Box boxTest = BoxFactory.create();
        assertNotNull(boxTest);
    }
}