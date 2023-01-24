package gameCatan.utils;

import gameCatan.enums.TypeOwner;
import gameCatan.enums.TypeResource;
import gameCatan.models.*;

import java.util.Scanner;

import static java.lang.System.exit;

public class funciones {

    /**
     * Verificamos que se creen dos casillas de recursos como mínimo
     *
     * @param boxes mapa de casillas
     * @return true si hay dos casillas de cada o más, false en caso contrario
     */
    public static boolean checkTwiceResources(Box[][] boxes) {
        int countWood = 0;
        int countCoal = 0;
        int countSeed = 0;

        for (int i = 0; i < boxes.length; i++) {
            for (int j = 0; j < boxes[i].length; j++) {
                if (boxes[i][j].typeResource.equals(TypeResource.WOOD)) {
                    countWood++;
                }
                if (boxes[i][j].typeResource.equals(TypeResource.WOOD)) {
                    countCoal++;
                }
                if (boxes[i][j].typeResource.equals(TypeResource.WOOD)) {
                    countSeed++;
                }
            }
        }
        return countWood >= 2 && countCoal >= 2 && countSeed >= 2;
    }

    /**
     * Simulación principal
     *
     * @param map            mapa donde se jugará
     * @param playerHumano   jugador uno que tomará decisiones
     * @param playerComputer jugador dos máquina, con decisiones aleatorias
     * @throws InterruptedException
     */
    public static void simulationCatan(Map map, Human playerHumano, Computer playerComputer) throws InterruptedException {
        // FASE 1: Elegir casillas, el humano decide yel computer elige solo
        while (!checkBoxesAssigment(map)) {
            // Primero elige Humano
            while (true) {
                // Imprimir mapa
                map.print();
                System.out.println();
                System.out.println("HUMANO -> Introduce el valor de fila y columna de la casilla que quieras apropiar...");
                String userRowRespond = userRespond("Fila (1-" + map.sizeRow + ") : ");
                String userColumnRespond = userRespond("Columna (1-" + map.sizeCol + ") : ");
                if (checkRows(map, userRowRespond)
                        && checkColumns(map, userColumnRespond)) {
                    if (checkBoxEmptyHuman(map, userRowRespond, userColumnRespond)) {
                        // Asignamos la posición en propiedad del Humano
                        humanDecision(map, userRowRespond, userColumnRespond);
                        break;
                    } else {
                        System.out.println("CASILLA OCUPADA!");
                    }
                }
            }
            // Segundo elige Computer
            System.out.println("MAQUINA -> Eligiendo casilla...");
            Thread.sleep(1200);
            computerDecision(map);

        }

        // FASE 2: Lanzar dados e ir incrementando los almacenes en función de lo que haya en el tablero
        // el número del dado que nos salga nos aumentará ese valor de los recursos que coincidan...
        int contadorRondas = 0;
        do {
            System.out.println("RONDA " + contadorRondas++);
            System.out.println("--------");
            // Imprimir mapa
            map.print();
            System.out.println(playerHumano);
            System.out.println(playerComputer);
            System.out.println();

            // Primero elige Humano
            int resultDadeHuman = randomDade();
            System.out.println("HUMANO -> Lanza un dado... ha salido " + resultDadeHuman);
            accionPlayer(map, resultDadeHuman, playerHumano);
            // Check ganador
            if (checkWinner(playerHumano)) {
                // Imprimir resultados
                System.out.println(playerHumano);
                System.out.println(playerComputer);
                System.out.println();

                System.out.println("Ha ganado el HUMANO!");
                exit(0);
            }

            // Segundo elige Maquina
            int resultDadeComputer = randomDade();
            System.out.println("MAQUINA -> Lanza un dado... Ha salido " + resultDadeComputer);
            accionPlayer(map, resultDadeComputer, playerComputer);
            // Check ganador
            if (checkWinner(playerComputer)) {
                // Imprimir resultados
                System.out.println(playerHumano);
                System.out.println(playerComputer);
                System.out.println();

                System.out.println("Ha ganado la MÁQUINA!");
                exit(0);
            }
            // Imprimir resultados
            System.out.println("RESULTADOS:");
            System.out.println(playerHumano);
            System.out.println(playerComputer);
            System.out.println("NADIE HA GANADO... siguiente ronda...");
            Thread.sleep(2500);
        } while (true);
    }


