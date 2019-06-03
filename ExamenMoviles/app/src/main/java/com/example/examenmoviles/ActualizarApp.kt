package com.example.examenmoviles

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.examenmoviles.BDatos.BDAplicacion
import com.example.examenmoviles.interfaces.Aplicacion
import com.example.examenmoviles.interfaces.SistemaOperativo
import kotlinx.android.synthetic.main.activity_actualizar_app.*
import java.util.*

class ActualizarApp : AppCompatActivity() {
    var id :Int = 0;
    var idPadre :Int = 0
    var usuario :String = "";
    var soRespaldo : SistemaOperativo? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actualizar_app)

        usuario = intent.getStringExtra("usuario").toString()
        val appRecibida = intent.getParcelableExtra<Aplicacion>("app")
        soRespaldo = intent.getParcelableExtra<SistemaOperativo>("soRespaldo")
        txtGB.setText(appRecibida.pesoEnGigas.toString())
        txtVersion.setText(appRecibida.version.toString())
        txtNombre.setText(appRecibida.nombre.toString())
        txtUrl.setText(appRecibida.urlDescarga.toString())
        txtFecha.setText(appRecibida.fechaLanzamiento.toString())
        txtCosto.setText(appRecibida.costo.toString())
        id = appRecibida.id.toString().toInt()
        idPadre = appRecibida.sistemaOperativoId.toString().toInt()
        botonActualizar.setOnClickListener { actualizarApp() }
        botonEliminar.setOnClickListener { eliminarApp() }
    }
    fun actualizarApp(){
        val app = Aplicacion(
            id = id,
            pesoEnGigas = txtGB.text.toString().toDouble(),
            version = txtVersion.text.toString().toInt(),
            nombre = txtNombre.text.toString(),
            urlDescarga = txtUrl.text.toString(),
            fechaLanzamiento = txtFecha.toString(),
            costo = txtCosto.text.toString().toDouble(),
            sistemaOperativoId = idPadre
        )
        BDAplicacion.actualizarAplicacion(app)
        Toast.makeText(this, getString(R.string.msgActualizado)+" "+usuario, Toast.LENGTH_SHORT).show()
        val retorno = Intent(this, ActualizarSO::class.java)
        retorno.putExtra("usuario", usuario)
        retorno.putExtra("Sistema", soRespaldo)
        startActivity(retorno)
    }
    fun eliminarApp(){
        BDAplicacion.eliminarAplicacion(id)
        Toast.makeText(this, getString(R.string.msgEliminado)+" "+usuario, Toast.LENGTH_SHORT).show()
        val retorno = Intent(this, ActualizarSO::class.java)
        retorno.putExtra("usuario", usuario)
        retorno.putExtra("Sistema", soRespaldo)
        startActivity(retorno)
    }
}
