package com.example.examenmoviles

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.examenmoviles.BDatos.BDSistemaO
import com.example.examenmoviles.interfaces.SistemaOperativo
import kotlinx.android.synthetic.main.activity_actualizar_so.*
import java.util.*

class ActualizarSO : AppCompatActivity() {
    var padreId:Int=0
    var usuario:String=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actualizar_so)
        usuario = intent.getStringExtra("usuario").toString()
        val sistemaRecibido = intent.getParcelableExtra<SistemaOperativo>("Sistema")
        text_Nombre.setText(sistemaRecibido.nombre.toString())
        textVersion.setText(sistemaRecibido.versionApi.toString())
        textFecha.setText(sistemaRecibido.fechaLanzamiento.toString())
        textGB.setText(sistemaRecibido.pesoEnGigas.toString())
        if(sistemaRecibido.instalado){
            checkBox.setChecked(true)
        }
        if(!sistemaRecibido.instalado){
            checkBox.setChecked(false)
        }

        padreId = sistemaRecibido.id!!
        btnActualizar.setOnClickListener { actualizarSo() }
        btnEliminar.setOnClickListener { eliminarSO() }
        btnCrearApp.setOnClickListener { crearApp() }
        btnGestionarApp.setOnClickListener { gestionarApp() }
        btnRetorno.setOnClickListener { retorno() }
    }
    fun actualizarSo(){
        val soActualizado = SistemaOperativo(
            id=padreId,
            nombre=text_Nombre.text.toString(),
            versionApi = textVersion.text.toString().toInt(),
            fechaLanzamiento = Date(textFecha.text.toString()),
            pesoEnGigas = textGB.text.toString().toDouble(),
            instalado = checkBox.isChecked
        )
        BDSistemaO.actualizarSO(soActualizado)
        Toast.makeText(this,"Actualización Exitosa "+usuario,Toast.LENGTH_SHORT).show()
        val regresar = Intent(this,MenuPrincipal::class.java)
        regresar.putExtra("usuario",usuario)
        startActivity(regresar)
    }
    fun eliminarSO(){
        BDSistemaO.eliminarSO(padreId);
        Toast.makeText(this, "Eliminación exitosa "+usuario, Toast.LENGTH_SHORT).show()
        val regreso = Intent(this, MenuPrincipal::class.java)
        regreso.putExtra("usuario", usuario)
        startActivity(regreso)
    }
    fun crearApp(){
        val so = SistemaOperativo(
            id=padreId,
            nombre=text_Nombre.text.toString(),
            versionApi = textVersion.text.toString().toInt(),
            fechaLanzamiento = Date(textFecha.text.toString()),
            pesoEnGigas = textGB.text.toString().toDouble(),
            instalado = checkBox.isChecked
        )
        val avanzar = Intent(this,IngresarApp::class.java)
        avanzar.putExtra("padreId", padreId)
        avanzar.putExtra("soIngresado", so)
        avanzar.putExtra("usuario",usuario)
        startActivity(avanzar)
    }
    fun gestionarApp(){
        val sistema = SistemaOperativo(
            id = padreId,
            nombre = text_Nombre.text.toString(),
            versionApi = textVersion.text.toString().toInt(),
            fechaLanzamiento = Date(textFecha.text.toString()),
            pesoEnGigas = textGB.text.toString().toDouble(),
            instalado = checkBox.isChecked
        )
        val retorno = Intent(this, ConsultarApp::class.java)
        retorno.putExtra("usuario", usuario)
        retorno.putExtra("padreId", padreId)
        retorno.putExtra("soRespaldo", sistema)
        startActivity(retorno)
    }

  fun retorno(){
      val retorno = Intent(this, MenuPrincipal::class.java)
      retorno.putExtra("usuario", usuario)
      startActivity(retorno)
  }

}
