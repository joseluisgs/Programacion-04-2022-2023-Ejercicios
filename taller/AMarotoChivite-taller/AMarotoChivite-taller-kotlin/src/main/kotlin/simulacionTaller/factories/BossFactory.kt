package simulacionTaller.factories

import simulacionTaller.models.Boss
import simulacionTaller.models.Worker
import simulacionTaller.utils.randomAnno
import simulacionTaller.utils.randomName
import simulacionTaller.utils.randomSalary

object BossFactory {
    fun create(): Boss {
        val name = randomName()
        var experienceYear = randomAnno()
        if (experienceYear < 5) {
            experienceYear += 5
        }
        val salary = randomSalary() + 750
        // Por defecto 0, ya que posteriormente cuando se cree todo el taller, se detallará a cada jefe sus trabajadores
        val workers = arrayOfNulls<Worker>(0)
        return Boss(name, experienceYear, salary.toDouble(), workers)
    }
}