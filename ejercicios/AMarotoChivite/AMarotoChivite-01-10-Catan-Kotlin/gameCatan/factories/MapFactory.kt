package gameCatan.factories

import gameCatan.models.Box
import gameCatan.models.Map
import gameCatan.utils.funciones.checkTwiceResources

object MapFactory {
    @JvmStatic
    fun create(): Map {
        val sizeRow = 3
        val sizeCol = 4
        val mapOfBoxes = Array(sizeRow) { arrayOfNulls<Box>(sizeCol) }
        do {
            for (i in mapOfBoxes.indices) {
                for (j in mapOfBoxes[i].indices) {
                    mapOfBoxes[i][j] = BoxFactory.create()
                }
            }
        } while (!checkTwiceResources(mapOfBoxes))

        return Map(sizeRow, sizeCol, mapOfBoxes)
    }
}