package simulacionBandaMusica.utils

import org.junit.jupiter.api.Test
import simulacionBandaMusica.factories.*
import simulacionBandaMusica.models.Musico
import simulacionBandaMusica.utils.funcionesMenu.calcularMantenimientoBanda
import kotlin.test.assertEquals

internal class funcionesMenuTest {
    @Test
    fun calcularMantenimientoBandaTest() {
        val banda = arrayOfNulls<Musico>(8)
        val almacenMusicos = arrayOf(
            BajistaFactory.create(), CantanteFactory.create(),
            CantanteProFactory.create(), GuitarristaFactory.create(),
            MultiFactory.create(), PercusionistaFactory.create(),
            TeclistaFactory.create(), TrompetistaFactory.create()
        )

        for (i in 0 until banda.size) {
            banda[i] = almacenMusicos[i]
        }
        
        assertEquals(16875, calcularMantenimientoBanda(banda))
    }
}