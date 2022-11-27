package server


import io.ktor.network.sockets.*
import io.ktor.utils.io.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import mu.KotlinLogging

//aqui tenemos que crear el swicth con la petcion que nos envia el cliente y procesarla segun su tipo
private val logger = KotlinLogging.logger {}
private val json = Json
class GestorClientes(
    private val cliente: Socket
    ) {
    private val entrada = cliente.openReadChannel()
    private val salida = cliente.openWriteChannel(autoFlush = true)

    suspend fun run() = withContext(Dispatchers.IO) {

        val procesarOperaciones = launch{
            logger.debug("Procesando mensajes...")
            procesarOperaciones(entrada, salida)
        }

    }

   private suspend fun procesarOperaciones(entrada: ByteReadChannel, salida: ByteWriteChannel) {
        while(!entrada.isClosedForRead && !salida.isClosedForWrite){
            logger.debug { "Esperando acción a realizar" }
            val input = entrada.readUTF8Line()
            logger.debug { "Recibido mensaje del cliente: $input" }



        }
    }

}