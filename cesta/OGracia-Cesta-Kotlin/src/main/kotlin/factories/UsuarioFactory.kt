package factories

import models.Usuario
import java.util.*

class UsuarioFactory private constructor() {
    val nombre = "Factory de Usuarios+ ${UUID.randomUUID()}"
    companion object {
        // Patrón Singleton
        // donde almaceno la instancia única
        private var instance: UsuarioFactory? = null
        fun getInstance(): UsuarioFactory {
            if (instance == null) {
                instance = UsuarioFactory()
            }
            return instance!!
        }
    }

    fun createUsuarioRandom(): Usuario {
        val listaDeNombres:Array<String> = arrayOf("Ana","DuditaMacUsuario","Jose","Pepe","JoseMaria","Monica","Emilio",
            "Mariano","Nemo","Pocholo","Nicolas","Gunter","Biörk","ZZTopmate","Perseo","Helios","Romulo","Ciceron",
            "JoseLuis","Sara","Lurdes","Julia","Leonor","Borja","Manuel","Teresa","Gorka","Ulises","Matilde","Alarico",
        "Ataúlfo","Sigérico","Walia","Teodorico","Turismundo","Eurico","Gesaleico","Amalarico","Theudis","Theudisclo",
        "Agila","Atanagildo","Liuva","Leovigildo","Recaredo","Witérico","Gundemaro","Sisebuto","Suíntila","Sisenando",
        "Khíntila","Tulga","Khindasvinto","Recesvinto","Wamba")
        val listaDeDnis:Array<String> = arrayOf("65566902C","74394797D","70264223M","43626013G","76377757R","09753917P",
            "68529245D","05527392D","07879574G","81366220V","07371691F","27351239F","94243502J","01542990N","28295572Y",
            "87048347V","56058973S","86901580J")
       val password:String = "Wololo"
         val correo:Array<String> = arrayOf("Wololo@gmail.com","W.ololo@gmail.com","Wo.lolo@gmail.com",
             "W.o.lolo@gmail.com","Wol.olo@gmail.com","W.ol.olo@gmail.com","Wo.l.olo@gmail.com",
             "D.ivi.d.a.v.a.d.a@gmail.com","Di.vi.d.a.v.a.d.a@gmail.com","D.i.vi.d.a.v.a.d.a@gmail.com",
             "Div.i.d.a.v.a.d.a@gmail.com","D.iv.i.d.a.v.a.d.a@gmail.com","Di.v.i.d.a.v.a.d.a@gmail.com",
             "D.i.v.i.d.a.v.a.d.a@gmail.com")
        return Usuario((listaDeNombres.random()+(1 until 100).random().toString())
            ,password,correo.random(),listaDeDnis.random())
    }

    override fun toString(): String {
        return "UsuarioFactory(nombre='$nombre')"
    }
}
