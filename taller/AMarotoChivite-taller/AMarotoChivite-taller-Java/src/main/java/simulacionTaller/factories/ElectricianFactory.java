package simulacionTaller.factories;


import simulacionTaller.models.Electrician;
import simulacionTaller.models.Worker;

import static simulacionTaller.utils.randomInfo.*;

public class ElectricianFactory {
    public static Electrician create() {
        String name = randomName();
        int experienceYear = randomAnno();
        int salary = randomSalary();
        int dailyHours = randomDailyHours();

        return new Electrician(name, experienceYear, salary, dailyHours, Worker.BossAssigment.WITHOUT_BOSS);
    }
}
