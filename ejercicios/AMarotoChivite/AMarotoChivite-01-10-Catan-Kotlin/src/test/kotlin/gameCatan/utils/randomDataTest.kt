package gameCatan.utils

import gameCatan.enums.TypeResource
import gameCatan.utils.randomData.randomType
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class randomDataTest {
    @Test
    fun randomTypeTest() {
        val typeTest = randomType()
        val correctTypes = arrayOf(TypeResource.WOOD, TypeResource.COAL, TypeResource.SEED)
        var count = 0
        for (i in correctTypes.indices) {
            if (correctTypes[i] == typeTest) {
                count++
            }
        }
        if (count != 1) {
            Assertions.fail<Any>()
        }
    }
}