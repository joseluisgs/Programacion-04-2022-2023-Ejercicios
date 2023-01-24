package gameCatan.factories

import gameCatan.models.Computer

object ComputerFactory {
    @JvmStatic
    fun create(): Computer {
        return Computer(0, 0, 0)
    }
}