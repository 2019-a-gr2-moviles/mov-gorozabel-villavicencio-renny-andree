package com.example.myapp3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_parce_label.*
import java.util.*

class ParceLabel : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parce_label)

        val renny: Usuario? = this.intent
            .getParcelableExtra<Usuario>("usuario")
        val mejillas:Mascota? = this.intent
            .getParcelableExtra("mascota")

        Log.i("parcelable","Nombre ${renny?.nombre}")
        Log.i("parcelable","Edad ${renny?.edad}")
        Log.i("parcelable","Fecha de Nacimiento ${renny?.fechaNacimiento.toString()}")
        Log.i("parcelable","Sueldo ${renny?.sueldo}")
        Log.i("parcelable","Mascota ${mejillas?.nombre}")

        btn_menu.setOnClickListener { irAMenuPrincipal() }

    }

    fun irAMenuPrincipal(){
        val intent = Intent(this,MainActivity::class.java)
        val tito = Usuario("Tito",20,Date(),293.12)
        intent.putExtra("usuario1",tito)
        startActivity(intent)
    }

}
