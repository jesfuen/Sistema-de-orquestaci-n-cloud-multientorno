package sistemaOrquestacion

// Abstract class ya que no se debe instanciar un objeto de tipo Entorno
// Abstract val tipo para que cada clase defina a que tipo pertenece
// Override de toString para mostrar un mensaje personalizado de cada tipo de entorno
abstract class Entorno(val nombre: String, val region: String) {

    // Lista mutable para añadir artefactos para cada entorno
    val listaArtefactos: MutableList<Artefacto> = mutableListOf()
    abstract val tipo: String

    // Funcion ya definida porque las tres clases únicamente se encargan de añadir a la lista los artefactos de la misma manera
    fun desplegarArtefacto(artefacto: Artefacto, compatible: Boolean) {
        if (!compatible) {
            println("[Error] Despliegue incompatible de $artefacto en Entorno $tipo")
            RegistroAuditoria.registrarError(this, artefacto)
        } else {
            listaArtefactos.add(artefacto)
            println("[OK] Despliegue exitoso de $artefacto en Entorno $tipo")
            RegistroAuditoria.registrarExito(this, artefacto)
        }

    }
}

// Clase hija de Entorno con atributos adicionales: nodos y version
class ClusterKubernetes(nombre: String, region: String, val nodos: Int, val version: String): Entorno(nombre, region) {
    override val tipo = "Kubernetes"
    override fun toString(): String = "$nombre ($tipo [$region, $nodos nodos, version: $version])"
}

// Clase hija de Entorno con atributos adicionales: memoria [MB] y runtime
class ServerlessLambda(nombre: String, region: String, val memoria: Int, val runtime: Double): Entorno(nombre, region) {
    override val tipo = "Lambda"
    override fun toString(): String = "$nombre ($tipo [$region, ${memoria}MB, runtime: $runtime])"
}

// Clase hija de Entorno con atributos adicionales: arquitectura y so (Sistema Operativo)
class InstanciaVirtual(nombre: String, region: String, val arquitectura: String, val so: String): Entorno(nombre, region) {
    override val tipo = "VM"
    override fun toString(): String = "$nombre ($tipo [$region, Arquitectura: $arquitectura, SO: $so])"
}