package client

import io.ktor.network.selector.*
import io.ktor.network.sockets.*
import io.ktor.utils.io.*
import kotlinx.coroutines.Dispatchers
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import models.Alumno
import models.Request
import java.util.*


private const val HOST = "localhost"
private const val PORT = 7531
private val json = Json


  suspend fun main ()  {
        // Indicamos el Dispatcher para el Cliente
         val selectorManager = SelectorManager(Dispatchers.IO)

        val socket = aSocket(selectorManager).tcp()
            .connect(HOST, PORT) // Nos conectamos al servidor en el puerto 6969

       // println("✅ $id Conectado a: ${socket.remoteAddress}")

        // Creamos un canal de entrada y salida
        val entrada = socket.openReadChannel()
        val salida = socket.openWriteChannel(autoFlush = true)

      //hay que hacer un menu que le salga al cliente y le de las opciones que queremos
    println("""
        Porfavor eliga una de las siguientes opciones marcandola con su numero correspodiente:
        1.Listar todos los alumnos
        2.Crear un nuevo alumno
        3.Actualizar el alumno
        4.Generar Estadisticas
        5.Borrar alumno
        6.Exit  
    """.trimIndent())
      val num = readln().toInt() as Int

      when (num){
        //1->
          2->{
              val request = crearAlumno()
              val peticion = json.encodeToString(request) + "\n" // Añadimos el salto de línea para que se envíe
              salida.writeStringUtf8(peticion)
          }
        //3->
          //4->
          //5->
          //6->
      }

    /*  // Enviamos una petición al servidor
      val request = Request<Alumno>(
          content = Alumno(),
          type = Request.Type.POST
      )
      val peticion = json.encodeToString(request) + "\n" // Añadimos el salto de línea para que se envíe
      logger.debug { "Petición: $peticion" }
      salida.writeStringUtf8(peticion)
        */




    }



suspend fun crearAlumno(): Request<Alumno> {
    // var uuid = UUID.randomUUID()
    print("Ingrese un nombre: ")
    var  nombre = readln()//.toInt() as Int
    println("Ingrese la nota de ${nombre}")
   var nota= readln().toDouble() as Double

    val request = Request<Alumno>(
        content = Alumno(UUID.randomUUID(),nombre=nombre,nota=nota),
        type = Request.Type.CREAR
    )
//    logger.debug { "Petición: $peticion" }
    return  request
}

suspend fun listaralumnos():Request<Alumno> {





}



