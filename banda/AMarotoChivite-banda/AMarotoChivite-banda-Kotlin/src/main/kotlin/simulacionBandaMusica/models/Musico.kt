package simulacionBandaMusica.models

import simulacionBandaMusica.enums.TipoGuitarra
import simulacionBandaMusica.enums.TipoPercusion

abstract sealed class Musico(name: String?, var instrumento: String, var annoExperiencia: Int) : Person(name) {

    init {
        autoContadorMusic()
    }

    /**
     * Aumentamos un ID por cada músico que hemos creado, para disponer de un contador
     */
    private fun autoContadorMusic() {
        contadorMusic++
    }

    /**
     * El musico nos informará que está interprentando con su instrumento
     *
     * @return mensaje del músico
     */
    fun interpretar(): String {
        return "Estoy interpretando con mi " + instrumento
    }

    companion object {
        const val salario = 1500

        /**
         * Creamos un get, para encapsular el valor del contador y no poderlo manipular
         */
        // Campo de clase para mantener el incremento
        var contadorMusic = 0
            private set
    }

    // Clases dentro de Sealed Class:
    class Bajista(name: String?, instrumento: String, annoExperiencia: Int, var numCuerdas: Int) :
        Musico(name, instrumento, annoExperiencia) {
        val salarioBajista: Int = (salario * 1.30).toInt()
        val id: Int

        // Para instanciar posteriormente con el factory
        init {
            id = autoContadorBajista()
        }

        /**
         * Aumentamos un ID por cada cantante que hemos creado, para disponer de un contador
         *
         * @return el ID del contador
         */
        private fun autoContadorBajista(): Int {
            return contadorBajista++
        }

        override fun toString(): String {
            return "Bajista " + (id + 1) + "{" +
                    " name= " + name +
                    ", salarioBajista=" + salarioBajista +
                    ", numCuerdas=" + numCuerdas +
                    ", instrumento='" + instrumento + '\'' +
                    ", annoExperiencia=" + annoExperiencia +
                    '\'' +
                    "}"
        }

        companion object {
            /**
             * Creamos un get, para encapsular el valor del contador en private y no poderlo manipular
             */
            var contadorBajista = 0
                private set
        }
    }

    class Cantante(name: String?, instrumento: String, annoExperiencia: Int, var capacidadPulomar: Int) :
        Musico(name, instrumento, annoExperiencia) {
        val salarioCantante: Int = (Musico.Companion.salario * 1.4).toInt()
        val id: Int

        // Para instanciar posteriormente con el factory
        init {
            id = autoContadorCantante()
        }

        /**
         * Aumentamos un ID por cada cantante que hemos creado, para disponer de un contador
         *
         * @return el ID del contador
         */
        private fun autoContadorCantante(): Int {
            return contadorCantante++
        }

        fun respirarCantante(): String {
            return "Estoy respirando como cantante con una capacidad pulmonar de $capacidadPulomar"
        }

        override fun toString(): String {
            return "Cantante " + (id + 1) + "{" +
                    " name= " + name +
                    ", salarioCantante=" + salarioCantante +
                    ", capacidadPulmonar=" + capacidadPulomar +
                    ", instrumento='" + instrumento + '\'' +
                    ", annoExperiencia=" + annoExperiencia +
                    '\'' +
                    "}"
        }

        companion object {
            /**
             * Creamos un get, para encapsular el valor del contador y no poderlo manipular
             */
            var contadorCantante = 0
                private set
        }
    }

    class CantantePro(
        name: String?,
        instrumento: String,
        annoExperiencia: Int,
        capacidadPulomar: Int,
        var tipoGuitarra: TipoGuitarra?
    ) : Musico(name, instrumento, annoExperiencia) {
        val salarioCantantePro: Int = (Musico.Companion.salario * 1.5).toInt()
        val id: Int
        var capacidadPulomar = 0

        init {
            id = autoContadorCantantePro()
        }

        /**
         * Aumentamos un ID por cada cantante que hemos creado, para disponer de un contador
         *
         * @return el ID del contador
         */
        private fun autoContadorCantantePro(): Int {
            return contadorBajista++
        }

        override fun toString(): String {
            return "CantantePro " + (id + 1) + "{" +
                    " name= " + name +
                    ", salarioCantantePro=" + salarioCantantePro +
                    ", capacidadPulmonar=" + capacidadPulomar +
                    ", tipoGuitarra=" + tipoGuitarra +
                    ", instrumento='" + instrumento + '\'' +
                    ", annoExperiencia=" + annoExperiencia +
                    '\'' +
                    "}"
        }

        companion object {
            /**
             * Creamos un get, para encapsular el valor del contador y no poderlo manipular
             */
            var contadorBajista = 0
                private set
        }
    }

    class Guitarrista(name: String?, instrumento: String, annoExperiencia: Int, var tipoGuitarra: TipoGuitarra?) :
        Musico(name, instrumento, annoExperiencia) {
        val salarioGuitarrista: Int = (Musico.Companion.salario * 1.35).toInt()
        val id: Int

        // Para instanciar posteriormente con el factory
        init {
            id = autoContadorGuitarrista()
        }

        /**
         * Aumentamos un ID por cada cantante que hemos creado, para disponer de un contador
         *
         * @return el ID del contador
         */
        private fun autoContadorGuitarrista(): Int {
            return contadorGuitarrista++
        }

        override fun toString(): String {
            return "Guitarrista " + (id + 1) + "{" +
                    " name= " + name +
                    ", salarioGuitarrista=" + salarioGuitarrista +
                    ", tipoGuitarra=" + tipoGuitarra +
                    ", instrumento='" + instrumento + '\'' +
                    ", annoExperiencia=" + annoExperiencia +
                    '\'' +
                    "}"
        }

        companion object {
            /**
             * Creamos un get, para encapsular el valor del contador y no poderlo manipular
             */
            var contadorGuitarrista = 0
                private set
        }
    }

