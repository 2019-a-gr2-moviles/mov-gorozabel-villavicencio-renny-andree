package com.example.myapp3

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_resultado_propio.*

class ResultadoPropioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado_propio)

        btn_devolverRespuesta.setOnClickListener {
            devolverRespuesta()
        }
    }
    fun devolverRespuesta(){
        val nombre = "Renny"
        val edad = 21

        val intentRes= Intent()

        intentRes.putExtra("nombreUsuario",nombre)
        intentRes.putExtra("edadUsuario",edad)
        this.setResult(
            RESULT_OK,
            intentRes
        )
        this.finish()
    }
}
