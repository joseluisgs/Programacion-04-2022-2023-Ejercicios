import factories.PlantillaFactory
import models.*
import java.lang.Exception

const val PERSONAS = 50

fun main() {

    var resp: String
    val respRegex = Regex("[1-8]")
    var plantilla: Array<Persona?> = PlantillaFactory.crearPlantilla()

    println("\n${colores.morado}SE HA CREADO UNA PLANTILLA ALEATORIA${colores.reset}")

    do {
        menu()

        print("\n${colores.verde}Seleccione una acción:${colores.reset} ")
        resp = readln()
        while (!respRegex.matches(resp)) {
            print("${colores.rojo}Seleccione una acción válida:${colores.reset} ")
            resp = readln()
        }

        when (resp) {
            "1" -> plantilla = PlantillaFactory.crearPlantilla()
            "2" -> imprimirPlantilla(plantilla)
            "3" -> menuTipos(plantilla)
            "4" -> menuOrdenar(plantilla)
            "5" -> menuNominas(plantilla)
            "6" -> despedirPersona(plantilla)
            "7" -> contratarPersona(plantilla)
        }

    }while (resp != "8")

    println("\nGracias, vuelva pronto")
}