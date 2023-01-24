package gameCatan.models

import gameCatan.enums.TypeOwner
import gameCatan.enums.TypeResource

class Box(var typeResource: TypeResource?, @JvmField var owner: TypeOwner, var randomValue: Int) {
    // Mediante el ID, podremos tener un control mayor sobre nuestra matriz
    val idBox = betterVisualNextId

    companion object {
        /**
         * Creamos un get, para encapsular el valor del contador y no poderlo manipular
         */
        // Campo de clase para mantener el incremento
        var countBox = 1
            private set
        val betterVisualNextId: String
            /**
             * Cuando al método, aumentará nuestro ID
             *
             * @return nextId aumentado
             */
            get() {
                var contadorCantidadCifras = 0
                val cifrasID = countBox.toString() + ""
                for (i in 0 until cifrasID.length) {
                    contadorCantidadCifras++
                }
                return if (contadorCantidadCifras == 1) {
                    "0" + countBox++
                } else {
                    countBox++.toString() + ""
                }
            }
    }
}