import factories.*
import utils.*

// Ya que se debe dejar el main lo más limpio posible, eso he intentado
// Queda más simple
// Fun fact:
// Jose Luis dijo que el main podía estar escrito en dos o tres líneas y me lo tomé personalmente

/**
 * Recrea un taller para obtener informes sobre la plantilla
 * @author Sergio Misas Vírseda
 */
fun main() {
    val taller = FactoryTaller.createTaller()
    menu(taller)
}