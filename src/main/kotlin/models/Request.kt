package models

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import java.time.LocalDateTime
import java.util.*

@Serializable
data class Request<T>(
    val content: T?, // Contenido de la petición
    val type: Type, // Tipo de petición
    @Contextual
    val createAt: LocalDateTime = LocalDateTime.now(),
    @Contextual
    val uuid: UUID = UUID.randomUUID()
) {
    enum class Type {
        LISTANOTA, LISTANOMBRE, CREAR, ACTUALIZAR, DELETE, ESTADISTICAS
    }
}