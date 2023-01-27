package factoryMusicosBanda

import modelsBandaMusicos.*

class FactoryMusicos {

    companion object{
        private var instance: FactoryMusicos? = null
        fun getInstance(): FactoryMusicos?{
            if(instance==null) instance= FactoryMusicos()
            return instance
        }
    }

    /**
     * función que sirve para crear un musico con datos aleatorios
     * @return el musico creado con datos aleatorios
     */
    fun createMusicoRandom(): Musico? {
        var musico: Musico? = null
        val chance = (1..100).random()
        val nombres = arrayOf("Iván","Jia","Javier","Ramón","Belén","Cristobal","Rapado","Elkevin","Mayorca","Jorge","Nefer","Sebastian","Álvaro","Romeo")
        val añosExperiencia = (1..38).random()
        val capacidadPulmonar = (1..10).random()
        val tonos = arrayOf("agudo", "grave", "suave", "profundo")
        val cantidadTeclas = (1..24).random()
        val numeroCuerdas = (1..8).random()
        if(chance <= 5){
            musico = Trompetista(nombre = nombres.random(), añosExperiencia = añosExperiencia, capacidadPulmonal = capacidadPulmonar)
        }else{
            if(chance <= 25){
                musico = Cantante(nombre = nombres.random(), añosExperiencia = añosExperiencia, tono = tonos.random())
            }else{
                if(chance <= 45){
                    musico = Guitarrista(nombre = nombres.random(), añosExperiencia = añosExperiencia, tipoDeGuitarra = tipoGuitarra.values().random())
                }else{
                    if(chance <= 55){
                        musico = Bajista(nombre = nombres.random(), añosExperiencia = añosExperiencia, numeroCuerdas = numeroCuerdas)
                    }else{
                        if(chance <= 65){
                            musico = Teclista(nombre = nombres.random(), añosExperiencia = añosExperiencia, cantidadTeclas = cantidadTeclas)
                        }else{
                            if(chance <= 80){
                                musico = Percusionista(nombre = nombres.random(), añosExperiencia = añosExperiencia, tipoDePercusion = tipoPercusion.values().random())
                            }else{
                                if(chance <= 95){
                                    musico = CantanteGuitarrista(nombre = nombres.random(), añosExperiencia = añosExperiencia, tono = tonos.random(), tipoDeGuitarra = tipoGuitarra.values().random())
                                }else{
                                    musico = Multinstrumental(nombre = nombres.random(), añosExperiencia = añosExperiencia, numeroCuerdas = numeroCuerdas, cantidadTeclas = cantidadTeclas, tipoDePercusion = tipoPercusion.values().random())
                                }
                            }
                        }
                    }
                }
            }
        }
        return musico
    }
}