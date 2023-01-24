package gameCatan.factories

import gameCatan.models.Human

object HumanFactory {
    @JvmStatic
    fun create(): Human {
        return Human(0, 0, 0)
    }
}