package sistemaOrquestacion

class Orquestador {
    val listaEntornos: MutableList<Entorno> = mutableListOf()

    fun agregarEntorno(entorno: Entorno) {
        listaEntornos.add(entorno)
    }

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