package models

open class Cantante(nombre: String, apellidos: String, edad: Int, anosExperiencia: Int) : Musico(
    nombre, apellidos, edad, anosExperiencia
), ICantate {
    override var instrumento: Instrumento = Instrumento.VOZ
    override var especialidad: Especialidad = Especialidad.CANTANTE

    override var salario: Int = (super.salario * 1.4).toInt()
    override var representacion: Int = 20

    override fun interpretar() {
        cantar()
    }

    override fun presentarse() {
        println("Hola soy $nombre, $apellidos, tengo $edad años y llevo $anosExperiencia años siendo músico. Mi instrumento ${Instrumento.TROMPETA}")
    }

    override fun cantar() {
        println("*Canta*")
    }

    override fun toString(): String {
        return println("$salario").toString()
    }
}
