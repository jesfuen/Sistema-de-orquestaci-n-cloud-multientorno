package sistemaOrquestacion

interface CompatibleConK8s
interface CompatibleConLambdas
interface CompatibleConVMs

// Se ha utilizado una data class ya que unicamente tiene atributos, no implementa ningun tipo de funcionalidad
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

