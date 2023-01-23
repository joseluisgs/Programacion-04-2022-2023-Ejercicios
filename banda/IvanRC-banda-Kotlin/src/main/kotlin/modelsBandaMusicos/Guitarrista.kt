package modelsBandaMusicos

class Guitarrista(nombre: String, salario: Double = 1500.00, añosExperiencia: Int, override var tipoDeGuitarra: tipoGuitarra):
    Musico(nombre, salario, añosExperiencia), IGuitarrista {}