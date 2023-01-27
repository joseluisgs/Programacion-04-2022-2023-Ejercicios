package utils
import factories.*
import models.Persona

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import models.*

class EjecucionOpcionesKtTest {

    val arrayTaller: Array<Persona> = arrayOf(
        Chapista("Pepe", 10, 1700.00, 8),
        Electricista("Santi", 20, 1800.00, 4),
        Trabajador("Sergio", 5, 1200.00, 6),
        JefeTaller("Manolo", 30, 2500.00, 3)
    )

    @Test
    fun busquedaTrabajadoresTest() {
        val arrayTrabajadores = arrayOf(1,3,1,1,1).toIntArray()
        val arrayBusqueda = busquedaTrabajadores(arrayTaller)
        for (i in arrayBusqueda.indices) {
            assertEquals(arrayTrabajadores[i], arrayBusqueda[i])
        }
    }

    @Test
    fun calcularTotalSueldosTest() {
        val sueldoTaller = 7200.00
        val arrayTrabajadores = arrayOf(1,3,1,1,1).toIntArray()
        assertEquals(sueldoTaller, calcularTotalSueldos(arrayTrabajadores))
    }

}