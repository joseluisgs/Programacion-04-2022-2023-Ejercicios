package simulacionTaller.factories

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import simulacionTaller.factories.WorkShopFactory.create
import simulacionTaller.factories.WorkShopFactory.getQuantityMulti

internal class WorkShopFactoryTest {
    @Test
    fun createTest() {
        val workShop = create(50, 10, 20, 20)
        // No nulo, para ver si se han asignado correctamente los datos
        Assertions.assertNotNull(workShop)
    }

    @get:Test
    val quantityMultiTest: Unit
        get() {
            val quantityMulti = getQuantityMulti(3)
            val correctValues = intArrayOf(0, 1, 2, 3)
            var countValue = 0
            for (i in correctValues.indices) {
                if (correctValues[i] == quantityMulti) {
                    countValue++
                }
            }
            if (countValue != 1) {
                Assertions.fail<Any>()
            }
        }
}