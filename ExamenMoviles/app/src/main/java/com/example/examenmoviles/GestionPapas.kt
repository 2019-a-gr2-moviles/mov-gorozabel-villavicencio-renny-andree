package com.example.examenmoviles

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.examenmoviles.BDatos.BDSistemaO
import com.example.examenmoviles.interfaces.SistemaOperativo
import kotlinx.android.synthetic.main.activity_gestion_papas.*

class GestionPapas : AppCompatActivity() {
    var usuario:String=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gestion_papas)

        usuario = intent.getStringExtra("usuario").toString()
        Log.i("Simon",BDSistemaO.mostrarSO().toString())
        val adapter = ArrayAdapter<SistemaOperativo>(
            this,
            android.R.layout.simple_list_item_1,
            BDSistemaO.mostrarSO()
        )
        lstView.adapter = adapter
        lstView.onItemClickListener = AdapterView.OnItemClickListener{parent,view,position,id ->
            val soSeleccionado = parent.getItemAtPosition(position) as SistemaOperativo
            val intentSoSeleccionado = Intent(this,ActualizarSO::class.java)
            intentSoSeleccionado.putExtra("Sistema",soSeleccionado)
            intentSoSeleccionado.putExtra("usuario",usuario)
            startActivity(intentSoSeleccionado)
        }

    }
    override fun onBackPressed() {

        val intentMenu = Intent(this, MenuPrincipal::class.java)
        intentMenu.putExtra("usuario", usuario)
        startActivity(intentMenu)
    }

}
