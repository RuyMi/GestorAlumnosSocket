package server

import io.ktor.network.selector.*
import io.ktor.network.sockets.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import mu.KotlinLogging

private val logger = KotlinLogging.logger {}
private const val PORT = 7531
var numeroConexiones = 0

fun main()= runBlocking{


    val selectorManager = SelectorManager(Dispatchers.IO)

    //Utilizaremos un socket de tipo TCP
    val serverSocket = aSocket(selectorManager)
        .tcp()
        .bind("127.0.0.1", PORT)

    logger.debug { "Servidor escuchando en: ${serverSocket.localAddress} en el puerto: $PORT"}
    while(true){
        //Esperamos una conexión
        val clientSocket = serverSocket.accept()

        numeroConexiones++
        logger.debug{"Cliente número $numeroConexiones"}

        launch{
            GestorClientes(clientSocket).run()
        }



    }




}