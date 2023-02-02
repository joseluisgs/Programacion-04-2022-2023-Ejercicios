package models

class Multinstrumentista(nombre: String, apellidos: String, edad: Int, anosExperiencia: Int) : Musico(
    nombre, apellidos, edad,
    anosExperiencia
), IBajista, ITeclista, IPercusionista {

    override var instrumento: Instrumento = Instrumento.BAJO_TECLADOyTAMBOR
    override var especialidad: Especialidad = Especialidad.MULTINSTRUMENTISTA

    override var salario: Int = (super.salario * 1.35).toInt()
    override var representacion: Int = 15

    override fun interpretar() {
        tocarTambor()
        tocarBajo()
        tocarTambor()
    }

    override fun tocarBajo() {
        println("*toca el bajo entre además de otros instrumentos*")
    }

    override fun tocarTeclado() {
        println("*toca el teclado entre además de otros instrumentos")
    }

    override fun tocarTambor() {
        println("*toca el tambor entre además de otros instrumentos")
    }

}