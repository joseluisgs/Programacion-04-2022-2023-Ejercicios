package models

import enums.EstadoButaca

data class Butaca(
    val numeroSitio: String,
    val precioButaca: Double = 8.50,
    val precioButacaVip: Double= 10.50,
    var estadoButaca: EstadoButaca
)

