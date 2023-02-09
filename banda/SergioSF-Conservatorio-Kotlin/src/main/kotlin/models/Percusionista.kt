package models

class Percusionista(nombre: String, apellidos: String, edad: Int, anosExperiencia: Int) : Musico(
    nombre, apellidos, edad,
    anosExperiencia
) {
    override var instrumento: Instrumento = Instrumento.TAMBOR
    override var especialidad: Especialidad = Especialidad.PERCUSIONISTA

    override var salario: Int = (super.salario * 1.35).toInt()
    override var representacion: Int = 15

    override fun interpretar() {
        tocarTambor()
    }

    override fun presentarse() {
        println("Hola soy $nombre, $apellidos, tengo $edad años y llevo $anosExperiencia años siendo músico. Mi instrumento ${Instrumento.TROMPETA}")
    }

    fun tocarTambor() {
        println("*toca el tambor*")
    }

    override fun toString(): String {
        return println("$salario").toString()
    }
}
