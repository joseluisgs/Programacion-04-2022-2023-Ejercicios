package gameCatan.factories

import gameCatan.enums.TypeOwner
import gameCatan.models.Box
import gameCatan.utils.randomData

object BoxFactory {
    @JvmStatic
    fun create(): Box {
        val type = randomData.randomType()
        val randomValue = (Math.random() * 6 + 1).toInt()
        return Box(type, TypeOwner.NONE, randomValue)
    }
}