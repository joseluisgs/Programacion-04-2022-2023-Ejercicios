package simulacionTaller.factories;

import simulacionTaller.models.Boss;
import simulacionTaller.models.Worker;

import static simulacionTaller.utils.randomInfo.*;

public class BossFactory {

    public static Boss create() {
        String name = randomName();
        int experienceYear = randomAnno();
        if (experienceYear < 5) {
            experienceYear = experienceYear + 5;
        }
        int salary = randomSalary() + 750;
        // Por defecto 0, ya que posteriormente cuando se cree todo el taller, se detallará a cada jefe sus trabajadores
        Worker[] workers = new Worker[0];
        return new Boss(name, experienceYear, salary, workers);
    }
}
