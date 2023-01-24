package gameCatan.models

import gameCatan.enums.TypeOwner
import simulacionCine.enums.Color

class Map(var sizeRow: Int, var sizeCol: Int, @JvmField var matrix: Array<Array<Box?>>) {
    fun print() {
        for (filas in matrix.indices) {
            for (columnas in matrix[filas].indices) {
                if (columnas == matrix[filas].size - 1) {
                    if (matrix[filas][columnas]!!.owner == TypeOwner.HUMAN) {
                        println(Color.PURPLE.get() + matrix[filas][columnas]!!.typeResource!!.get() + Color.RESET.get() + matrix[filas][columnas]!!.randomValue)
                    } else if (matrix[filas][columnas]!!.owner == TypeOwner.COMPUTER) {
                        println(Color.RED.get() + matrix[filas][columnas]!!.typeResource!!.get() + Color.RESET.get() + matrix[filas][columnas]!!.randomValue)
                    } else {
                        println(matrix[filas][columnas]!!.typeResource!!.get() + matrix[filas][columnas]!!.randomValue)
                    }
                } else {
                    if (matrix[filas][columnas]!!.owner == TypeOwner.HUMAN) {
                        print((Color.PURPLE.get() + matrix[filas][columnas]!!.typeResource!!.get() + Color.RESET.get() + matrix[filas][columnas]!!.randomValue).toString() + " ")
                    } else if (matrix[filas][columnas]!!.owner == TypeOwner.COMPUTER) {
                        print((Color.RED.get() + matrix[filas][columnas]!!.typeResource!!.get() + Color.RESET.get() + matrix[filas][columnas]!!.randomValue).toString() + " ")
                    } else {
                        print(matrix[filas][columnas]!!.typeResource!!.get() + matrix[filas][columnas]!!.randomValue + " ")
                    }
                }
            }
        }
        println("----------------------------------")
        println(
            """LEYENDA:
nº -> cantidad del material
M -> (madera), C -> (carbón), T -> (trigo) 
${Color.PURPLE.get()}MORADO${Color.RESET.get()} -> (propiedad humano), ${Color.RED.get()}ROJO${Color.RESET.get()} -> (propiedad máquina)"""
        )
        println()
    }
}