package salacine.models

import salacine.enums.FilmGenero

data class Film (val titulo: String, val year: UShort, val director: String, val genero: FilmGenero )