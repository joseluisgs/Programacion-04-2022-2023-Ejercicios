package simulacionTaller.factories;


import simulacionTaller.models.Worker;

import static simulacionTaller.utils.randomInfo.*;

public class WorkerFactory {
    public static Worker create() {
        String name = randomName();
        int experienceYear = randomAnno();
        int salary = randomSalary();
        int dailyHours = randomDailyHours();

        return new Worker(name, experienceYear, salary, dailyHours, Worker.BossAssigment.WITHOUT_BOSS);
    }
}
