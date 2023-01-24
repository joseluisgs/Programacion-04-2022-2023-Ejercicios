package gameCatan.utils;

import gameCatan.enums.TypeOwner;
import gameCatan.enums.TypeResource;
import gameCatan.factories.MapFactory;
import gameCatan.models.Box;
import gameCatan.models.Computer;
import gameCatan.models.Human;
import gameCatan.models.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static gameCatan.utils.funciones.*;
import static org.junit.jupiter.api.Assertions.*;

class funcionesTest {

    Map mapTest;

    @BeforeEach
    public void setUp() {
        mapTest = MapFactory.create();
    }

    @Test
    void checkWinnerTest() {
        Human playerTest0 = new Human(19, 19, 19);
        Human playerTest1 = new Human(20, 20, 20);
        Human playerTest2 = new Human(21, 21, 21);
        Computer playerTest3 = new Computer(20, 19, 19);
        Computer playerTest4 = new Computer(20, 20, 19);
        Computer playerTest5 = new Computer(19, 19, 19);
        assertFalse(checkWinner(playerTest0));
        assertTrue(checkWinner(playerTest1));
        assertTrue(checkWinner(playerTest2));
        assertFalse(checkWinner(playerTest3));
        assertFalse(checkWinner(playerTest4));
        assertFalse(checkWinner(playerTest5));
    }

    //TODO: esta se puede hacer???
    @Test
    void accionPlayerTest() {
        Human playerTest0 = new Human(19, 19, 19);
        Computer playerTest1 = new Computer(19, 19, 19);
    }

    @Test
    void checkBoxesAssigmentTest() {
        assertFalse(checkBoxesAssigment(mapTest));
        for (int i = 0; i < mapTest.matrix.length; i++) {
            for (int j = 0; j < mapTest.matrix[i].length; j++) {
                mapTest.matrix[i][j].owner = TypeOwner.HUMAN;

            }
        }
        assertTrue(checkBoxesAssigment(mapTest));
    }

    @Test
    void humanDecisionTest() {
        humanDecision(mapTest, "1", "1");
        humanDecision(mapTest, "2", "1");

        assertEquals(mapTest.matrix[0][0].owner, TypeOwner.HUMAN);
        assertEquals(mapTest.matrix[1][0].owner, TypeOwner.HUMAN);
    }

    @Test
    void checkBoxEmptyComputerTest() {
        int userRowRespond = 1;
        int userColumnRespond = 1;
        assertTrue(checkBoxEmptyComputer(mapTest, userRowRespond, userColumnRespond));
    }

    @Test
    void checkBoxEmptyHumanTest() {
        String userRowRespond = "1";
        String userColumnRespond = "1";
        assertTrue(checkBoxEmptyHuman(mapTest, userRowRespond, userColumnRespond));
    }

    @Test
    void checkColumnsTest() throws InterruptedException {
        String userColumnRespond0 = "0";
        String userColumnRespond1 = "-1";
        String userColumnRespond2 = "1";
        String userColumnRespond3 = "4";
        String userColumnRespond4 = "5";

        assertFalse(checkColumns(mapTest, userColumnRespond0));
        assertFalse(checkColumns(mapTest, userColumnRespond1));
        assertTrue(checkColumns(mapTest, userColumnRespond2));
        assertTrue(checkColumns(mapTest, userColumnRespond3));
        assertTrue(checkColumns(mapTest, userColumnRespond4));
    }

    @Test
    void checkRowsTest() throws InterruptedException {
        String userRowRespond0 = "0";
        String userRowRespond1 = "-1";
        String userRowRespond2 = "1";
        String userRowRespond3 = "3";
        String userRowRespond4 = "4";
        assertFalse(checkRows(mapTest, userRowRespond0));
        assertFalse(checkRows(mapTest, userRowRespond1));
        assertTrue(checkRows(mapTest, userRowRespond2));
        assertTrue(checkRows(mapTest, userRowRespond3));
        assertTrue(checkRows(mapTest, userRowRespond4));
    }

    @Test
    void checkNumberTest() throws InterruptedException {
        String userRespond0 = "0";
        String userRespond1 = "1";
        String userRespond2 = "a";
        String userRespond3 = ".";
        String userRespond4 = "?";

        assertTrue(checkNumber(userRespond0));
        assertTrue(checkNumber(userRespond1));
        assertFalse(checkNumber(userRespond2));
        assertFalse(checkNumber(userRespond3));
        assertFalse(checkNumber(userRespond4));
    }

    @Test
    void randomDadeTest() {
        int[] correctInt = {1, 2, 3, 4, 5, 6};
        int randomDadeTest = randomDade();

        int count = 0;
        for (int i = 0; i < correctInt.length; i++) {
            if (correctInt[i] == randomDadeTest) {
                count++;
            }
        }
        if (count != 1) {
            fail();
        }
    }

    @Test
    void checkTwiceResourcesTest() {
        Box boxWood1 = new Box(TypeResource.WOOD, TypeOwner.NONE, 1);
        Box boxWood2 = new Box(TypeResource.WOOD, TypeOwner.NONE, 1);
        Box boxCoal1 = new Box(TypeResource.COAL, TypeOwner.NONE, 1);
        Box boxCoal2 = new Box(TypeResource.COAL, TypeOwner.NONE, 1);
        Box boxSeed1 = new Box(TypeResource.SEED, TypeOwner.NONE, 1);
        Box boxSeed2 = new Box(TypeResource.SEED, TypeOwner.NONE, 1);

        Box[][] matrixTest = new Box[][]{{boxWood1, boxWood2}, {boxCoal1, boxCoal2}, {boxSeed1, boxSeed2}};

        Map mapNeTest = new Map(3, 2, matrixTest);
        assertTrue(checkTwiceResources(matrixTest));
    }
}