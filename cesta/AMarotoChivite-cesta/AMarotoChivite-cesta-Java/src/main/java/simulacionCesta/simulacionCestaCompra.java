package simulacionCesta;

import simulacionCesta.factories.FinalCestFactory;
import simulacionCesta.models.FinalCest;

import static simulacionCesta.utils.funcionesMenuCesta.menuCest;

public class simulacionCestaCompra {
    public static void main(String[] args) throws InterruptedException {
        // Inicializamos la línea de cesta que contiene objetos aleatorios
        FinalCest cest = FinalCestFactory.create();
        // Iniciamos menú
        menuCest(cest);
    }
}
