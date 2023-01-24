package simulacionCesta.factories;

import simulacionCesta.models.CestList;
import simulacionCesta.models.FinalCest;

import java.time.LocalDate;

public class FinalCestFactory {
    public static FinalCest create() {
        CestList cestList = CestListFactory.create();
        LocalDate dateCreation = LocalDate.now();
        return new FinalCest(dateCreation, cestList);
    }
}
