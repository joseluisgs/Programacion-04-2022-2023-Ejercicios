package ModelsCestaDeCompra

import java.time.LocalDate

data class Cesta(val idCesta: Int, val fechaCreacion: LocalDate, val usuario: Usuario, val listaCesta: ListaCesta) {}