    /**
     * Verificar que esté sin propiedad la casilla para poder asignar propiedad
     *
     * @param map               mapa de las casillas
     * @param userRowRespond    cadena de ubicación de la fila a verificar
     * @param userColumnRespond cadena de ubicación de la columna a verificar
     * @return true si está sin propiedad, false en caso contrario
     */
    public static boolean checkBoxEmptyHuman(Map map, String userRowRespond, String userColumnRespond) {
        int userRowRespondCast = Integer.parseInt(userRowRespond) - 1;
        int userColumnRespondCast = Integer.parseInt(userColumnRespond) - 1;
        return map.matrix[userRowRespondCast][userColumnRespondCast].owner.equals(TypeOwner.NONE);
    }

    /**
     * @param player
     * @return
     */
    public static boolean checkWinner(Player player) {
        int countToWin = 3;
        int count = 0;
        if (player.storageWood >= 20) {
            count++;
        }
        if (player.storageCoal >= 20) {
            count++;
        }
        if (player.storageSeed >= 20) {
            count++;
        }
        return count == countToWin;
    }

    /**
     * Encuentra que casilla coincide con el valor del dado del jugador y aumentamos el almacén del jugador
     *
     * @param map        mapa del juego
     * @param resultDade para buscar en el mapa
     * @param player     tipo de jugador que realiza la acción
     */
    public static void accionPlayer(Map map, int resultDade, Player player) {
        for (int i = 0; i < map.matrix.length; i++) {
            for (int j = 0; j < map.matrix[i].length; j++) {
                if (map.matrix[i][j].randomValue == resultDade) {
                    if (player instanceof Human && map.matrix[i][j].owner.equals(TypeOwner.HUMAN)) {
                        if (map.matrix[i][j].typeResource.equals(TypeResource.WOOD)) {
                            player.storageWood = player.storageWood + map.matrix[i][j].randomValue;
                        }
                        if (map.matrix[i][j].typeResource.equals(TypeResource.COAL)) {
                            player.storageCoal = player.storageCoal + map.matrix[i][j].randomValue;
                        }
                        if (map.matrix[i][j].typeResource.equals(TypeResource.SEED)) {
                            player.storageSeed = player.storageSeed + map.matrix[i][j].randomValue;
                        }
                    } else if (player instanceof Computer && map.matrix[i][j].owner.equals(TypeOwner.COMPUTER)) {
                        if (map.matrix[i][j].typeResource.equals(TypeResource.WOOD)) {
                            player.storageWood = player.storageWood + map.matrix[i][j].randomValue;
                        }
                        if (map.matrix[i][j].typeResource.equals(TypeResource.COAL)) {
                            player.storageCoal = player.storageCoal + map.matrix[i][j].randomValue;
                        }
                        if (map.matrix[i][j].typeResource.equals(TypeResource.SEED)) {
                            player.storageSeed = player.storageSeed + map.matrix[i][j].randomValue;
                        }
                    }
                }
            }
        }
    }

    /**
     * Verificar que ya hemos asignado en todas las casillas propiedad
     *
     * @param map donde se verificará
     * @return true si están todas asignadas, false en caso contrario
     */
    public static boolean checkBoxesAssigment(Map map) {
        int countBoxNotOwner = 0;
        for (int i = 0; i < map.matrix.length; i++) {
            for (int j = 0; j < map.matrix[i].length; j++) {
                if (!map.matrix[i][j].owner.equals(TypeOwner.NONE)) {
                    countBoxNotOwner++;
                }
            }
        }
        return countBoxNotOwner == (map.sizeRow * map.sizeCol);
    }

    /**
     * Se asignará en una casilla la propiedad del humano
     *
     * @param map donde se seleccionará la casilla
     */
    public static void humanDecision(Map map, String userRowRespond, String userColumnRespond) {
        int userRowRespondCast = Integer.parseInt(userRowRespond) - 1;
        int userColumnRespondCast = Integer.parseInt(userColumnRespond) - 1;
        map.matrix[userRowRespondCast][userColumnRespondCast].owner = TypeOwner.HUMAN;
    }

