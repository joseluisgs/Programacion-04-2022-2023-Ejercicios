package simulacionTaller;

import simulacionTaller.factories.WorkShopFactory;
import simulacionTaller.models.PersonBrench;

import static simulacionTaller.utils.funcionesMenu.menuWorkShop;

public class simulacionTaller {
    public static void main(String[] args) throws InterruptedException {
        // Instanciamos y ejecutamos el menú
        PersonBrench[] workBench = WorkShopFactory.create(54, 10, 20, 20);
        menuWorkShop(workBench);

    }
}
