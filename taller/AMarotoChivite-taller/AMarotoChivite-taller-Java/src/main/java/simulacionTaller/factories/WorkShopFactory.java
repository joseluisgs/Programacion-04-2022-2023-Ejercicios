package simulacionTaller.factories;

import simulacionTaller.models.PersonBrench;

import static simulacionTaller.utils.randomInfo.setDependentsOfBosses;

public class WorkShopFactory {

    /**
     * Creará un taller con los porcentajes dados de cada miembro, el resto serán trabajadores normales,
     * y una pequeña probabilidad de aparecer un MultiTrabajador (chapista y electricista)
     *
     * @return taller con todos los miembros
     */
    public static PersonBrench[] create(int quantityPerson, int bossPercent, int electricianPercent,
                                        int platerPercent) {
        PersonBrench[] workShop = new PersonBrench[quantityPerson];

        int quantityBoss = ((quantityPerson * bossPercent) / 100);
        int quantityElectrician = ((quantityPerson * electricianPercent) / 100);
        int quantityPlater = ((quantityPerson * platerPercent) / 100);

        int noWorkerAssign = quantityPerson
                - quantityBoss
                - quantityElectrician
                - quantityPlater;

        int quantityMulti = getQuantityMulti(noWorkerAssign);

        for (int i = 0; i < workShop.length; i++) {
            if (i < quantityBoss) {
                workShop[i] = BossFactory.create();
            } else if (i < quantityBoss + quantityElectrician) {
                workShop[i] = ElectricianFactory.create();
            } else if (i < quantityBoss + quantityElectrician + quantityPlater) {
                workShop[i] = PlaterFactory.create();
            } else if (i < quantityBoss + quantityElectrician + quantityPlater + quantityMulti) {
                workShop[i] = MultiFactory.create();
            } else {
                workShop[i] = WorkerFactory.create();
            }
        }
        // Establecemos a cada jefe sus trabajadores
        setDependentsOfBosses(workShop);
        return workShop;
    }

    public static int getQuantityMulti(int restNoWorkerAssign) {
        int quantityMulti = 0;

        for (int i = 1; i <= restNoWorkerAssign; i++) {
            // Probabilidad de que salga un multi será de 10%
            int random = (int) (Math.random() * 10 + 1);
            if (random == 1) {
                quantityMulti++;
            }
        }

        return quantityMulti;
    }
}
