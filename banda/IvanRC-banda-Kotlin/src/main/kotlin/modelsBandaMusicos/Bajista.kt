package modelsBandaMusicos

class Bajista(nombre: String, salario: Double = 1500.00,añosExperiencia: Int, override var numeroCuerdas: Int):
Musico(nombre, salario, añosExperiencia), IBajista{}