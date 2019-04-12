import java.util.*

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

    holaMundo("Renny")
    holaMundoAvanzado(12.3)
    val total=sumarDosNumeros(1,4)
    println(total)

    val arregloCumpleanos = intArrayOf(9,9,97)
    var arregloTodo = arrayOf(1,"asd",10.2,true)


    arregloCumpleanos[0]=5
    arregloCumpleanos.set(0,5)

    arregloTodo = arrayOf(5,2,3,4)

    val notas = arrayListOf(1,2,3,4,5,6)

    // FOR EACH -> Itera el arreglo
    notas.forEachIndexed{indice, nota ->
        println("Indice: $indice")
        println("Nota: $nota")

        //return Unit
    }


    val notas2 = notas.map { nota ->
       when(nota%2){
           0->{
               nota+1
           }
           else->{
           nota+2
       }
       }
    }

    val respuestaFilter = notas.filter {
        it in 1..4
    }.map {
        it *2
    }

    respuestaFilter.forEach{
        println(it)
    }

    notas2.forEach{
        println("Notas 2: $it")
    }

    val novias = arrayListOf(1,2,3,4,5)
    val respuestaNovia = novias.any{
        it == 3
    }
    println(respuestaNovia)

    val tazos = arrayListOf(1,2,3,4,5,6,7)
    val respuestaTazos = tazos.all {
        it > 1
    }

    println(respuestaTazos)

    val totalTazos = tazos.reduce{valorAcumulado,tazo ->
        valorAcumulado + tazo
    }

    println(totalTazos)

}


fun estaJalado(nota:Double):Double{
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
    return nota
}



fun holaMundo(mensaje:String): Unit{
    println("Mensaje: $mensaje")
}

fun holaMundoAvanzado(mensaje:Any):Unit{
    println("Mensaje Avanzado: $mensaje")
}

fun sumarDosNumeros(numeroUno:Int,numeroDos:Int):Int{
    return numeroUno+numeroDos
}