    /**
     * Se asignará en una casilla la propiedad de la máquina que se ha elegido aleatoriamente
     *
     * @param map donde se seleccionará la casilla
     */
    public static void computerDecision(Map map) {
        while (true) {
            // Repetimos hasta que elija una casilla sin propietario
            int randomRow = (int) (Math.random() * map.sizeRow + 1) - 1;
            int randomColumn = (int) (Math.random() * map.sizeCol + 1) - 1;

            if (checkBoxEmptyComputer(map, randomRow, randomColumn)) {
                map.matrix[randomRow][randomColumn].owner = TypeOwner.COMPUTER;
                break;
            }
        }
    }

    /**
     * Verificar que la casilla esté sin dueño
     *
     * @param map          donde verificaremos
     * @param randomRow    elección de la máquina
     * @param randomColumn elección de la máquina
     * @return true si está vacía, false en caso contrario
     */
    public static boolean checkBoxEmptyComputer(Map map, int randomRow, int randomColumn) {
        return map.matrix[randomRow][randomColumn].owner.equals(TypeOwner.NONE);
    }

    /**
     * Verificamos si existe la columna el valor que nos indican en el mapa
     *
     * @param map               mapa saber lo valores máximos
     * @param userColumnRespond entrada del usuario para verificar
     * @return true si la columna se encuentra dentro de los límites del mapa, false en caso contrario
     */
    public static boolean checkColumns(Map map, String userColumnRespond) throws InterruptedException {

        // Verificamos primero que sea número
        if (!checkNumber(userColumnRespond)) {
            return false;
        }

        // Verificamos que el valor se encuentre en el mapa
        int userRespondCast = Integer.parseInt(userColumnRespond) - 1;
        int limitColumn = map.sizeCol - 1;
        if (userRespondCast >= 0 && userRespondCast <= limitColumn) {
            return true;
        } else {
            System.out.println("LA COLUMNA SELECCIONADA NO EXISTE EN EL MAPA!");
            System.out.println();
            Thread.sleep(1200);
            return false;
        }
    }

    /**
     * Verificamos si existe la fila el valor que nos indican en el mapa
     *
     * @param map            mapa saber lo valores máximos
     * @param userRowRespond entrada del usuario para verificar
     * @return true si la fila se encuentra dentro de los límites del mapa, false en caso contrario
     */
    public static boolean checkRows(Map map, String userRowRespond) throws InterruptedException {
        // Verificamos primero que sea número
        if (!checkNumber(userRowRespond)) {
            return false;
        }

        // Verificamos que el valor se encuentre en el mapa
        int userRespondCast = (Integer.parseInt(userRowRespond) - 1);
        int limitRow = map.sizeRow - 1;
        if (userRespondCast >= 0 && userRespondCast <= limitRow) {
            return true;
        } else {
            System.out.println("LA FILA SELECCIONADA NO EXISTE EN EL MAPA!");
            System.out.println();
            Thread.sleep(1200);
            return false;
        }
    }

    /**
     * Expresión regular para obligar que nos introduzcan un número
     *
     * @param userRespond la entrada del usuario
     * @return true si es número, false si no lo es
     */
    public static boolean checkNumber(String userRespond) throws InterruptedException {
        String regex = "[0-9]*";
        if (!userRespond.matches(regex)) {
            System.out.println("DEBE SER UN NÚMERO!");
            System.out.println();
            Thread.sleep(1500);
            return false;
        }
        return true;
    }

    /**
     * Se le presentará un mensaje al usuario y deberá introducir una respuesta que recogeremos
     *
     * @param message que se le muestra al usuario
     * @return la respuesta del usuario
     */
    public static String userRespond(String message) {
        System.out.println(message);
        Scanner r = new Scanner(System.in);
        return r.nextLine();
    }

    /**
     * Dado aleatorio pudiendo ser mínimo 1 y máximo 6
     *
     * @return int
     */
    public static int randomDade() {
        return (int) (Math.random() * 6 + 1);
    }
}
