package sistemaOrquestacion

class Orquestador {
    fun mostrarEntornos() {
        TODO("Not implemented yet")
    }

    fun verificarCompatibilidad(entorno: Entorno, artefacto: Artefacto): Boolean {
        for (i in entorno.listaArtefactos) {
            if (i.hash == artefacto.hash) {
                println("[ERROR] No se puede desplegar el artefacto, hash duplicado: [HASH-${artefacto.hash}]")
                return false
            }
        }

        return when (artefacto.tipo) {
            TIPO.IMAGENDEBIAN if entorno is InstanciaVirtual -> true
            TIPO.AGENTESEGURIDAD -> true
            TIPO.FUNCIONPYTHON if entorno is ServerlessLambda -> true
            TIPO.MICORSERVICIOGO if entorno is ClusterKubernetes -> true
            TIPO.WEBAPP if (entorno is ServerlessLambda || entorno is ClusterKubernetes) -> true
            else -> false
        }
    }

    fun registroAuditoria() {
        TODO("Not implemented yet")
    }
}