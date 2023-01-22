package simulacionTaller

import simulacionTaller.factories.WorkShopFactory
import simulacionTaller.utils.menuWorkShop

fun main(args: Array<String>) {
    // Instanciamos y ejecutamos el menú
    val workBench = WorkShopFactory.create(50, 10, 20, 20)
    menuWorkShop(workBench)
}
