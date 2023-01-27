package bandamusical

import bandamusical.models.*

class MusicianFactory {
    companion object {
        private var instance: MusicianFactory? = null
        fun getInstance(): MusicianFactory {
            if (instance == null) {
                instance = MusicianFactory()
            }
            return instance!!
        }
    }

    private fun getNombreRandom():String{
        return arrayOf("Pepe", "Juan", "Ana", "Pedro", "María").random()
    }

    fun getBandaRandom(porcentajes: IntArray = intArrayOf(20, 10, 10, 10, 15, 15, 15, 5)): Array<Musician>{
        require(porcentajes.size == 8){"Error: porcentajes ha de tener un tamaño de 8"}
        require(porcentajes.all { it > 0 }){"Error: ninguno valor de porcentajes puede sr menor o igual a 0"}
        require(porcentajes.sum() == 100){"Error: la suma de todos los valores de porcentajes a de ser igual a 100"}
        val values = arrayOf(
            porcentajes[0],
            porcentajes[0] + porcentajes[1],
            porcentajes[0] + porcentajes[1] + porcentajes[2],
            porcentajes[0] + porcentajes[1] + porcentajes[2] + porcentajes[3],
            porcentajes[0] + porcentajes[1] + porcentajes[2] + porcentajes[3] + porcentajes[4],
            porcentajes[0] + porcentajes[1] + porcentajes[2] + porcentajes[3] + porcentajes[4] + porcentajes[5],
            porcentajes[0] + porcentajes[1] + porcentajes[2] + porcentajes[3] + porcentajes[4] + porcentajes[5] + porcentajes[6]
        )

        // val banda = Array<Musician>(50){Cantante("", 2, TonoType.BAJO)}
        val banda: Array<Musician> by lazy {
            Array(50) { Cantante("", 2, TonoType.BAJO) }
        }

        for (i in banda.indices){
            val nombre = getNombreRandom()
            val experiencia = (0..40).random()
            banda[i] = when((0..100).random()){
                // Cantante
                in 0 until  values[0] -> Cantante(nombre, experiencia, TonoType.values().random())

                // Guitarrista
                in values[0] until values[1]-> Guitarrista(nombre, experiencia, GuitarraType.values().random())

                // Bajista
                in values[1] until values[2] -> Bajista(nombre, experiencia, (1..47).random())

                // Teclista
                in values[2] until values[3] -> Teclista(nombre, experiencia, (1..10).random())

                // Percusionista
                in values[3] until values[4] -> Percusionista(nombre, experiencia, PercussionType.values().random())

                // Trompetista
                in values[4] until values[5] -> Trompetista(nombre, experiencia)

                // CantanteGuitarrista
                in values[5] until values[6] -> CantanteGuitarrista(nombre, experiencia,
                    TonoType.values().random(), GuitarraType.values().random())

                // Multinstrimentalista
                else -> Multinstrumentista(nombre, experiencia, (1..47).random(),
                    PercussionType.values().random(), (1..5).random(),)
            }
        }
        return banda
    }
}