package SalaDeCineTests

import Factories.ButacaFactory
import Factories.PeliculaFactory
import Factories.SalaDeCineFactory
import ModelsSalaDeCine.*
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class salaCineTests {

    var salaCine = SalaDeCineFactory.getInstance()!!.crearSalaDeCine("s",5,5, 6,PeliculaFactory.getInstance()!!.crearPelicula("s", 1960, "s", "s"))

    @BeforeEach
    fun setup(){
        for(i in 0 until salaCine.butacas.size){
            for(j in 0 until salaCine.butacas[i].size){
                salaCine.butacas[i][j]!!.estado = "libre"
            }
        }
    }

    @Test
    fun crearPeliculaTest(){
        val nuevaPelicula = PeliculaFactory.getInstance()!!.crearPelicula("s", 1960, "s", "s")
        assertEquals(pelicula("s",1960,"s","s"), nuevaPelicula)
    }

    @Test
    fun tituloValidoTest(){
        val titulo = "Los tres Mosqueteros"
        assertTrue(tituloValido(titulo))
    }

    @Test
    fun tituloNoValidoTest(){
        val titulo1 = null
        val mensaje1: IllegalArgumentException = Assertions.assertThrows(IllegalArgumentException::class.java) { tituloValido(titulo1) }
        val titulo2 = ""
        val mensaje2: IllegalArgumentException = Assertions.assertThrows(IllegalArgumentException::class.java) { tituloValido(titulo2) }
        assertAll(
            {assertEquals("${Colores.RED.color}El título no puede ser nulo, vuelve a probar:", mensaje1.message)},
            {assertEquals("${Colores.RED.color}El título de la peli no puede estar vacio, vuelve a probar:", mensaje2.message)}
        )
    }

    @Test
    fun añoPublicacionValidoTest(){
        val añoPublicacion1 = "2022"
        val añoPublicacion2 = "1950"
        assertAll(
            { assertTrue(añoPublicacionValido(añoPublicacion1)) },
            { assertTrue(añoPublicacionValido(añoPublicacion2)) }
        )
    }

    @Test
    fun añoPublicacionNoValidoTest(){
        val añoPublicacion1 = null
        val mensaje1: IllegalArgumentException = Assertions.assertThrows(IllegalArgumentException::class.java) { añoPublicacionValido(añoPublicacion1) }
        val añoPublicacion2 = "-1"
        val mensaje2: IllegalArgumentException = Assertions.assertThrows(IllegalArgumentException::class.java) { añoPublicacionValido(añoPublicacion2) }
        val añoPublicacion3 = "1949"
        val mensaje3: IllegalArgumentException = Assertions.assertThrows(IllegalArgumentException::class.java) { añoPublicacionValido(añoPublicacion3) }
        val añoPublicacion4 = "2024"
        val mensaje4: IllegalArgumentException = Assertions.assertThrows(IllegalArgumentException::class.java) { añoPublicacionValido(añoPublicacion4) }
        val añoPublicacion5 = "hola"
        val mensaje5: IllegalArgumentException = Assertions.assertThrows(IllegalArgumentException::class.java) { añoPublicacionValido(añoPublicacion5) }
        assertAll(
            {assertEquals("${Colores.RED.color}El año de publicación no puede ser nulo, vuelve a probar:", mensaje1.message)},
            {assertEquals("${Colores.RED.color}El año de publicación no puede ser negativo, vuelve a probar:" , mensaje2.message)},
            {assertEquals("${Colores.RED.color}El año de publicación de la peli debe ser entre 1950 y 2023, vuelve a probar:", mensaje3.message)},
            {assertEquals("${Colores.RED.color}El año de publicación de la peli debe ser entre 1950 y 2023, vuelve a probar:", mensaje4.message)},
            {assertEquals("${Colores.RED.color}El año de publicación introducido no es válido, vuelve a probar:", mensaje5.message)}
        )
    }

    @Test
    fun numeroButacasVipValidoTest(){
        val fila = 5
        val columna = 5
        val numeroButacasVip = "5"
        assertTrue(numeroButacasVipValido(numeroButacasVip, fila, columna))
    }

    @Test
    fun numeroButacasVipNoValidoTest(){
        val fila = 5
        val columna = 5
        val numeroButacasVip1 = null
        val mensaje1: IllegalArgumentException = Assertions.assertThrows(IllegalArgumentException::class.java) { numeroButacasVipValido(numeroButacasVip1, fila, columna) }
        val numeroButacasVip2 = "-1"
        val mensaje2: IllegalArgumentException = Assertions.assertThrows(IllegalArgumentException::class.java) { numeroButacasVipValido(numeroButacasVip2, fila, columna) }
        val numeroButacasVip3 = "1949"
        val mensaje3: IllegalArgumentException = Assertions.assertThrows(IllegalArgumentException::class.java) { numeroButacasVipValido(numeroButacasVip3, fila, columna) }
        val numeroButacasVip4 = "hola"
        val mensaje4: IllegalArgumentException = Assertions.assertThrows(IllegalArgumentException::class.java) { numeroButacasVipValido(numeroButacasVip4, fila, columna) }
        assertAll(
            {assertEquals("${Colores.RED.color}El número de butacas vip no puede ser nulo, vuelve a probar:", mensaje1.message)},
            {assertEquals("${Colores.RED.color}El número de butacas vip introducido no es válida, vuelve a probar:" , mensaje2.message)},
            {assertEquals("${Colores.RED.color}El número de butacas vip no puede ser mayor que el número de butacas totales, que es: ${fila*columna}, vuelve a probar:", mensaje3.message)},
            {assertEquals("${Colores.RED.color}El número de butacas vip introducido no es válida, vuelve a probar:", mensaje4.message)}
        )
    }

    @Test
    fun directorValidoTest(){
        val director = "Jorge"
        assertTrue(directorValido(director))
    }

    @Test
    fun directorNoValidoTest(){
        val director1 = null
        val mensaje1: IllegalArgumentException = Assertions.assertThrows(IllegalArgumentException::class.java) { directorValido(director1) }
        val director2 = ""
        val mensaje2: IllegalArgumentException = Assertions.assertThrows(IllegalArgumentException::class.java) { directorValido(director2) }
        assertAll(
            {assertEquals("${Colores.RED.color}El director no puede ser nulo, vuelve a probar:", mensaje1.message)},
            {assertEquals("${Colores.RED.color}El director de la peli no puede estar vacio, vuelve a probar:", mensaje2.message)}
        )
    }

    @Test
    fun generoValidoTest(){
        val genero = "Ciencia Ficción"
        assertTrue(generoValido(genero))
    }

    @Test
    fun generoNoValidoTest(){
        val genero1 = null
        val mensaje1: IllegalArgumentException = Assertions.assertThrows(IllegalArgumentException::class.java) { generoValido(genero1) }
        val genero2 = ""
        val mensaje2: IllegalArgumentException = Assertions.assertThrows(IllegalArgumentException::class.java) { generoValido(genero2) }
        assertAll(
            {assertEquals("${Colores.RED.color}El género no puede ser nulo, vuelve a probar:", mensaje1.message)},
            {assertEquals("${Colores.RED.color}El género de la peli no puede estar vacio, vuelve a probar:", mensaje2.message)}
        )
    }

    @Test
    fun crearButacaTest(){
        val nuevaButaca = ButacaFactory.getInstance()!!.crearButaca("A1", "libre", TipoButaca.NORMAL)
        assertEquals(butaca("A1","libre", TipoButaca.NORMAL), nuevaButaca)
    }

    @Test
    fun crearSalaDeCineTest(){
        val nuevaSalaDeCine = SalaDeCineFactory.getInstance()!!.crearSalaDeCine("s",5,5, 6,PeliculaFactory.getInstance()!!.crearPelicula("s", 1960, "s", "s"))
        assertEquals(salaDeCine("s",5,5, 6,PeliculaFactory.getInstance()!!.crearPelicula("s", 1960, "s", "s")), nuevaSalaDeCine)
    }

    @Test
    fun filaColumnaValidaTest(){
        val filaColumna1 = "1"
        val filaColumna2 = "8"
        assertAll(
            { assertTrue(filaColumnaValida(filaColumna1)) },
            { assertTrue(filaColumnaValida(filaColumna2)) }
        )
    }

    @Test
    fun filaColumnaNoValidaTest(){
        val filaColumna1 = null
        val mensaje1: IllegalArgumentException = Assertions.assertThrows(IllegalArgumentException::class.java) { filaColumnaValida(filaColumna1) }
        val filaColumna2 = "0"
        val mensaje2: IllegalArgumentException = Assertions.assertThrows(IllegalArgumentException::class.java) { filaColumnaValida(filaColumna2) }
        val filaColumna3 = "27"
        val mensaje3: IllegalArgumentException = Assertions.assertThrows(IllegalArgumentException::class.java) { filaColumnaValida(filaColumna3) }
        val filaColumna4 = "hola"
        val mensaje4: IllegalArgumentException = Assertions.assertThrows(IllegalArgumentException::class.java) { filaColumnaValida(filaColumna4) }
        assertAll(
            {assertEquals("${Colores.RED.color}La fila/columna no puede ser nulo, vuelve a probar:", mensaje1.message)},
            {assertEquals("${Colores.RED.color}La fila/columna no puede ser menor que 1, vuelve a probar:" , mensaje2.message)},
            {assertEquals("${Colores.RED.color}La fila/columna no puede sobrepasar el tamaño 26, vuelve a probar:", mensaje3.message)},
            {assertEquals("${Colores.RED.color}La fila/columna introducida no es válida, vuelve a probar:", mensaje4.message)}
        )
    }

    @Test
    fun nombreValidoTest(){
        val nombre = "Ciencia Ficción"
        assertTrue(nombreValido(nombre))
    }

    @Test
    fun nombreNoValidoTest(){
        val nombre1 = null
        val mensaje1: IllegalArgumentException = Assertions.assertThrows(IllegalArgumentException::class.java) { nombreValido(nombre1) }
        val nombre2 = ""
        val mensaje2: IllegalArgumentException = Assertions.assertThrows(IllegalArgumentException::class.java) { nombreValido(nombre2) }
        assertAll(
            {assertEquals("${Colores.RED.color}El nombre no puede ser nulo, vuelve a probar:", mensaje1.message)},
            {assertEquals("${Colores.RED.color}El nombre no puede estar vacio, vuelve a probar:", mensaje2.message)}
        )
    }

    @Test
    fun butacaValidaTest(){
        val butaca1 = "A1"
        val butaca2 = "stop"
        assertAll(
            {assertTrue(butacaValida(butaca1))},
            {assertTrue(butacaValida(butaca2))}
        )
    }

    @Test
    fun butacaNoValidaTest(){
        val butaca1 = null
        val mensaje1: IllegalArgumentException = Assertions.assertThrows(IllegalArgumentException::class.java) { butacaValida(butaca1) }
        val butaca2 = ""
        val mensaje2: IllegalArgumentException = Assertions.assertThrows(IllegalArgumentException::class.java) { butacaValida(butaca2) }
        val butaca3 = "5B"
        val mensaje3: IllegalArgumentException = Assertions.assertThrows(IllegalArgumentException::class.java) { butacaValida(butaca3) }
        assertAll(
            {assertEquals("${Colores.RED.color}El mensaje no puede ser nulo, vuelve a probar:", mensaje1.message)},
            {assertEquals("${Colores.RED.color}El mensaje no puede estar vacio, vuelve a probar:", mensaje2.message)},
            {assertEquals("${Colores.RED.color}EL mensaje introducido no es válido, vuelve a probar:", mensaje3.message)}
        )
    }

    @Test
    fun opcionValidaTest(){
        val opcion = "4"
        assertTrue(opcionValida(opcion))
    }

    @Test
    fun opcionNoValidaTest(){
        val opcion1 = null
        val mensaje1: IllegalArgumentException = Assertions.assertThrows(IllegalArgumentException::class.java) { opcionValida(opcion1) }
        val opcion2 = "-1"
        val mensaje2: IllegalArgumentException = Assertions.assertThrows(IllegalArgumentException::class.java) { opcionValida(opcion2) }
        val opcion3 = "7"
        val mensaje3: IllegalArgumentException = Assertions.assertThrows(IllegalArgumentException::class.java) { opcionValida(opcion3) }
        val opcion4 = "hola"
        val mensaje4: IllegalArgumentException = Assertions.assertThrows(IllegalArgumentException::class.java) { opcionValida(opcion4) }
        assertAll(
            {assertEquals("${Colores.RED.color}La opción no puede ser nula, vuelve a probar:", mensaje1.message)},
            {assertEquals("${Colores.RED.color}No has elegido una de las opciones posibles, vuelve a probar:" , mensaje2.message)},
            {assertEquals("${Colores.RED.color}No has elegido una de las opciones posibles, vuelve a probar:", mensaje3.message)},
            {assertEquals("${Colores.RED.color}La opción introducida no es válida, vuelve a probar:", mensaje4.message)}
        )
    }

    @Test
    fun opcionIntroducirDatosValidaTest(){
        val opcion = "1"
        assertTrue(opcionDeIntroducirDatosValida(opcion))
    }

    @Test
    fun opcionIntroducirDatosNoValidaTest(){
        val opcion1 = null
        val mensaje1: IllegalArgumentException = Assertions.assertThrows(IllegalArgumentException::class.java) { opcionDeIntroducirDatosValida(opcion1) }
        val opcion2 = "0"
        val mensaje2: IllegalArgumentException = Assertions.assertThrows(IllegalArgumentException::class.java) { opcionDeIntroducirDatosValida(opcion2) }
        val opcion3 = "3"
        val mensaje3: IllegalArgumentException = Assertions.assertThrows(IllegalArgumentException::class.java) { opcionDeIntroducirDatosValida(opcion3) }
        val opcion4 = "hola"
        val mensaje4: IllegalArgumentException = Assertions.assertThrows(IllegalArgumentException::class.java) { opcionDeIntroducirDatosValida(opcion4) }
        assertAll(
            {assertEquals("${Colores.RED.color}La opción no puede ser nula, vuelve a probar:", mensaje1.message)},
            {assertEquals("${Colores.RED.color}No has elegido una de las opciones posibles, vuelve a probar:" , mensaje2.message)},
            {assertEquals("${Colores.RED.color}No has elegido una de las opciones posibles, vuelve a probar:", mensaje3.message)},
            {assertEquals("${Colores.RED.color}La opción introducida no es válida, vuelve a probar:", mensaje4.message)}
        )
    }

    @Test
    fun hallarIdentificadorButacaTest(){
        val fila = 1
        val columna = 1
        val identificadorButaca = "B2"
        assertEquals(identificadorButaca, salaCine.hallarIdentificadorButaca(fila, columna))
    }

    @Test
    fun comprarEntradaTest(){
        val posicion = Pair(0,0)
        assertEquals("comprado", salaCine.comprar(posicion)!!.estado)
    }

    @Test
    fun reservarEntradaTest(){
        val posicion = Pair(0,0)
        assertEquals("reservado", salaCine.reservar(posicion)!!.estado)
    }

    @Test
    fun anularEntradaTest(){
        val posicion = Pair(0,0)
        assertEquals("libre", salaCine.anular(posicion)!!.estado)
    }

    @Test
    fun informeDeLaSalaDeCineTest(){
        val mensaje = println(salaCine.informeDeLaSalaDeCine())
        assertEquals(mensaje, salaCine.informeDeLaSalaDeCine())
    }

    @Test
    fun calcularDineroEnCajaTest(){
        salaCine.butacas[0][0]!!.estado = "comprado"
        salaCine.butacas[0][0]!!.tipoButaca = TipoButaca.NORMAL
        salaCine.butacas[0][1]!!.estado = "comprado"
        salaCine.butacas[0][1]!!.tipoButaca = TipoButaca.VIP
        val dinero = TipoButaca.NORMAL.valor + TipoButaca.VIP.valor
        assertEquals(dinero, salaCine.calcularDineroEnCaja())
    }

    @Test
    fun contarNumeroDeButacasPorTipoTest(){
        salaCine.butacas[0][0]!!.estado = "comprado"
        salaCine.butacas[0][1]!!.estado = "comprado"
        salaCine.butacas[0][2]!!.estado = "comprado"
        salaCine.butacas[0][3]!!.estado = "comprado"
        salaCine.butacas[0][4]!!.estado = "comprado"
        salaCine.butacas[1][0]!!.estado = "reservado"
        salaCine.butacas[1][1]!!.estado = "reservado"
        salaCine.butacas[1][2]!!.estado = "reservado"
        salaCine.butacas[1][3]!!.estado = "reservado"
        salaCine.butacas[1][4]!!.estado = "reservado"
        val numeroTipoButacas = Triple(15, 5, 5)
        assertEquals(numeroTipoButacas, salaCine.contarNumeroDeButacasPorTipo())
    }

    @Test
    fun representarButacasTest(){
        val mensaje = println(salaCine.representarButacas())
        assertEquals(mensaje, salaCine.representarButacas())
    }

    @Test
    fun buscarButacaPorIdentificadorTest(){
        val identificador1 = "A1"
        val posicion1 = Pair(0,0)
        val identificador2 = "Z27"
        val posicion2 = Pair(-1,-1)
        assertAll(
            {assertEquals(posicion1, salaCine.buscarButacaPorIndentificador(identificador1))},
            {assertEquals(posicion2, salaCine.buscarButacaPorIndentificador(identificador2))}
        )
    }
}