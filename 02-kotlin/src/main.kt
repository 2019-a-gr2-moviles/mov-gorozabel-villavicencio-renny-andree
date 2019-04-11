fun main(args : Array<String>){

    // Variables
    // ¿Qué es mutar? ¿Cambiar?
    // Mutables
    var nombre = "Renny"
    nombre = "Andree"
    //Inmutable
    val nombreI = "Renny"
    //nombreI = "Andree"

    //Tipos de Datos
    //val apellido = "Gorozabel"
    val apellido: String = "Gorozabel"
    val edad: Int = 21
    val sueldo: Double = 1.23
    val casado: Boolean = false
    val estudiante: Boolean = true
    val hijos = null

    /* Duck Typing
    *   Si parece un pato
    *   Si camina como un pato
    *   Si suena como pato
    *   Si vuela como pato
    *   ENTONCES ES UN PATO
     */

    // Condicionales
    if(apellido=="Gorozabel" && nombre=="Andree"){
        println("Verdadero")
    }else
        println("Falso")

    val tieneNombreYApellido = if (apellido!=null && nombre!=null) "ok" else "nOk"
    println(tieneNombreYApellido)

    estaJalado(0.0)
    estaJalado(1.0)
    estaJalado(7.0)
    estaJalado(10.0)



}


fun estaJalado(nota:Double){
    when (nota){
        7.0 ->{
            println("Pasaste con las justas")
        }
        10.0 ->{
            println("Genial :D Felicitaciones")
        }
        0.0 ->{
            println("Dios mio que vago!")
        }
        else ->{
            println("TU NOTA ES: ${nota}")
        }
    }
}
