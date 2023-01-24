package gameCatan.factories;

import gameCatan.models.Computer;

public class ComputerFactory {

    public static Computer create() {
        return new Computer(0, 0, 0);
    }
}
