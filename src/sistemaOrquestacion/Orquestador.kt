package sistemaOrquestacion

// Se ha utilizado una clase ya que se pueden instanciar varios Orquestadores, debido a esto se descarta el uso de Singleton
class Orquestador {

    // Lista de Entornos
    val listaEntornos: MutableList<Entorno> = mutableListOf()

    // Agrega un Entorno a la lista a modo de registro
    fun agregarEntorno(entorno: Entorno) {
        listaEntornos.add(entorno)
    }

    // Muestra todos los entornos almacenados en el Sistema Cloud
    fun mostrarEntornos() {
        println("--- ESTADO ACTUAL DEL CLOUD ---")
        for (entorno in listaEntornos) {
            println("$entorno")
            for (artefacto in entorno.listaArtefactos) {
                println("- $artefacto")
            }
        }
        println()
    }

    // Comprobacion de que el hash es unico y si es compatible con el entorno al que se quiere conectar (La sintaxis de when ha sido refactorizada por el IDE)
    fun verificarCompatibilidad(entorno: Entorno, artefacto: Artefacto): Boolean {
        for (item in entorno.listaArtefactos) {
            if (item.hash == artefacto.hash) {
                println("[Error] El hash [HASH-${artefacto.hash} ya existe")
                return false
            }
        }

        return when (entorno) {
            is ClusterKubernetes if artefacto is CompatibleConK8s -> true
            is ServerlessLambda if artefacto is CompatibleConLambdas -> true
            is InstanciaVirtual if artefacto is CompatibleConVMs -> true
            else -> false
        }
    }
}