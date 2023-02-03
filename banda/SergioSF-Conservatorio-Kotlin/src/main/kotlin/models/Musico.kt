package models

abstract class Musico(nombre: String, apellidos: String, edad: Int, val anosExperiencia: Int) :
    Persona(nombre, apellidos, edad) {

    abstract var instrumento: Instrumento
    abstract var especialidad: Especialidad
    open var salario: Int = 1500
    abstract var representacion: Int

    open fun presentarse() {
        println("Hola soy $nombre, $apellidos, tengo $edad años y llevo $anosExperiencia años siendo músico. Mi instrumento ${Instrumento.NINGUNO}")
    }

    abstract fun interpretar()
}

enum class Especialidad {
    BAJISTA, CANTANTE, GUITARRISTA, MULTINSTRUMENTISTA, PERCUSIONISTA, TECLISTA, TROMPETISTA
}

enum class Instrumento {
    NINGUNO, TROMPETA, VOZ, GUITARRA, BAJO, TECLADO, TAMBOR, VOZyGUITARRA, BAJO_TECLADOyTAMBOR
}