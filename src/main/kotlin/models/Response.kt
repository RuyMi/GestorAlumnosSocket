package models

import java.time.LocalDateTime

data class Response<T>(
    val content: T?, // Contenido de la respuesta
    val type: Type, // Tipo de respuesta
    val createAt: LocalDateTime = LocalDateTime.now()
) {
    enum class Type {
        OK, ERROR
    }
}