package com.example.examenmoviles

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.examenmoviles.BDatos.BDAplicacion
import com.example.examenmoviles.interfaces.Aplicacion
import com.example.examenmoviles.interfaces.SistemaOperativo
import kotlinx.android.synthetic.main.activity_actualizar_so.*
import kotlinx.android.synthetic.main.activity_ingresar_app.*
import java.util.*

class IngresarApp : AppCompatActivity() {
    var padreId : Int = 0
    var usuario :String = "";
    var soIngresado : SistemaOperativo? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingresar_app)

        usuario = intent.getStringExtra("usuario").toString()
        soIngresado = intent.getParcelableExtra<SistemaOperativo>("soIngresado")
        padreId = intent.getIntExtra("padreId", -1)
        btnRegistrar.setOnClickListener { guardarApp() }
    }
    fun guardarApp(){
        val app = Aplicacion(
            id = null,
            pesoEnGigas = text_GB.text.toString().toDouble(),
            version = text_Version.text.toString().toInt(),
            nombre = textNombre.text.toString(),
            urlDescarga = text_URL.text.toString(),
            fechaLanzamiento = text_Fecha.text.toString(),
            costo = textCosto.text.toString().toDouble(),
            sistemaOperativoId = padreId
        )
        BDAplicacion.agregarAplicacion(app)
        Toast.makeText(this, "App creada exitosamente "+usuario, Toast.LENGTH_SHORT).show()
        val retorno = Intent(this, ActualizarSO::class.java)
        retorno.putExtra("usuario", usuario)
        retorno.putExtra("Sistema", soIngresado)
        startActivity(retorno)
    }
}
