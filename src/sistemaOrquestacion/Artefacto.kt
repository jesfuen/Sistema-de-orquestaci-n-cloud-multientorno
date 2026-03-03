package sistemaOrquestacion

// Uso de interfaces para que los Artefactos tengan una relacion concreta con los Entornos
interface CompatibleConK8s // Compatibilidad con ClusterKubernetes
interface CompatibleConLambdas // Compatibilidad con ServerlessLambda
interface CompatibleConVMs // Compatibilidad con InstanciaVirtual

// Se ha utilizado una clase abtracta donde cada subclase debe especificar su tipo y no se debe poder instanciar directamente
abstract class Artefacto(val nombre: String, val hash: Int) {
    abstract val tipo: String
    override fun toString(): String = "$nombre ($tipo) [HASH-$hash]"
}

class ImagenDebian(nombre: String, hash: Int): Artefacto(nombre,hash), CompatibleConVMs {
    override val tipo = "Imagen Debian"
}

class FuncionPython(nombre: String, hash: Int): Artefacto(nombre,hash), CompatibleConLambdas {
    override val tipo = "Funcion Python"
}

class MicroservicioGo(nombre: String, hash: Int): Artefacto(nombre,hash), CompatibleConK8s {
    override val tipo = "Microservicio Go"
}


class WebApp(nombre: String, hash: Int): Artefacto(nombre,hash), CompatibleConLambdas, CompatibleConK8s {
    override val tipo = "Node.js"
}

class AgenteSeguridad(nombre: String, hash: Int): Artefacto(nombre,hash), CompatibleConLambdas, CompatibleConK8s, CompatibleConVMs {
    override val tipo = "Agente Seguridad"
}

