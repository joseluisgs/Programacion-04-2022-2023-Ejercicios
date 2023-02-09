package models

class Cantante_que_toca_la_guitarra(nombre: String, apellidos: String, edad: Int, anosExperiencia: Int) : Cantante(
    nombre, apellidos, edad, anosExperiencia
), IGuitarrista {
    override var instrumento: Instrumento = Instrumento.VOZyGUITARRA
    override var especialidad: Especialidad = Especialidad.MULTINSTRUMENTISTA

    override var salario: Int = (super.salario * 1.33).toInt()
    override var representacion: Int = 20

    override fun tocarGuitarra() {
        println("Toca la guitarra")
    }

    override fun cantar() {
        println("*Canta con  la guitarra*")
    }

    override fun interpretar() {
        cantar()
        tocarGuitarra()
    }

}