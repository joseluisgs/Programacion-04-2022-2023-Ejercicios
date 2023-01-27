package simulacionTaller.factories;


import simulacionTaller.models.Plater;
import simulacionTaller.models.Worker;

import static simulacionTaller.utils.randomInfo.*;

public class PlaterFactory {
    public static Plater create() {
        String name = randomName();
        int experienceYear = randomAnno();
        int salary = randomSalary();
        int dailyHours = randomDailyHours();

        return new Plater(name, experienceYear, salary, dailyHours, Worker.BossAssigment.WITHOUT_BOSS);
    }
}
