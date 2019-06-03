package com.example.examenmoviles.BDatos

import android.util.Log
import com.example.examenmoviles.interfaces.Aplicacion

class BDAplicacion{
    companion object {
        val LST_APLICACION:ArrayList<Aplicacion> = ArrayList()
        var serial:Int=1

        fun agregarAplicacion(app:Aplicacion):ArrayList<Aplicacion>{
            app.id = serial
            serial++
            LST_APLICACION.add(app)
            return LST_APLICACION
        }
        fun mostrarAplicacion(padreId:Int):List<Aplicacion>{
            val lstFiltradaAplicacion = LST_APLICACION.filter { it.sistemaOperativoId == padreId }
            return lstFiltradaAplicacion
        }
        fun eliminarAplicacion(id:Int){
            LST_APLICACION.removeAll{it.id == id}
        }
        fun actualizarAplicacion(app:Aplicacion){
            Log.i("IndiceActualizar",app.id.toString())
            val indice = LST_APLICACION.indexOfFirst { it.id == app.id }
            LST_APLICACION[indice] = app
        }
    }
}