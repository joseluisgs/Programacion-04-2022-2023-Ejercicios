package models

class Bajista(nombre: String, apellidos: String, edad: Int, anosExperiencia: Int) : Musico(
    nombre, apellidos, edad,
    anosExperiencia
), IBajista {
    override var instrumento: Instrumento = Instrumento.BAJO
    override var especialidad: Especialidad = Especialidad.BAJISTA

    override var salario: Int = (super.salario * 1.30).toInt()
    override var representacion: Int = 10

    override fun interpretar() {
        tocarBajo()
    }

    override fun presentarse() {
        println("Hola soy $nombre, $apellidos, tengo $edad años y llevo $anosExperiencia años siendo músico. Mi instrumento ${Instrumento.TROMPETA}")
    }

    override fun tocarBajo() {
        println("*toca el bajo")
    }

    override fun toString(): String {
        return println("$salario").toString()
    }
}
