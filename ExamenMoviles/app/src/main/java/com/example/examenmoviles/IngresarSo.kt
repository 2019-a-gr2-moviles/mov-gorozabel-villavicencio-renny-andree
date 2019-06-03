package com.example.examenmoviles

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.examenmoviles.BDatos.BDSistemaO
import com.example.examenmoviles.interfaces.SistemaOperativo
import kotlinx.android.synthetic.main.activity_ingresar_so.*
import java.util.*

class IngresarSo : AppCompatActivity() {
    var usuario:String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingresar_so)

        usuario = intent.getStringExtra("usuario").toString()
        bRegistrar.setOnClickListener { aceptarIngreso() }
        bCancelar.setOnClickListener { cancelarIngreso()}
    }

    fun cancelarIngreso(){
        val intentCancelar= Intent(this, MenuPrincipal::class.java)
        intentCancelar.putExtra("usuario", usuario)
        startActivity(intentCancelar)
    }

    fun aceptarIngreso(){
        val sistema= SistemaOperativo(
            id=null,
            nombre=tNombre.text.toString(),
            versionApi = tVersion.text.toString().toInt(),
            fechaLanzamiento = tFecha.text.toString(),
            pesoEnGigas = tGB.text.toString().toDouble(),
            instalado = checkBox2.isChecked
        )
        BDSistemaO.agregarSO(sistema)
        Toast.makeText(this, getString(R.string.msgRegistro)+" " +usuario, Toast.LENGTH_SHORT).show()
        val retorno = Intent(this, MenuPrincipal::class.java)
        retorno.putExtra("usuario", usuario)
        startActivity(retorno)
    }

    override fun onBackPressed() {

        val intentMenu = Intent(this, MenuPrincipal::class.java)
        intentMenu.putExtra("usuario", usuario)
        startActivity(intentMenu)
    }

}
