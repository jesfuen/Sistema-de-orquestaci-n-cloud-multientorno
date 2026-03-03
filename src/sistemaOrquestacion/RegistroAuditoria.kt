package sistemaOrquestacion

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

object RegistroAuditoria {

    val eventos: MutableList<String> = mutableListOf()
    private val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")

    fun registrarExito(entorno: Entorno, artefacto: Artefacto) {
        val fecha = LocalDateTime.now().format(formatter)
        eventos.add("[EXITO] Entorno: ${entorno.nombre} | Artefacto: ${artefacto.nombre} | Fecha: $fecha")
    }

    fun registrarError(entorno: Entorno, artefacto: Artefacto) {
        val fecha = LocalDateTime.now().format(formatter)
        eventos.add("[ERROR] Entorno: ${entorno.nombre} | Artefacto: ${artefacto.nombre} | Fecha: $fecha")
    }

    fun mostrarEventos() {
        println("--- REGISTRO DE AUDITORIA DE DESPLIEGUES ---")
        for (evento in eventos) {
            println(evento)
        }
    }
}