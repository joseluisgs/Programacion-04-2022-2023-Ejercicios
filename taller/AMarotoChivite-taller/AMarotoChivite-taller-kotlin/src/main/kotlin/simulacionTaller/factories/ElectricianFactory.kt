package simulacionTaller.factories

import simulacionTaller.models.Electrician
import simulacionTaller.models.Worker.BossAssigment
import simulacionTaller.utils.randomAnno
import simulacionTaller.utils.randomDailyHours
import simulacionTaller.utils.randomName
import simulacionTaller.utils.randomSalary

object ElectricianFactory {
    @JvmStatic
    fun create(): Electrician {
        val name = randomName()
        val experienceYear = randomAnno()
        val salary = randomSalary()
        val dailyHours = randomDailyHours()
        return Electrician(name, experienceYear, salary.toDouble(), dailyHours, BossAssigment.WITHOUT_BOSS)
    }
}