package modelsBandaMusicos

abstract class Persona(val nombre: String) {
    open fun respirar() {
        println("modelsBandaMusicos.Persona: Mi nombre es $nombre y estoy respirando...")
    }
}