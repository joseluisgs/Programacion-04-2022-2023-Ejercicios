package gameCatan.utils

import gameCatan.enums.TypeResource

object randomData {
    @JvmStatic
    fun randomType(): TypeResource {
        val random = (Math.random() * 3 + 1).toInt()
        return if (random == 1) {
            TypeResource.WOOD
        } else if (random == 2) {
            TypeResource.COAL
        } else {
            TypeResource.SEED
        }
    }
}