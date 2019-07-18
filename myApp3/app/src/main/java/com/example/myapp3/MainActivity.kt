package com.example.myapp3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_parcelabel.setOnClickListener { irAParcelabel() }
        btn_Adapter.setOnClickListener { irAAdapter() }
        btn_recycleview.setOnClickListener { irARecycleView() }
        btn_respuesta.setOnClickListener { irARespuesta() }
        btn_http.setOnClickListener { irAHttp() }
        btn_mapa.setOnClickListener{ irAMapa() }
        btn_frag.setOnClickListener{irFragmentos()}
        btnVida.setOnClickListener{irCicloVida()}


        val tito: Usuario? = this.intent
            .getParcelableExtra<Usuario>("usuario1")

        Log.i("parcelable","Nombre ${tito?.nombre}")
        Log.i("parcelable","Edad ${tito?.edad}")
        Log.i("parcelable","Fecha Nacimiento ${tito?.fechaNacimiento.toString()}")
        Log.i("parcelable","Sueldo ${tito?.sueldo}")

    }

    fun irFragmentos(){
        val intent = Intent(this,actividadFragmento::class.java)
        startActivity(intent)
    }

    fun irAMapa(){
        val intent = Intent(this,MapsActivity::class.java)
        startActivity(intent)
    }
    fun irCicloVida(){
        val intent = Intent(
            this,CicloVidaActivity::class.java
        )
        startActivity(intent)
    }

    fun irARecycleView(){
        val intent = Intent(this,ReciclerViewActivity::class.java)
        startActivity(intent)
    }

    fun irAParcelabel(){
        val intentExplicito = Intent(this,ParceLabel::class.java)
        val renny = Usuario("Renny",21,Date(),193.4)
        intentExplicito.putExtra("usuario",renny)

        val mejillas = Mascota("Mejillitas",renny);
        intentExplicito.putExtra("mascota",mejillas);

        startActivity(intentExplicito);
    }

    fun irAAdapter(){
        val intent = Intent(this,ListViewActivity::class.java)
        startActivity(intent)
    }

    fun irARespuesta(){
        val intent = Intent(this,Respuesta::class.java)
        startActivity(intent)
    }

    fun irAHttp(){
        val intent = Intent(this,ConexionHttpActivity::class.java)
        startActivity(intent)
    }
}
