package gameCatan;

import gameCatan.factories.ComputerFactory;
import gameCatan.factories.HumanFactory;
import gameCatan.factories.MapFactory;
import gameCatan.models.Computer;
import gameCatan.models.Human;
import gameCatan.models.Map;

import static gameCatan.utils.funciones.simulationCatan;

public class simulationCatan {
    public static void main(String[] args) throws InterruptedException {

        // Inicialización de nuestros objetos
        Map map = MapFactory.create();
        Human playerHumano = HumanFactory.create();
        Computer playerComputer = ComputerFactory.create();
        // Iniciamos simulación
        simulationCatan(map, playerHumano, playerComputer);
    }

}
