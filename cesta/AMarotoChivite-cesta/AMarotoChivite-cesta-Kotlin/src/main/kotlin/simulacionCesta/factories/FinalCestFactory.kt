package simulacionCesta.factories

import simulacionCesta.models.FinalCest
import java.time.LocalDate

object FinalCestFactory {
    @JvmStatic
    fun create(): FinalCest {
        val cestList = CestListFactory.create()
        val dateCreation = LocalDate.now()
        return FinalCest(dateCreation, cestList)
    }
}