package Factories
import models.*
import java.util.*
class PersonaFactory private constructor() {
    val factoryID = "Factory de Productos + ${UUID.randomUUID()}"
    val listaDeNombres:Array<String> = arrayOf("Ana","DuditaMacUsuario","Jose","Pepe","JoseMaria","Monica","Emilio",
        "Mariano","Nemo","Pocholo","Nicolas","Gunter","Biörk","ZZTopmate","Perseo","Helios","Romulo","Ciceron",
        "JoseLuis","Sara","Lurdes","Julia","Leonor","Borja","Manuel","Teresa","Gorka","Ulises","Matilde","Alarico",
        "Ataúlfo","Sigérico","Walia","Teodorico","Turismundo","Eurico","Gesaleico","Amalarico","Theudis","Theudisclo",
        "Agila","Atanagildo","Liuva","Leovigildo","Recaredo","Witérico","Gundemaro","Sisebuto","Suíntila","Sisenando",
        "Khíntila","Tulga","Khindasvinto","Recesvinto","Wamba")

    companion object {
        // Patrón Singleton
        // donde almaceno la instancia única
        private var instance: PersonaFactory? = null
        fun getInstance(): PersonaFactory {
            if (instance == null) {
                instance = PersonaFactory()
            }
            return instance!!
        }
    }
  fun getJefeTaller(nombre:String):JefeTaller{
      var salida = JefeTaller(nombre)

      salida.nombre=listaDeNombres.random()
      salida.experiencia= 10
      salida.empresa= nombre
      return salida
  }
    fun getTrabajador(nombre:String):Trabajador{
        var salida = Trabajador(nombre)

        salida.nombre=listaDeNombres.random()
        salida.empresa= nombre
        salida.experiencia= 2
        return salida
    }
    fun getChapista(nombre:String):Chapista{
        var salida = Chapista()

        salida.nombre=listaDeNombres.random()
        salida.experiencia= 5
        return salida
    }
    fun getElectricista(nombre:String):Electricista{
        var salida = Electricista()
        salida.nombre=listaDeNombres.random()
        salida.experiencia= 5
        salida.empresa= nombre
        return salida
    }
        }

