package factories

import interfaces.ICantante
import interfaces.IGuitarrista
import interfaces.IPercusionista
import interfaces.ITeclista
import models.*
import java.util.*

class MusicoFactory {
    val nombre = "Factory de Productos + ${UUID.randomUUID()}"
    companion object {
        private var instance: MusicoFactory? = null
        fun getInstance(): MusicoFactory {
            if (instance == null) {
                instance = MusicoFactory()
            }
            return instance!!
        }
    }
   private val listaDeNombres:Array<String> = arrayOf("Ana","DuditaMacUsuario","Jose","Pepe","JoseMaria","Monica","Emilio",
        "Mariano","Nemo","Pocholo","Nicolas","Gunter","Biörk","ZZTopmate","Perseo","Helios","Romulo","Ciceron",
        "JoseLuis","Sara","Lurdes","Julia","Leonor","Borja","Manuel","Teresa","Gorka","Ulises","Matilde","Alarico",
        "Ataúlfo","Sigérico","Walia","Teodorico","Turismundo","Eurico","Gesaleico","Amalarico","Theudis","Theudisclo",
        "Agila","Atanagildo","Liuva","Leovigildo","Recaredo","Witérico","Gundemaro","Sisebuto","Suíntila","Sisenando",
        "Khíntila","Tulga","Khindasvinto","Recesvinto","Wamba","Abul-Abbas","Adwaita","Alba","Alex","ANDi","April",
        "Argos","Arthur","Avispado","Ayumu","Balto","Barry","Becerrillo","Belisario","Benson","Blondi","Bonfire","Boo",
        "Brownie","Bubbles","Bucéfalo","Cassius","Chantek","Cher","Chonino","Chu-Lin","Cook","Puff","Crystal","Darley",
        "Dolly","Eddie","Fala","Félicette","Ferdinand","Flocke","Frida","Ducato","Greyfriars","Grumpy","Guillermo",
        "Gustave","Hachikō","Hanno","Harambe","Harriet","Incitatus","Jambo","Jenny","Marius","Orion","Owen","Pipper",
        "Sunny","Teddy","Titus")
    fun getCantante():Cantante{
        return Cantante(listaDeNombres.random(),ICantante.TonosCantante.values().random(),(1..10).random())
    }
    fun getGuitarrista():Guitarrista{
        return Guitarrista(listaDeNombres.random(),IGuitarrista.Tipoguitarra.values().random(),(1..10).random())
    }
    fun getBajista():Bajista{
        return  Bajista(listaDeNombres.random(),(4..6).random(),(1..10).random())
    }
    fun getTeclista():Teclista{
        return  Teclista(listaDeNombres.random(),ITeclista.TipoTeclado.values().random(),(1..10).random())
    }
    fun getPercusionista():Percusionista{
        return  Percusionista(listaDeNombres.random(),
                IPercusionista.TipoPercusion.values().random(),(1..10).random())
    }
    fun getTrompetista():Trompetista{
        return  Trompetista(listaDeNombres.random(),(80..140).random(),(1..10).random())
    }
    fun getCantanteGuitarrista():CantanteGuitarrista{
        return  CantanteGuitarrista(listaDeNombres.random(),ICantante.TonosCantante.values().random(),
        IGuitarrista.Tipoguitarra.values().random(),(3..15).random())
    }
    fun getMultinstrumental():Multinstrumental{
        return  Multinstrumental(listaDeNombres.random(),(4..6).random(),
            IGuitarrista.Tipoguitarra.values().random(),IPercusionista.TipoPercusion.values().random(),
            (5..15).random())
    }
    fun getBandaRandom(numeroMusicos:Int):Array<Musico>{
        val banda = Array(numeroMusicos) {Musico()}
        for(i in banda.indices){
            val azar = (1..100).random()
            when(azar){
                in  1..20-> banda[i]= getGuitarrista()
                in 21..30-> banda[i]= getBajista()
                in 31..40-> banda[i]= getTeclista()
                in 41..55-> banda[i]= getPercusionista()
                in 56..60-> banda[i]= getTrompetista()
                in 61..80-> banda[i]= getCantante()
                in 81..95-> banda[i]= getCantanteGuitarrista()
                in 96..100->banda[i]= getMultinstrumental()
            }
        }
        return  banda
    }
}