package simulacionTaller.factories

import simulacionTaller.models.Plater
import simulacionTaller.models.Worker.BossAssigment
import simulacionTaller.utils.randomAnno
import simulacionTaller.utils.randomDailyHours
import simulacionTaller.utils.randomName
import simulacionTaller.utils.randomSalary

object PlaterFactory {
    @JvmStatic
    fun create(): Plater {
        val name = randomName()
        val experienceYear = randomAnno()
        val salary = randomSalary()
        val dailyHours = randomDailyHours()
        return Plater(name, experienceYear, salary.toDouble(), dailyHours, BossAssigment.WITHOUT_BOSS)
    }
}