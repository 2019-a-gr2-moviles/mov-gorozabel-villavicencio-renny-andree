import java.io.*
import java.nio.Buffer
import java.util.*
import javax.swing.JOptionPane
import kotlin.collections.ArrayList

fun controlEvento(registro: String,action: String,oldRegistro:String = "None"){
    val file = File("eventos.txt")
    checkActionEvento(action,registro,oldRegistro)
}

fun writeFileEv(str:String,tipo:String ="None"):String{
    if(str=="") return "Registro cancelado"
    try{
        val fo = FileWriter("eventos.txt",true)
        if(tipo.equals("None"))
            fo.write(str+"\n")
        else
            fo.write(str)
        fo.close()
        return "Registro Exitoso"
    }catch (ex:Exception) {
        print(ex.message)
    }
    return "Error"

}

fun readFileEv(registro: String,action: String):String{
    var arr=""
    try{
        val fin = FileReader("eventos.txt")
        var c:Int?
        do{
            c=fin.read()
            arr+=c.toChar()
        }while(c!=-1)
    }catch (ex:Exception){
        println(ex.message)
    }
    arr=arr.substring(0,arr.length-1)
    if(action.equals("Consultar")){
        if(registro=="") return arr
        val inicio=arr.indexOf(registro)
        if(inicio!=-1){
            var aBuscar = registro+arr.substringAfter(registro)
            aBuscar = aBuscar.substringBefore("\n")
            arr=aBuscar
        }else{
            arr="No existen registros"
        }

    }
    return arr
}

fun actualizarEv(){
    val registroN=JOptionPane.showInputDialog(null,"Ingrese el nombre del registro a actualizar")
    val res=readFileEv(registroN,"Consultar")
    if(!res.equals("No existen registros")){
        consultar(res,"Actualizar")
    } else
        JOptionPane.showMessageDialog(null,res)
}

fun actualizarAuxEv(registro:String,oldRegistro: String){
    val res = readFileEv(oldRegistro,"Consultar")
    eliminarEv(res)
    writeFileEv(registro)
    JOptionPane.showMessageDialog(null,"Registro Actualizado")
}

fun eliminarTodoEv():Boolean{
    try{
        val fo = FileWriter("eventos.txt",false)
        fo.write("")
        fo.close()
        return true
    }catch (ex:Exception) {
        print(ex.message)
    }
    return false

}

fun eliminarEv(registroN:String):Boolean{
    val res=readFileEv(registroN,"Consultar")
    if(!res.equals("No existen registros")){
        var nuevo=readFileEv("Nada","ConsultarAll")
        nuevo = nuevo.replace(res+"\n","")
        if(eliminarTodoEv()){
            writeFileEv(nuevo,"Sipo")
            return true
        }

    }
    return false
}

fun checkActionEvento(action:String,registro:String,oldRegistro: String){
    var res=""
    println("Estamo checkAtion: "+action)
    when(action){
        "Registro"->{
            res=writeFileEv(registro)
            JOptionPane.showMessageDialog(null,res)
        }
        "ConsultarAll"->{
            res=readFileEv(registro,action)
            consultar(res,action)
        }
        "Consultar"->{
            res=readFileEv(registro,action)
            if(!res.equals("No existen registros"))
                consultarEvent(res,action)
            else
                JOptionPane.showMessageDialog(null,res)
        }
        "Actualizar"->{
            actualizarEv()
        }
        "ActualizarAux"->{
            actualizarAuxEv(registro,oldRegistro)
        }
        "Eliminar"->{
            val registroN=JOptionPane.showInputDialog(null,"Ingrese el nombre del registro a actualizar")
            if(eliminarEv(registroN))
                JOptionPane.showMessageDialog(null,"Eliminado con exito")
            else
                JOptionPane.showMessageDialog(null,"Hubo un problema con la eliminación")
        }
        "EliminarTodo"->{
            if(eliminarTodoEv())
                JOptionPane.showMessageDialog(null,"Eliminado con exito")
            else
                JOptionPane.showMessageDialog(null,"Hubo un problema con la eliminación")

        }
    }
}

