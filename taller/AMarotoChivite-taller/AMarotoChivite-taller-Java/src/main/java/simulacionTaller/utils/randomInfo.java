package simulacionTaller.utils;

import simulacionTaller.models.Boss;
import simulacionTaller.models.PersonBrench;
import simulacionTaller.models.Worker;

import java.util.Random;

public class randomInfo {
    /**
     * Genera de manera aleatoria un nombre dentro de nuestro catálogo
     *
     * @return catalogoNombre[num], es el nombre aleatorio
     */
    public static String randomName() {
        Random r = new Random();
        int num = r.nextInt(24);
        String[] catalogoNombres = {
                "Pedro", "Alexandra", "Angel", "José",
                "Elena", "Ricardo", "Domingo", "Patricia",
                "Maribel", "Mariana", "Ivan", "Luis", "Mario", "Jorge", "Adrián", "Marcos", "Lara",
                "Marta", "Maria", "Claudia", "Sandra", "Fernando", "Roberto", "Marisa"
        };
        return catalogoNombres[num];
    }

    /**
     * Genera un número entre 1 y 35 (incluidos)
     *
     * @return años de experiencia
     */
    public static int randomAnno() {
        return (int) (Math.random() * 35 + 1);
    }

    /**
     * Genera un número entre 1350 y 1565 (incluidos)
     *
     * @return salario
     */
    public static int randomSalary() {
        return (int) (Math.random() * 215 + 1350);
    }

    /**
     * Genera un número random pudiendo ser: 30, 35 o 40
     *
     * @return salario
     */
    public static int randomDailyHours() {
        int random = (int) (Math.random() * 2 + 1);
        if (random == 1) {
            return 30;
        } else if (random == 2) {
            return 35;
        } else {
            return 40;
        }
    }

    /**
     *
     */
    public static void setDependentsOfBosses(PersonBrench[] persons) {
        int quantityBosses = Boss.getCountBoss();
        int quantityWorkers = Worker.getCountWorkerGeneral();

        if (quantityWorkers % quantityBosses == 0) {
            int workersForEachBoss = quantityWorkers / quantityBosses;
            int countWorkerForNextBoss = 0;

            // Almacenamos todos los trabajadores sin jefe asignado
            Worker[] storageWorkersWithoutBoss = new Worker[quantityWorkers];
            for (int i = 0; i < persons.length; i++) {
                for (int j = 0; j < storageWorkersWithoutBoss.length; j++) {
                    if (persons[i] instanceof Worker && storageWorkersWithoutBoss[j] == null && ((Worker) persons[i]).bossAssigment.equals(Worker.BossAssigment.WITHOUT_BOSS)) {
                        storageWorkersWithoutBoss[j] = (Worker) persons[i];
                        break;
                    }
                }
            }
            // Recorremos los jefes
            for (PersonBrench person : persons) {
                if (person instanceof Boss boss) {
                    Worker[] dependents = new Worker[workersForEachBoss];

                    // Asignamos los trabajadores al jefe
                    for (int i = 0; i < workersForEachBoss; i++) {
                        Worker worker = storageWorkersWithoutBoss[countWorkerForNextBoss++];
                        worker.bossAssigment = Worker.BossAssigment.WITH_BOSS;
                        dependents[i] = worker;
                    }

                    boss.setDependents(dependents);
                }
            }
        } else {
            // En el caso que nos sobren trabajadores
            int workersForEachBoss = quantityWorkers / quantityBosses;
            int countWorkerForNextBoss = 0;
            // Mediante este contador, vamos almacenando de manera equitativa los trabajadores restantes
            int countRemainingWorkers = quantityWorkers % quantityBosses;
            // Almacenamos todos los trabajadores sin jefe asignado
            Worker[] storageWorkersWithoutBoss = new Worker[quantityWorkers];
            for (int i = 0; i < persons.length; i++) {
                for (int j = 0; j < storageWorkersWithoutBoss.length; j++) {
                    if (persons[i] instanceof Worker && storageWorkersWithoutBoss[j] == null && ((Worker) persons[i]).bossAssigment.equals(Worker.BossAssigment.WITHOUT_BOSS)) {
                        storageWorkersWithoutBoss[j] = (Worker) persons[i];
                        break;
                    }
                }
            }
            // Recorremos los jefes
            for (int i = 0; i < persons.length; i++) {
                if (persons[i] instanceof Boss boss) {
                    int quantityDependents = workersForEachBoss;
                    if (countRemainingWorkers > 0) {
                        quantityDependents++;
                        countRemainingWorkers--;
                    }
                    Worker[] dependents = new Worker[quantityDependents];
                    // Asignamos los trabajadores al jefe
                    for (int j = 0; j < quantityDependents; j++) {
                        Worker worker = storageWorkersWithoutBoss[countWorkerForNextBoss++];
                        if (worker != null) {
                            worker.bossAssigment = Worker.BossAssigment.WITH_BOSS;
                            dependents[j] = worker;
                        }
                    }
                    boss.setDependents(dependents);
                }
            }
        }
    }
}

