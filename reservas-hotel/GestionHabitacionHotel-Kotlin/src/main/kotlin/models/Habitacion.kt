package models

import Estado
import TipoDeCama

sealed class Habitacion(
    val numero: Int,
    val planta: Int,
    var estado: Estado,
    val precio: Double,


) {
    class Individual( numero: Int,
                      planta: Int,
                      estado: Estado,
                      precio: Double = 250.0,
                      val tamañoCama: Int
    ): Habitacion(numero, planta, estado, precio){
        override fun toString(): String {
            return "Habitacion Individual(numero=$numero, planta=$planta, tamañoCama=$tamañoCama, estado=$estado, precio=$precio)"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false
            if (!super.equals(other)) return false

            other as Individual

            if (numero != other.numero) return false
            if (planta != other.planta) return false
            if (estado != other.estado) return false
            if (precio != other.precio) return false
            if (tamañoCama != other.tamañoCama) return false

            return true
        }
    }

    class Doble(
        numero: Int,
        planta: Int,
        estado: Estado,
        precio: Double = 500.0,
        val tipoCama: TipoDeCama
    ): Habitacion(numero, planta, estado, precio){
        override fun toString(): String {
            return "Habitacion Doble(numero=$numero, planta=$planta, tipoCama=$tipoCama, estado=$estado, precio=$precio)"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as Doble

            if (numero != other.numero) return false
            if (planta != other.planta) return false
            if (estado != other.estado) return false
            if (precio != other.precio) return false
            if (tipoCama != other.tipoCama) return false

            return true
        }
    }

    class Familia(
        numero: Int,
        planta: Int,
        estado: Estado,
        precio: Double = 750.0,
        val numeroCamas: Int
    ): Habitacion(numero, planta, estado, precio){
        override fun toString(): String {
            return "Habitacion Familiar(numero=$numero, planta=$planta, numeroCamas=$numeroCamas, estado=$estado, precio=$precio)"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as Familia

            if (numero != other.numero) return false
            if (planta != other.planta) return false
            if (estado != other.estado) return false
            if (precio != other.precio) return false
            if (numeroCamas != other.numeroCamas) return false

            return true
        }
    }

    class Suite(
        numero: Int,
        planta: Int,
        estado: Estado,
        precio: Double = 1250.0,
        val numeroBaños: Int,
        val numeroSuite: Int = getNextNumeroSuite()
    ): Habitacion(numero, planta, estado, precio){

        private companion object{
            var contador = 1
            fun getNextNumeroSuite(): Int{
                return contador++
            }
        }

        override fun toString(): String {
            return "Habitacion Familiar(numero=$numero, planta=$planta, numeroBaños=$numeroBaños, numeroSuite=$numeroSuite, estado=$estado, precio=$precio)"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as Suite

            if (numero != other.numero) return false
            if (planta != other.planta) return false
            if (estado != other.estado) return false
            if (precio != other.precio) return false
            if (numeroBaños != other.numeroBaños) return false
            if (numeroSuite != other.numeroSuite) return false

            return true
        }
    }
}