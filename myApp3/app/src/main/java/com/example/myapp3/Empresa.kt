package com.example.myapp3

import java.util.*

class Empresa(var id:Int,
              var nombre:String,
              var createdAt:Long,
              var updatedAt:Long,
              var usuarioEmpresa:ArrayList<UsuarioEmpresa>) {

    var fechaCreacion:Date
    var fechaActualizacion:Date
    init {
        fechaCreacion=Date(createdAt)
        fechaActualizacion=Date(updatedAt)
    }
}