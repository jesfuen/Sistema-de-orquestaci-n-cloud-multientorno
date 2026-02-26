package sistemaOrquestacion

// Open class porque las clases hijas no necesitan definir el funcionamiento de desplegarArtefacto()
open class Entorno(val nombre: String, val region: String) {

    // Lista mutable para añadir artefactos para cada entorno
    val listaArtefactos: MutableList<Artefacto> = mutableListOf()

    // Funcion ya definida porque las tres clases únicamente se encargan de añadir a la lista los artefactos de la misma manera
    fun desplegarArtefacto(artefacto: Artefacto) {
        listaArtefactos.add(artefacto)
        println("[OK] Despliegue exitoso de ${artefacto.nombre} (${artefacto.tipo.nombre}) [HASH-${artefacto.hash}] en $nombre")
    }
}

// Clase hija de Entorno con atributos adicionales: nodos y version
class ClusterKubernetes(nombre: String, region: String, val nodos: Int, val version: String): Entorno(nombre, region)

// Clase hija de Entorno con atributos adicionales: memoria [MB] y runtime
class ServerlessLambda(nombre: String, region: String, val memoria: Double, val runtime: Double): Entorno(nombre, region)

// Clase hija de Entorno con atributos adicionales: arquitectura y so (Sistema Operativo)
class InstanciaVirtual(nombre: String, region: String, val arquitectura: String, val so: String): Entorno(nombre, region)