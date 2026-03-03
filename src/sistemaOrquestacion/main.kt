package sistemaOrquestacion

fun main() {


    val debian = ImagenDebian("Debian-12", 101)
    val python = FuncionPython("ProcessData", 202)
    val go = MicroservicioGo("Auth-Service", 303)
    val node = WebApp("Frontend-Web", 404)
    val agente = AgenteSeguridad("CrowdStrike-Agent", 999)


    val orquestador1 = Orquestador()
    val orquestador2 = Orquestador()


    val k8s = ClusterKubernetes("K8s-Production", "eu-west-1", 12, "1.29")
    val lambda = ServerlessLambda("Resize-Trigger", "us-east-1", 512, 3.11)
    val vm = InstanciaVirtual("Legacy-Server", "us-east-3", "x86_64", "Ubuntu 22.04")


    orquestador1.agregarEntorno(k8s)
    orquestador1.agregarEntorno(lambda)
    orquestador2.agregarEntorno(vm)


    vm.desplegarArtefacto(go, orquestador2.verificarCompatibilidad(vm, go))


    vm.desplegarArtefacto(debian, orquestador2.verificarCompatibilidad(vm, debian))
    lambda.desplegarArtefacto(python, orquestador1.verificarCompatibilidad(lambda, python))
    k8s.desplegarArtefacto(go, orquestador1.verificarCompatibilidad(k8s, go))


    k8s.desplegarArtefacto(node, orquestador1.verificarCompatibilidad(k8s, node))


    k8s.desplegarArtefacto(agente, orquestador1.verificarCompatibilidad(k8s, agente))
    lambda.desplegarArtefacto(agente, orquestador1.verificarCompatibilidad(lambda, agente))
    vm.desplegarArtefacto(agente, orquestador2.verificarCompatibilidad(vm, agente))


    orquestador1.mostrarEntornos()
    orquestador2.mostrarEntornos()


    RegistroAuditoria.mostrarEventos()
}