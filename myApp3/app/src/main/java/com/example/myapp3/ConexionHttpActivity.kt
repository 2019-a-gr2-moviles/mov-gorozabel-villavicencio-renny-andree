package com.example.myapp3

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.beust.klaxon.Klaxon
import com.github.kittinunf.result.Result.*
import com.github.kittinunf.fuel.httpGet
import java.util.*

class ConexionHttpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conexion_http)

        val json = """
            [
                {
                "usuarioEmpresa": [
                    {
                        "createdAt": 1561062027121,
                        "updatedAt": 1561150731617,
                        "id": 1,
                        "nombre": "Renny Gorozabel",
                        "fkEmpresa": 1
                    }
                ],
                  "createdAt": 1561663617636,
                  "updatedAt": 1561663617636,
                  "id": 1,
                  "nombre": "Manticore Labs"
                }
            ]
        """.trimIndent()

        try{
            val empresaInstancia = Klaxon()
                .parseArray<Empresa>(json)
            empresaInstancia?.forEach {
                Log.i("http",
                    "Nombre ${it.nombre}")

                Log.i("http",
                    "Id ${it.id}")

                Log.i("http",
                    "Fecha ${it.fechaCreacion}")

                it.usuarioEmpresa.forEach {
                    Log.i("http",
                        "Nombre ${it.nombre}")
                    Log.i("http",
                        "FK ${it.fkEmpresa}")
                }

            }
        } catch (e:Exception){
            Log.i("http","${e.message}")
            Log.i("http",
                "Error instanciando la empresa")
        }


        val url = "http://172.31.104.113:1337/empresa/2"

        url.httpGet()
            .responseString { request, response, result ->
                when (result) {
                    is Failure -> {
                        val ex = result.getException()
                        Log.i("HTTP-GET-ERROR","Fallo: ${ex.message}")
                    }
                    is Success -> {
                        val data = result.get()
                        Log.i("HTTP-GET","DATOS: ${data}")
                        val empresaParseada = Klaxon().parse<Empresa>(data)
                        if(empresaParseada!=null){
                            Log.i("http","iiiiiiiiiiiiiiiiiiiiiiiiii")
                            Log.i("http","${empresaParseada.nombre}")
                            Log.i("http","${empresaParseada.id}")
                        }
                    }
                }
            }


    }


}
