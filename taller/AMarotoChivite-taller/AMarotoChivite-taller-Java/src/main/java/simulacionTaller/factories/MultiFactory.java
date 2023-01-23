package simulacionTaller.factories;


import simulacionTaller.models.Multi;
import simulacionTaller.models.Worker;

import static simulacionTaller.utils.randomInfo.*;

public class MultiFactory {
    public static Multi create() {
        String name = randomName();
        int experienceYear = randomAnno();
        int salary = randomSalary() + 350;
        int dailyHours = randomDailyHours();

        return new Multi(name, experienceYear, salary, dailyHours, Worker.BossAssigment.WITHOUT_BOSS);
    }
}
