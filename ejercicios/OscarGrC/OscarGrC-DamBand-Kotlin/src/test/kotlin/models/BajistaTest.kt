package models

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class BajistaTest {

    @Test
    fun interpretarTest(){
        assertEquals(Bajista("Chris Squire",4,20).interpretar(),
            "Chris Squire esta tocando su bajo de 4 cuerdas.")
    }

}