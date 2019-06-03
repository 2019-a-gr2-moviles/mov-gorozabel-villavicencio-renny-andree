package com.example.examenmoviles

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.examenmoviles.BDatos.BDAplicacion
import com.example.examenmoviles.interfaces.Aplicacion
import com.example.examenmoviles.interfaces.SistemaOperativo
import kotlinx.android.synthetic.main.activity_consultar_app.*

class ConsultarApp : AppCompatActivity() {
    var padreId : Int = 0
    var usuario :String = "";
    var soRespaldo : SistemaOperativo? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consultar_app)

        usuario = intent.getStringExtra("usuario").toString()
        soRespaldo = intent.getParcelableExtra<SistemaOperativo>("soRespaldo")
        padreId = intent.getIntExtra("padreId", -1)
        val adapter = ArrayAdapter<Aplicacion>(
            this,
            android.R.layout.simple_list_item_1,
            BDAplicacion.mostrarAplicacion(padreId)
        )
        lstApp.adapter = adapter
        lstApp.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val appSeleccionada = parent.getItemAtPosition(position) as Aplicacion
            val intentappSeleccionada = Intent(this, ActualizarApp::class.java)
            intentappSeleccionada.putExtra("usuario", usuario)
            intentappSeleccionada.putExtra("app", appSeleccionada)
            intentappSeleccionada.putExtra("soRespaldo", soRespaldo)
            startActivity(intentappSeleccionada)
        }
    }
}
