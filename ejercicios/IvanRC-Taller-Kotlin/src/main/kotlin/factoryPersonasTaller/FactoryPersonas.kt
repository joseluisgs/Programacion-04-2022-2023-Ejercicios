package factoryPersonasTaller

import modelsTaller.*

class FactoryPersonas {

    companion object{
        private var instance: FactoryPersonas? = null

        fun getInstance():FactoryPersonas?{
            if(instance == null){
                instance = FactoryPersonas()
            }
            return instance
        }
    }

    /**
     * función que sirve para generar una persona, jefe de taller, traajador, chapista o electricista cuyos datos son aleatorios
     * @return el objeto creado con datos aleatorios
     */
    fun createRandomPersona(): Persona?{
        var persona: Persona? = null

        val nombres = arrayOf("Iván","Jia","Javier","Ramón","Belén","Cristobal","Rapado","Elkevin","Mayorca","Jorge","Nefer","Sebastian","Álvaro","Romeo")
        val añosExepriencia = (1..64).random()
        val personasACargo = (1..100).random()
        val horasDiarias = (1..9).random()

        val chance = (1..100).random()
        if(chance <= 10){
            persona = JefeTaller(nombres.random(), añosExepriencia, personasACargo)
        }else{
            if(chance <= 60){
                persona = Trabajador(nombres.random(), añosExepriencia, horasDiarias)
            }else{
                if(chance <= 90){
                    persona = Chapista(nombres.random(), añosExepriencia, horasDiarias)
                }else{
                    persona = Electricista(nombres.random(), añosExepriencia, horasDiarias)
                }
            }
        }
        return persona
    }
}