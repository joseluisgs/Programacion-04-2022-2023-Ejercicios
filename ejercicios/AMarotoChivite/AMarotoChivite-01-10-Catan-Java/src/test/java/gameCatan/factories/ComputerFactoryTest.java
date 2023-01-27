package gameCatan.factories;

import gameCatan.models.Computer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class ComputerFactoryTest {

    @Test
    void create() {
        Computer computerTest = ComputerFactory.create();
        assertNotNull(computerTest);
    }
}