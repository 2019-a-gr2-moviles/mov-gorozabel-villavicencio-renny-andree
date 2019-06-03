package com.example.examenmoviles

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_menu_principal.*

class MenuPrincipal : AppCompatActivity() {
    var usuario :String = "";
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_principal)
        usuario = intent.getStringExtra("usuario").toString()
        btn_GestionarPapas.setOnClickListener {gestionarSo() }
        btn_Crear.setOnClickListener{ crearSo()}
    }
    fun gestionarSo(){
        val intentGestionarEquipo = Intent(this, GestionPapas::class.java)
        intentGestionarEquipo.putExtra("usuario", usuario)
        startActivity(intentGestionarEquipo)
    }

    fun crearSo(){
        val intentCrearEquipo = Intent(this, IngresarSo::class.java)
        intentCrearEquipo.putExtra("usuario", usuario)
        startActivity(intentCrearEquipo)
    }
    override fun onBackPressed() {
        val intentMenu = Intent(this, MainActivity::class.java)

        startActivity(intentMenu)
    }


}
