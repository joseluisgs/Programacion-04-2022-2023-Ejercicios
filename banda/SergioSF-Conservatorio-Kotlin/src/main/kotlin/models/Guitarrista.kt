package models

class Guitarrista(nombre: String, apellidos: String, edad: Int, anosExperiencia: Int) : Musico(
    nombre, apellidos, edad,
    anosExperiencia
), IGuitarrista {
    override var instrumento: Instrumento = Instrumento.GUITARRA
    override var especialidad: Especialidad = Especialidad.GUITARRISTA

    override var salario: Int = (super.salario * 1.33).toInt()
    override var representacion: Int = 20

    override fun interpretar() {
        tocarGuitarra()
    }

    override fun presentarse() {
        println("Hola soy $nombre, $apellidos, tengo $edad años y llevo $anosExperiencia años siendo músico. Mi instrumento ${Instrumento.TROMPETA}")
    }

    override fun tocarGuitarra() {
        println("Toca la guitarra")
    }

    override fun toString(): String {
        return println("$salario").toString()
    }
}
