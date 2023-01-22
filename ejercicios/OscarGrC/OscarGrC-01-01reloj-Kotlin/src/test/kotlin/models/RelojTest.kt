package models

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.time.LocalTime

internal class RelojTest {

    @Test
    fun getHora() {
        val relojTest= Reloj()
        val reloj = LocalTime.now()
        val hora = reloj.hour.toString()
        assertEquals(relojTest.hora,hora)
    }

    @Test
    fun setHora() {
        val relojTest= Reloj()
        relojTest.hora = "12"
        assertEquals(relojTest.hora,"12")
    }

    @Test
    fun getMinutos() {
        val relojTest= Reloj()
        val reloj = LocalTime.now()
        val minutos = reloj.minute.toString()
        assertEquals(relojTest.minutos,minutos)
    }

    @Test
    fun setMinutos() {
        val relojTest= Reloj()
        relojTest.minutos = "12"
        assertEquals(relojTest.minutos,"12")
    }

    @Test
    fun getSegundos() {
        val relojTest= Reloj()
        val reloj = LocalTime.now()
        val segundos = reloj.second.toString()
        assertEquals(relojTest.segundos,segundos)
    }

    @Test
    fun setSegundos() {
        val relojTest= Reloj()
        relojTest.segundos = "12"
        assertEquals(relojTest.segundos,"12")
    }

    @Test
    fun getHora24() {
        val relojTest= Reloj()
        assertEquals(relojTest.hora24,"17:14.39")
    }

    @Test
    fun setHora24() {
        val relojTest= Reloj()
        relojTest.hora24 = "17:14.39"
        assertEquals(relojTest.hora24,"17:14.39")
    }

    @Test
    fun getHora12() {
        val relojTest= Reloj()
        assertEquals(relojTest.hora12,"05:19.29 PM")
    }

    @Test
    fun setHora12() {
        val relojTest= Reloj()
        relojTest.hora12 = "05:19.29 PM"
        assertEquals(relojTest.hora12,"05:19.29 PM")
    }

    @Test
    fun getFechaAmericana() {
        val relojTest= Reloj()
        assertEquals(relojTest.fechaAmericana,"2023-01-22")
    }

    @Test
    fun setFechaAmericana() {
        val relojTest= Reloj()
        relojTest.fechaAmericana="2023-02-22"
        assertEquals(relojTest.fechaAmericana,"2023-02-22")
    }

    @Test
    fun getFechaEuropea() {
        val relojTest= Reloj()
        assertEquals(relojTest.fechaEuropea,"22-01-2023")
    }

    @Test
    fun setFechaEuropea() {
        val relojTest= Reloj()
        relojTest.fechaEuropea="22-02-2023"
        assertEquals(relojTest.fechaEuropea,"22-02-2023")
    }


}