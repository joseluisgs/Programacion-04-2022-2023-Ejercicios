package modelsBandaMusicos

class Percusionista(nombre: String, salario: Double = 1500.00, añosExperiencia: Int, override var tipoDePercusion: tipoPercusion):
Musico(nombre, salario, añosExperiencia), IPercusionista{
}