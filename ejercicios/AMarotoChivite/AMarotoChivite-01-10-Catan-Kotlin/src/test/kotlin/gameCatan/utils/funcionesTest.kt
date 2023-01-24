package gameCatan.utils

import gameCatan.enums.TypeOwner
import gameCatan.enums.TypeResource
import gameCatan.factories.MapFactory
import gameCatan.models.Box
import gameCatan.models.Computer
import gameCatan.models.Human
import gameCatan.models.Map
import gameCatan.utils.funciones.checkBoxEmptyComputer
import gameCatan.utils.funciones.checkBoxEmptyHuman
import gameCatan.utils.funciones.checkBoxesAssigment
import gameCatan.utils.funciones.checkColumns
import gameCatan.utils.funciones.checkNumber
import gameCatan.utils.funciones.checkRows
import gameCatan.utils.funciones.checkTwiceResources
import gameCatan.utils.funciones.checkWinner
import gameCatan.utils.funciones.humanDecision
import gameCatan.utils.funciones.randomDade
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

internal class funcionesTest {
    var mapTest: Map? = null

    @BeforeEach
    fun setUp() {
        mapTest = MapFactory.create()
    }

    @Test
    fun checkWinnerTest() {
        val playerTest0 = Human(19, 19, 19)
        val playerTest1 = Human(20, 20, 20)
        val playerTest2 = Human(21, 21, 21)
        val playerTest3 = Computer(20, 19, 19)
        val playerTest4 = Computer(20, 20, 19)
        val playerTest5 = Computer(19, 19, 19)
        Assertions.assertFalse(checkWinner(playerTest0))
        Assertions.assertTrue(checkWinner(playerTest1))
        Assertions.assertTrue(checkWinner(playerTest2))
        Assertions.assertFalse(checkWinner(playerTest3))
        Assertions.assertFalse(checkWinner(playerTest4))
        Assertions.assertFalse(checkWinner(playerTest5))
    }

    //TODO: esta se puede hacer???
    @Test
    fun accionPlayerTest() {
        val playerTest0 = Human(19, 19, 19)
        val playerTest1 = Computer(19, 19, 19)
    }

    @Test
    fun checkBoxesAssigmentTest() {
        Assertions.assertFalse(checkBoxesAssigment(mapTest))
        for (i in mapTest!!.matrix.indices) {
            for (j in mapTest!!.matrix[i].indices) {
                mapTest!!.matrix[i][j]!!.owner = TypeOwner.HUMAN
            }
        }
        Assertions.assertTrue(checkBoxesAssigment(mapTest))
    }

    @Test
    fun humanDecisionTest() {
        humanDecision(mapTest, "1", "1")
        humanDecision(mapTest, "2", "1")
        Assertions.assertEquals(mapTest!!.matrix[0][0]!!.owner, TypeOwner.HUMAN)
        Assertions.assertEquals(mapTest!!.matrix[1][0]!!.owner, TypeOwner.HUMAN)
    }

    @Test
    fun checkBoxEmptyComputerTest() {
        val userRowRespond = 1
        val userColumnRespond = 1
        Assertions.assertTrue(checkBoxEmptyComputer(mapTest, userRowRespond, userColumnRespond))
    }

    @Test
    fun checkBoxEmptyHumanTest() {
        val userRowRespond = "1"
        val userColumnRespond = "1"
        Assertions.assertTrue(checkBoxEmptyHuman(mapTest, userRowRespond, userColumnRespond))
    }

    @Test
    @Throws(InterruptedException::class)
    fun checkColumnsTest() {
        val userColumnRespond0 = "0"
        val userColumnRespond1 = "-1"
        val userColumnRespond2 = "1"
        val userColumnRespond3 = "4"
        val userColumnRespond4 = "5"
        Assertions.assertFalse(checkColumns(mapTest, userColumnRespond0))
        Assertions.assertFalse(checkColumns(mapTest, userColumnRespond1))
        Assertions.assertTrue(checkColumns(mapTest, userColumnRespond2))
        Assertions.assertTrue(checkColumns(mapTest, userColumnRespond3))
        Assertions.assertTrue(checkColumns(mapTest, userColumnRespond4))
    }

    @Test
    @Throws(InterruptedException::class)
    fun checkRowsTest() {
        val userRowRespond0 = "0"
        val userRowRespond1 = "-1"
        val userRowRespond2 = "1"
        val userRowRespond3 = "3"
        val userRowRespond4 = "4"
        Assertions.assertFalse(checkRows(mapTest, userRowRespond0))
        Assertions.assertFalse(checkRows(mapTest, userRowRespond1))
        Assertions.assertTrue(checkRows(mapTest, userRowRespond2))
        Assertions.assertTrue(checkRows(mapTest, userRowRespond3))
        Assertions.assertTrue(checkRows(mapTest, userRowRespond4))
    }

    @Test
    @Throws(InterruptedException::class)
    fun checkNumberTest() {
        val userRespond0 = "0"
        val userRespond1 = "1"
        val userRespond2 = "a"
        val userRespond3 = "."
        val userRespond4 = "?"
        Assertions.assertTrue(checkNumber(userRespond0))
        Assertions.assertTrue(checkNumber(userRespond1))
        Assertions.assertFalse(checkNumber(userRespond2))
        Assertions.assertFalse(checkNumber(userRespond3))
        Assertions.assertFalse(checkNumber(userRespond4))
    }

    @Test
    fun randomDadeTest() {
        val correctInt = intArrayOf(1, 2, 3, 4, 5, 6)
        val randomDadeTest = randomDade()
        var count = 0
        for (i in correctInt.indices) {
            if (correctInt[i] == randomDadeTest) {
                count++
            }
        }
        if (count != 1) {
            Assertions.fail<Any>()
        }
    }

    @Test
    fun checkTwiceResourcesTest() {
        val boxWood1 = Box(TypeResource.WOOD, TypeOwner.NONE, 1)
        val boxWood2 = Box(TypeResource.WOOD, TypeOwner.NONE, 1)
        val boxCoal1 = Box(TypeResource.COAL, TypeOwner.NONE, 1)
        val boxCoal2 = Box(TypeResource.COAL, TypeOwner.NONE, 1)
        val boxSeed1 = Box(TypeResource.SEED, TypeOwner.NONE, 1)
        val boxSeed2 = Box(TypeResource.SEED, TypeOwner.NONE, 1)
        val matrixTest = arrayOf(
            arrayOf<Box?>(boxWood1, boxWood2),
            arrayOf<Box?>(boxCoal1, boxCoal2),
            arrayOf<Box?>(boxSeed1, boxSeed2)
        )
        val mapNeTest = Map(3, 2, matrixTest)
        assertTrue(checkTwiceResources(matrixTest))
    }
}