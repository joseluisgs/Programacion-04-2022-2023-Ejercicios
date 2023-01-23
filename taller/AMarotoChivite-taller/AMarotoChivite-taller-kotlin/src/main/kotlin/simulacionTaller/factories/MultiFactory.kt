package simulacionTaller.factories

import simulacionTaller.models.Multi
import simulacionTaller.models.Worker.BossAssigment
import simulacionTaller.utils.randomAnno
import simulacionTaller.utils.randomDailyHours
import simulacionTaller.utils.randomName
import simulacionTaller.utils.randomSalary

object MultiFactory {
    @JvmStatic
    fun create(): Multi {
        val name = randomName()
        val experienceYear = randomAnno()
        val salary = randomSalary() + 350
        val dailyHours = randomDailyHours()
        return Multi(name, experienceYear, salary.toDouble(), dailyHours, BossAssigment.WITHOUT_BOSS)
    }
}