    class MultiInstrumentista(
        name: String?,
        instrumento: String,
        annoExperiencia: Int,
        var numCuerdas: Int,
        var numTeclas: Int,
        var tipoPercusion: TipoPercusion?
    ) : Musico(name, instrumento, annoExperiencia) {
        val salarioMultiInstrumento: Int = (Musico.Companion.salario * 1.65).toInt()
        val id: Int

        init {
            id = autoContadorMultiInstrumento()
        }

        /**
         * Aumentamos un ID por cada cantante que hemos creado, para disponer de un contador
         *
         * @return el ID del contador
         */
        private fun autoContadorMultiInstrumento(): Int {
            return contadorBajista++
        }

        override fun toString(): String {
            return "MultiInstrumento " + (id + 1) + "{" +
                    " name= " + name +
                    ", salarioBajista=" + salarioMultiInstrumento +
                    ", numCuerdasBajo=" + numCuerdas +
                    ", numTeclasTeclado=" + numTeclas +
                    ", tipoPercusión=" + tipoPercusion +
                    ", instrumento='" + instrumento + '\'' +
                    ", annoExperiencia=" + annoExperiencia +
                    '\'' +
                    "}"
        }

        companion object {
            /**
             * Creamos un get, para encapsular el valor del contador y no poderlo manipular
             */
            var contadorBajista = 0
                private set
        }
    }

    class Percusionista(name: String?, instrumento: String, annoExperiencia: Int, var tipoPercusion: TipoPercusion?) :
        Musico(name, instrumento, annoExperiencia) {
        val salarioPercusionista: Int = (Musico.Companion.salario * 1.35).toInt()
        val id: Int

        // Para instanciar posteriormente con el factory
        init {
            id = autoContadorPercusionista()
        }

        /**
         * Aumentamos un ID por cada cantante que hemos creado, para disponer de un contador
         *
         * @return el ID del contador
         */
        private fun autoContadorPercusionista(): Int {
            return contadorPercusionista++
        }

        override fun toString(): String {
            return "Percusionista " + (id + 1) + "{" +
                    " name= " + name +
                    ", salarioPercusionista=" + salarioPercusionista +
                    ", tipoPercusión=" + tipoPercusion +
                    ", instrumento='" + instrumento + '\'' +
                    ", annoExperiencia=" + annoExperiencia +
                    '\'' +
                    "}"
        }

        companion object {
            /**
             * Creamos un get, para encapsular el valor del contador y no poderlo manipular
             */
            var contadorPercusionista = 0
                private set
        }
    }

    class Teclista(name: String?, instrumento: String, annoExperiencia: Int, var numTeclas: Int) :
        Musico(name, instrumento, annoExperiencia) {
        val salarioTeclista: Int = (Musico.Companion.salario * 1.30).toInt()
        val id: Int

        // Para instanciar posteriormente con el factory
        init {
            id = autoContadorTeclista()
        }

        /**
         * Aumentamos un ID por cada cantante que hemos creado, para disponer de un contador
         *
         * @return el ID del contador
         */
        private fun autoContadorTeclista(): Int {
            return contadorTeclista++
        }

        override fun toString(): String {
            return "Teclista " + (id + 1) + "{" +
                    " name= " + name +
                    ", salarioTeclista=" + salarioTeclista +
                    ", numTeclas=" + numTeclas +
                    ", instrumento='" + instrumento + '\'' +
                    ", annoExperiencia=" + annoExperiencia +
                    '\'' +
                    "}"
        }

        companion object {
            /**
             * Creamos un get, para encapsular el valor del contador y no poderlo manipular
             */
            var contadorTeclista = 0
                private set
        }
    }

    class Trompetista(name: String?, instrumento: String, annoExperiencia: Int, var capacidadPulomar: Int) :
        Musico(name, instrumento, annoExperiencia) {
        val salarioTrompetista: Int = (Musico.Companion.salario * 1.4).toInt()
        val id: Int

        // Para instanciar posteriormente con el factory
        init {
            id = autoContadorTrompetista()
        }

        /**
         * Aumentamos un ID por cada cantante que hemos creado, para disponer de un contador
         *
         * @return el ID del contador
         */
        private fun autoContadorTrompetista(): Int {
            return contadorTrompetista++
        }

        fun respirarTrompetista(): String {
            return "Estoy respirando como trompetista con una capacidad pulmonar de $capacidadPulomar"
        }

        override fun toString(): String {
            return "Trompetista " + (id + 1) + "{" +
                    " name= " + name +
                    ", salarioTrompetista=" + salarioTrompetista +
                    ", capacidadPulomar=" + capacidadPulomar +
                    ", instrumento='" + instrumento + '\'' +
                    ", annoExperiencia=" + annoExperiencia +
                    '\'' +
                    "}"
        }

        companion object {
            /**
             * Creamos un get, para encapsular el valor del contador y no poderlo manipular
             */
            var contadorTrompetista = 0
                private set
        }
    }
}