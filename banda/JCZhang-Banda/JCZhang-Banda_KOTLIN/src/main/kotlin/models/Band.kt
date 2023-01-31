package models

import factories.*
import kotlin.math.roundToInt


class Band() {
    private val maxArraySize = 50

    private val bandArray = Array<Person?>(maxArraySize){null}

    fun startProgram() {
        fillArray(bandArray)
    }

    fun Menu() {
        do {
            println("***BIENVENIDO A LA BANDA***")
            when (selectOption()) {
                1 -> numberOfGuitarists(bandArray)
                2 -> numberOfPianists(bandArray)
                3 -> numberOfSingers(bandArray)
                4 -> numberOfMultiInstrumentalists(bandArray)
                5 -> numberOfTrumpeters(bandArray)
                6 -> numberOfBassGuitarists(bandArray)
                7 -> numberOfSingerGutarists(bandArray)
                8 -> numberOfPercussionists(bandArray)
                9 -> salaryReport()
                10 -> exit = true
            }
        } while (!exit)
    }

    private fun selectOption(): Int {
        println(" - 1 -> Número de Guitarristas")
        println(" - 2 -> Número de Pianistas")
        println(" - 3 -> Número de Cantantes")
        println(" - 4 -> Número de MultiInstrumentalistas")
        println(" - 5 -> Número de Trompetistas")
        println(" - 6 -> Número de Bajistas")
        println(" - 7 -> Número de CantanteGuitarristas")
        println(" - 8 -> Número de Percusionistas")
        println(" - 9 -> Informe de Nóminas")
        println(" - 10 -> Salir")
        println()
        val regex = """[0-9]+""".toRegex()
        var option: String
        do {
            println("Introduce la opción que desees: ")
            option = readln()
            if (!regex.matches(option) || option.toInt() < 1 || option.toInt() > 10) {
                println("DEBES INTRODUCIR UN NÚMERO ENTRE 1 y 10")
            } else {
                return option.toInt()
            }
        } while (!regex.matches(option) || option.toInt() < 1 || option.toInt() > 10)
        return 0
    }

    private fun fillArray(BandArray: Array<Person?>) {
        var peopleCount: Int
        do {
            peopleCount = 0
            // variable auxiliar que sirve para hacer los porcentajes de probabilidad
            var aux: Int
            for (i in BandArray.indices) {
                aux = (1..100).random()
                if (aux in 1..5) {
                    BandArray[i] = TrumpeterFactory.createRandomTrumpeter()
                }
                if (aux in 6..25) {
                    BandArray[i] = SingerFactory.createRandomSinger()
                }
                if (aux in 26..45) {
                    BandArray[i] = GuitaristFactory.createRandomGuitarist()
                }
                if (aux in 46..55) {
                    BandArray[i] = BassGuitaristFactory.createRandomBassGuitarist()
                }
                if (aux in 56..65) {
                    BandArray[i] = PianistFactory.createRandomPianist()
                }
                if (aux in 66..80) {
                    BandArray[i] = PercussionistFactory.createRandomPercussionist()
                }
                if (aux in 81..95) {
                    BandArray[i] = SingerGuitaristFactory.createRandomSingerGuitarist()
                }
                if (aux in 96..100) {
                    BandArray[i] = MultiInstrumentalistFactory.createRandomMultiInstrumentalist()
                }
                peopleCount++
            }
        } while (peopleCount < maxArraySize)
    }

    private fun salaryReport() {
        println("***INFORME DE SALARIOS***")
        println()
        println("El salario que han cobrado los Bajistas es de ${calculateBassGuitaristSalary() } €")
        println("El salario que han cobrado los Guitarristas es de ${calculateGuitaristSalary()} €")
        println("El salario que han cobrado los Cantantes es de ${calculateSingerSalary()} €")
        println("El salario que han cobrado los MultiInstrumentalistas es de ${calculateMultiInstrumentalistSalary()} €")
        println("El salario que han cobrado los Pianistas es de ${calculatePianistSalary()} €")
        println("El salario que han cobrado los Percusionistas es de ${ calculatePercussionistSalary()} €")
        println("El salario que han cobrado los Trompetistas es de ${calculateTrumpeterSalary()} €")
        println("El salario que han cobrado los CantanteGuitarristas es de ${ calculateSingerGutaristSalary() } €")
        println()
        println("Se ha gastado un total de ${calculateBassGuitaristSalary() + calculateGuitaristSalary()+ calculateSingerSalary()+ calculateMultiInstrumentalistSalary() +calculatePianistSalary()+ calculatePercussionistSalary() + calculateTrumpeterSalary() +calculateSingerGutaristSalary() } € ")
    }


