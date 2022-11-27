import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import models.Request

val json = Json

fun main(args: Array<String>) {
    val request = Request<Int>(1, Request.Type.CREAR)
    val prueba = json.encodeToString(request)
    val hola = json.decodeFromString<Request<Int>>(prueba)
    println(hola.uuid)
}