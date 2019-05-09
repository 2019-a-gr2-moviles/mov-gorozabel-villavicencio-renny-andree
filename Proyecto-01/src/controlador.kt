import java.io.*
import java.nio.Buffer
import java.util.*
import javax.swing.JOptionPane
import kotlin.collections.ArrayList

fun control(registro: String,action: String,oldRegistro:String = "None"){
    val file = File("registros.txt")
    checkAction(action,registro,oldRegistro)
}

fun writeFile(str:String,tipo:String ="None"):String{
    if(str=="") return "Registro cancelado"
    try{
        val fo = FileWriter("registros.txt",true)
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

fun readFile(registro: String,action: String):String{
    var arr=""
    try{
        val fin = FileReader("registros.txt")
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

fun actualizar(){
    val registroN=JOptionPane.showInputDialog(null,"Ingrese el nombre del registro a actualizar")
    val res=readFile(registroN,"Consultar")
    if(!res.equals("No existen registros")){
        consultar(res,"Actualizar")
    } else
        JOptionPane.showMessageDialog(null,res)
}

fun actualizarAux(registro:String,oldRegistro: String){
    val res = readFile(oldRegistro,"Consultar")
    eliminar(res)
    writeFile(registro)
    JOptionPane.showMessageDialog(null,"Registro Actualizado")
}

fun eliminarTodo():Boolean{
    try{
        val fo = FileWriter("registros.txt",false)
        fo.write("")
        fo.close()
        return true
    }catch (ex:Exception) {
        print(ex.message)
    }
    return false

}

fun eliminar(registroN:String):Boolean{
    val res=readFile(registroN,"Consultar")
    if(!res.equals("No existen registros")){
        var nuevo=readFile("Nada","ConsultarAll")
        nuevo = nuevo.replace(res+"\n","")
        if(eliminarTodo()){
            writeFile(nuevo,"Sipo")
            return true
        }

    }
    return false
}

fun checkAction(action:String,registro:String,oldRegistro: String){
        var res=""
        println("Estamo checkAtion: "+action)
        when(action){
            "Registro"->{
                res=writeFile(registro)
                JOptionPane.showMessageDialog(null,res)
            }
            "ConsultarAll"->{
                res=readFile(registro,action)
                consultar(res,action)
            }
            "Consultar"->{
                res=readFile(registro,action)
                if(!res.equals("No existen registros"))
                    consultar(res,action)
                else
                    JOptionPane.showMessageDialog(null,res)
            }
            "Actualizar"->{
                actualizar()
            }
            "ActualizarAux"->{
                actualizarAux(registro,oldRegistro)
            }
            "Eliminar"->{
                val registroN=JOptionPane.showInputDialog(null,"Ingrese el nombre del registro a actualizar")
                if(eliminar(registroN))
                    JOptionPane.showMessageDialog(null,"Eliminado con exito")
                else
                    JOptionPane.showMessageDialog(null,"Hubo un problema con la eliminación")
            }
            "EliminarTodo"->{
                if(eliminarTodo())
                    JOptionPane.showMessageDialog(null,"Eliminado con exito")
                else
                    JOptionPane.showMessageDialog(null,"Hubo un problema con la eliminación")

            }
        }
}

