package simulacionTaller.utils

import simulacionTaller.models.*
import simulacionTaller.models.Worker.BossAssigment
import java.util.*


/**
 * Genera de manera aleatoria un nombre dentro de nuestro catálogo
 *
 * @return catalogoNombre[num], es el nombre aleatorio
 */
fun randomName(): String {
    val r = Random()
    val num = r.nextInt(24)
    val catalogoNombres = arrayOf(
        "Pedro", "Alexandra", "Angel", "José",
        "Elena", "Ricardo", "Domingo", "Patricia",
        "Maribel", "Mariana", "Ivan", "Luis", "Mario", "Jorge", "Adrián", "Marcos", "Lara",
        "Marta", "Maria", "Claudia", "Sandra", "Fernando", "Roberto", "Marisa"
    )
    return catalogoNombres[num]
}

/**
 * Genera un número entre 1 y 35 (incluidos)
 *
 * @return años de experiencia
 */
fun randomAnno(): Int {
    return (Math.random() * 35 + 1).toInt()
}

/**
 * Genera un número entre 1350 y 1565 (incluidos)
 *
 * @return salario
 */
fun randomSalary(): Int {
    return (Math.random() * 215 + 1350).toInt()
}

/**
 * Genera un número random pudiendo ser: 30, 35 o 40
 *
 * @return salario
 */
fun randomDailyHours(): Int {
    val random = (Math.random() * 2 + 1).toInt()
    return if (random == 1) {
        30
    } else if (random == 2) {
        35
    } else {
        40
    }
}

/**
 *
 */
fun setDependentsOfBosses(persons: Array<PersonBrench?>) {
    val quantityBosses: Int = Boss.countBoss
    val quantityWorkers: Int = Worker.countWorkerGeneral
    if (quantityWorkers % quantityBosses == 0) {
        val workersForEachBoss = quantityWorkers / quantityBosses
        var countWorkerForNextBoss = 0

        // Almacenamos todos los trabajadores sin jefe asignado
        val storageWorkersWithoutBoss = arrayOfNulls<Worker>(quantityWorkers)
        for (i in persons.indices) {
            for (j in storageWorkersWithoutBoss.indices) {
                if (persons[i] is Worker && storageWorkersWithoutBoss[j] == null && (persons[i] as Worker?)!!.bossAssigment == BossAssigment.WITHOUT_BOSS) {
                    storageWorkersWithoutBoss[j] = persons[i] as Worker?
                    break
                }
            }
        }
        // Recorremos los jefes
        for (person in persons) {
            if (person is Boss) {
                val dependents = arrayOfNulls<Worker>(workersForEachBoss)

                // Asignamos los trabajadores al jefe
                for (i in 0 until workersForEachBoss) {
                    val worker = storageWorkersWithoutBoss[countWorkerForNextBoss++]
                    worker!!.bossAssigment = BossAssigment.WITH_BOSS
                    dependents[i] = worker
                }
                person.dependents = dependents
            }
        }
//    } else {
//        // En el caso que nos sobren trabajadores
//        val workersForEachBoss = quantityWorkers / quantityBosses
//        var countWorkerForNextBoss = 0
//        // Mediante este contador, vamos almacenando de manera equitativa los trabajadores restantes
//        var countRemainingWorkers = quantityWorkers % quantityBosses
//        // Almacenamos todos los trabajadores sin jefe asignado
//        val storageWorkersWithoutBoss = arrayOfNulls<Worker>(quantityWorkers)
//        for (i in persons.indices) {
//            for (j in storageWorkersWithoutBoss.indices) {
//                if (persons[i] is Worker && storageWorkersWithoutBoss[j] == null && (persons[i] as Worker?)!!.bossAssigment == BossAssigment.WITHOUT_BOSS) {
//                    storageWorkersWithoutBoss[j] = persons[i] as Worker?
//                    break
//                }
//            }
//        }
//        // Recorremos los jefes
//        for (i in persons.indices) {
//            if (persons[i] is Boss) {
//                var quantityDependents = workersForEachBoss
//                if (countRemainingWorkers > 0) {
//                    quantityDependents++
//                    countRemainingWorkers--
//                }
//                val dependents = arrayOfNulls<Worker>(quantityDependents)
//                // Asignamos los trabajadores al jefe
//                for (j in 0 until quantityDependents) {
//                    val worker = storageWorkersWithoutBoss[countWorkerForNextBoss++]
//                    if (worker != null) {
//                        worker.bossAssigment = BossAssigment.WITH_BOSS
//                        dependents[j] = worker
//                    }
//                }
//                persons[i].setDependents(dependents)
//            }
//        }
    }
}