    var exit = false
    fun numberOfTrumpeters(bandArray: Array<Person?>): Int {
        var numberOfTrumpeters = 0
        for (i in bandArray.indices) {
            if (bandArray[i] is Trumpeter) {
                numberOfTrumpeters++
            }
        }
        println("El número de Trompetistas que hay es de $numberOfTrumpeters")
        return numberOfTrumpeters
    }

    fun numberOfGuitarists(bandArray: Array<Person?>): Int {
        var numberOfGuitarists = 0
        for (i in bandArray.indices) {
            if (bandArray[i] is Guitarist) {
                numberOfGuitarists++
            }
        }
        println("El número de Guitarristas que hay es de $numberOfGuitarists")
        return numberOfGuitarists
    }

    fun numberOfBassGuitarists(bandArray: Array<Person?>): Int {
        var numberOfBassGuitarists = 0
        for (i in bandArray.indices) {
            if (bandArray[i] is BassGuitarist) {
                numberOfBassGuitarists++
            }
        }
        println("El número de Bajistas que hay es de $numberOfBassGuitarists")
        return numberOfBassGuitarists
    }

     fun numberOfPianists(bandArray: Array<Person?>): Int {
        var numberOfPianists = 0
        for (i in bandArray.indices) {
            if (bandArray[i] is Pianist) {
                numberOfPianists++
            }
        }
        println("El número de Pianistas que hay es de $numberOfPianists")
        return numberOfPianists
    }

     fun numberOfPercussionists(bandArray: Array<Person?>): Int {
        var numberOfPercussionists = 0
        for (i in bandArray.indices) {
            if (bandArray[i] is Percussionist) {
                numberOfPercussionists++
            }
        }
        println("El número de Percusionistas que hay es de $numberOfPercussionists")
        return numberOfPercussionists
    }

     fun numberOfSingerGutarists(bandArray: Array<Person?>): Int {
        var numberOfSingerGutarists = 0
        for (i in bandArray.indices) {
            if (bandArray[i] is SingerGuitarist) {
                numberOfSingerGutarists++
            }
        }
        println("El número de CantantesGuitarristas que hay es de $numberOfSingerGutarists")
        return numberOfSingerGutarists
    }

     fun numberOfMultiInstrumentalists(bandArray: Array<Person?>): Int {
        var numberOfMultiInstrumentalists = 0
        for (i in bandArray.indices) {
            if (bandArray[i] is MultiInstrumentalist) {
                numberOfMultiInstrumentalists++
            }
        }
        println("El número de MultiInstrumentalistas que hay es de $numberOfMultiInstrumentalists")
        return numberOfMultiInstrumentalists
    }

     fun numberOfSingers(bandArray: Array<Person?>): Int {
        var numberOfSingers = 0
        for (i in bandArray.indices) {
            if (bandArray[i] is Singer) {
                numberOfSingers++
            }
        }
        println("El número de Cantantes que hay es de $numberOfSingers")
        return numberOfSingers
    }

    fun calculateTrumpeterSalary(): Double {
        return (((Trumpeter.salary * TrumpeterFactory.trumpeterCounter) * 100).roundToInt() / 100.0)
    }

    fun calculateGuitaristSalary(): Double {
        return ((Guitarist.salary * GuitaristFactory.guitaristCounter * 100).roundToInt() / 100.0)
    }

     fun calculatePianistSalary(): Double {
        return ((Pianist.salary * PianistFactory.pianistCounter * 100).roundToInt() / 100.0)
    }

     fun calculatePercussionistSalary(): Double {
        return ((Percussionist.salary * PercussionistFactory.percussionistCounter * 100).roundToInt() / 100.0)
    }

     fun calculateSingerSalary(): Double {
        return ((Singer.salary * SingerFactory.singerCounter * 100).roundToInt() / 100.0)
    }

     fun calculateMultiInstrumentalistSalary(): Double {
        return ((MultiInstrumentalist.salary * MultiInstrumentalistFactory.multiInstrumentalistCounter * 100).roundToInt() / 100.0)

    }

     fun calculateSingerGutaristSalary(): Double {
        return ((SingerGuitarist.salary * SingerGuitaristFactory.singerGuitaristCounter) * 100).roundToInt() / 100.0
    }

     fun calculateBassGuitaristSalary(): Double {
        return ((BassGuitarist.salary * BassGuitaristFactory.bassGuitaristCounter * 100).roundToInt() / 100.0)
    }

}
