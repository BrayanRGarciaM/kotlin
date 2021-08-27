package e.bolsadeideas.fanatic.core

import kotlinx.coroutines.coroutineScope
import java.net.InetSocketAddress
import java.net.Socket

object InternetCheck {

    // Attributes to check connection to google
    private val PORT: Int = 53
    private val HOSTNAME: String = "8.8.8.8"
    private val TIMEOUT: Int = 1000

    suspend fun isNetworkAvailable(): Boolean = coroutineScope{
        return@coroutineScope try {
            val socket = Socket()
            val socketAddress = InetSocketAddress(HOSTNAME, PORT)
            socket.connect(socketAddress, TIMEOUT)
            socket.close()
            true
        } catch (e: Exception){
            false
        }
    }
}