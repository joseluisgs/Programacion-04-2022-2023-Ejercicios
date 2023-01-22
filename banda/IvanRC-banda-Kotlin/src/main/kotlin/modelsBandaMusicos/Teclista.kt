package modelsBandaMusicos

class Teclista(nombre: String, salario: Double = 1500.00, añosExperiencia: Int, override val cantidadTeclas: Int):
    Musico(nombre, salario, añosExperiencia), ITeclista {}