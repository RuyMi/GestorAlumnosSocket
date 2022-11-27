package models

import java.util.*

data class Alumno(
    var uuid: UUID,
    var nombre: String,
    val nota: Double
    )
