package models

class Trompetista(nombre: String, apellidos: String, edad: Int, anosExperiencia: Int) : Musico(
    nombre, apellidos, edad,
    anosExperiencia,
) {
    override var instrumento: Instrumento = Instrumento.TROMPETA
    override var especialidad: Especialidad = Especialidad.TROMPETISTA

    override var salario: Int = (super.salario * 1.2).toInt()
    override var representacion: Int = 5

    val ins: Instrumento = Instrumento.TECLADO

    override fun interpretar() {
        tocarTrompeta()
    }

    override fun presentarse() {
        println("Hola soy $nombre, $apellidos, tengo $edad años y llevo $anosExperiencia años siendo músico. Mi instrumento ${Instrumento.TROMPETA}")
    }

    fun tocarTrompeta() {
        println("*Toca la trompeta*")
    }

    override fun toString(): String {
        return println("$salario").toString()
    }
}
