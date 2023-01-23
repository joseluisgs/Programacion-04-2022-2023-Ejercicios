package simulacionParking.factories

import simulacionParking.enums.TipoVehiculo
import simulacionParking.models.Vehiculo
import java.util.*

class VehiculoFactory {

    companion object {
        /**
         * Campo de clase para mantener el incremento
         */
        private var nextId: Int = 1

        /**
         * Cuando llamemos a la clase y su método único, aumentará nuestro ID
         *
         * @return nextId aumentado
         */
        fun getNextIdVehiculo(): String {
            return if (nextId < 10) {
                "0${nextId++}"
            } else {
                (nextId++).toString()
            }
        }

        /**
         * Creación de un objeto Vehiculo con ID auto incremental, y generación aleatoria de matrícula,
         * año de fábrica y el tipo de vehículo.
         *
         * @return vehiculo
         */
        fun create(): Vehiculo? {
            // Se pueden filtrar las generaciones aleatorias como precisemos, en este caso solo he filtrado en función
            // del annoFabrica, si es menos del 2015, no puede ser patinete al generar el tipo de Vehículo
            val matricula = generarMatricula()
            val annoFabrica = generarAnnoFabrica()
            if (annoFabrica != null) {
                val tipo = generarTipoVehiculo(annoFabrica)
                val id_AUTO: String = getNextIdVehiculo()
                return Vehiculo(id_AUTO, matricula, annoFabrica, tipo)
            } else {
                return null
            }
        }

        /**
         * Generación aleatoría del tipo de vehículo (camión, coche, moto, bici y patinete), en el caso de
         * patinete, solo será posible si su año de fábrica es del 2015 en adelante.
         *
         * @param annoFabrica para poder filtrar la creación de patinetes
         * @return TipoVehiculo, para poder asignarlo posteriormente a un vehiculo nuevo
         */
        fun generarTipoVehiculo(annoFabrica: String?): TipoVehiculo {
            while (true) {
                val r = Random()
                val num = r.nextInt(5)
                if (num == 0) {
                    return TipoVehiculo.CAMION
                }
                if (num == 1) {
                    return TipoVehiculo.COCHE
                }
                if (num == 2) {
                    return TipoVehiculo.MOTO
                }
                if (num == 3) {
                    return TipoVehiculo.BICI
                }
                if (num == 4 && annoFabrica!!.toInt() >= 2015) {
                    return TipoVehiculo.PATINETE
                }
            }
        }

        /**
         * Generación aleatoria del año de fábrica de un vehículo, siendo desde 1990 hasta 2019 (incluídos)
         *
         * @return almacenAnnos[num]
         */
        fun generarAnnoFabrica(): String? {
            var indiceAlmacen = 0
            // Almacén desde el 1990 hasta el 2019 = 29 años
            val almacenAnnos = arrayOfNulls<String>(30)
            for (i in 0..9) {
                val anno = "199$i"
                almacenAnnos[indiceAlmacen] = anno
                indiceAlmacen++
            }
            for (i in 0..9) {
                val anno = "200$i"
                almacenAnnos[indiceAlmacen] = anno
                indiceAlmacen++
            }
            for (i in 0..9) {
                val anno = "201$i"
                almacenAnnos[indiceAlmacen] = anno
                indiceAlmacen++
            }
            val r = Random()
            val num = r.nextInt(30)
            return almacenAnnos[num]
        }

        /**
         * Generación aleatoria de una matrícula que corresponda con 5 letras, 1 guión y 4 números, ej: (ABCDE-1234)
         *
         * @return matriculaFinal
         */
        fun generarMatricula(): String {
            val alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
            val numeros = "1234567890"
            val r = Random()
            val matriculaFinal = StringBuilder()
            for (i in 0..4) {
                val sorteoAlfabeto = r.nextInt(26)
                matriculaFinal.append(alfabeto[sorteoAlfabeto])
            }
            matriculaFinal.append("-")
            for (i in 0..3) {
                val sorteoNumeros = r.nextInt(10)
                matriculaFinal.append(numeros[sorteoNumeros])
            }
            return matriculaFinal.toString()
        }

        /**
         * Generación aleatoria de los vehículos que tenga un conductor, entre 1 y 4 vehículos
         *
         * @return vehiculosDeConductor
         */
        fun generacionAlmacenVehiculos(): Array<Vehiculo?> {
            val r = Random()
            val num = r.nextInt(3) + 1
            val vehiculosDeConductor = arrayOfNulls<Vehiculo>(num)
            for (i in 0 until num) {
                vehiculosDeConductor[i] = create()
            }
            return vehiculosDeConductor
        }
    }
}