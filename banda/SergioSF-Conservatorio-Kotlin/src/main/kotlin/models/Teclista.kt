package models

class Teclista(nombre: String, apellidos: String, edad: Int, anosExperiencia: Int) : Musico(
    nombre, apellidos, edad,
    anosExperiencia
) {
    override var instrumento: Instrumento = Instrumento.TECLADO
    override var especialidad: Especialidad = Especialidad.TECLISTA

    override var salario: Int = (super.salario * 1.30).toInt()
    override var representacion: Int = 10

    override fun interpretar() {
        tocarTeclado()
    }

    override fun presentarse() {
        println("Hola soy $nombre, $apellidos, tengo $edad años y llevo $anosExperiencia años siendo músico. Mi instrumento ${Instrumento.TROMPETA}")
    }

    fun tocarTeclado() {
        println("")
    }

    override fun toString(): String {
        return println("$salario").toString()
    }
}
