package simulacionTaller.factories

import simulacionTaller.models.Worker
import simulacionTaller.models.Worker.BossAssigment
import simulacionTaller.utils.randomAnno
import simulacionTaller.utils.randomDailyHours
import simulacionTaller.utils.randomName
import simulacionTaller.utils.randomSalary

object WorkerFactory {
    @JvmStatic
    fun create(): Worker {
        val name = randomName()
        val experienceYear = randomAnno()
        val salary = randomSalary()
        val dailyHours = randomDailyHours()
        return Worker(name, experienceYear, salary.toDouble(), dailyHours, BossAssigment.WITHOUT_BOSS)
    }
}