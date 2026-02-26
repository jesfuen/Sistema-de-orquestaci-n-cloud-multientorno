package sistemaOrquestacion

// Se ha utilizado una data class ya que unicamente tiene atributos, no implementa ningun tipo de funcionalidad
data class Artefacto(val nombre: String, val hash: Int, val tipo: TIPO)


// Clase enumerada para cada tipo de artefacto, atributo nombre para mostrar por pantalla
enum class TIPO(val nombre: String) {
    IMAGENDEBIAN("Imagen Debian"),
    FUNCIONPYTHON("Funcion Python"),
    MICORSERVICIOGO("Microservicio Go"),
    WEBAPP("Node.js"),
    AGENTESEGURIDAD("Agente Seguridad")
}