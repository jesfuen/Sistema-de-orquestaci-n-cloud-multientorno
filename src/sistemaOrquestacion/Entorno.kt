package sistemaOrquestacion

abstract class Entorno(val nombre: String, val region: String) {
    abstract fun desplegarArtefacto()
    open val listaArtefactos: MutableList<Artefacto> = mutableListOf()
}

class ClusterKubernetes(nombre: String, region: String, nodos: Int, version: String): Entorno(nombre, region) {
    override fun desplegarArtefacto() {
        TODO("Not yet implemented")
    }
}

class ServerlessLambda(nombre: String, region: String, memoria: Double, runtime: Double): Entorno(nombre, region) {
    override fun desplegarArtefacto() {
        TODO("Not yet implemented")
    }
}

class InstanciaVirtual(nombre: String, region: String, arquitectura: String, so: String): Entorno(nombre, region) {
    override fun desplegarArtefacto() {
        TODO("Not yet implemented")
    }
}