package com.example.examenmoviles.BDatos

import com.example.examenmoviles.interfaces.SistemaOperativo

class BDSistemaO{
    companion object {
        val LST_SO:ArrayList<SistemaOperativo> = ArrayList()
        var serial:Int=1
        var nombreUsuario:String=""

        fun guardarUsuario(nombre:String){
            nombreUsuario =nombre
        }
        fun agregarSO(so: SistemaOperativo):ArrayList<SistemaOperativo>{
            so.id= serial
            serial++
            LST_SO.add(so)
            return LST_SO
        }
        fun mostrarSO():List<SistemaOperativo>{
            return LST_SO
        }
        fun eliminarSO(id:Int){
            LST_SO.removeAll{it.id == id}
        }
        fun actualizarSO(so: SistemaOperativo){
            val indice = LST_SO.indexOfFirst { it.id == so.id }
            LST_SO[indice] = so
        }
    }
}