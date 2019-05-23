package com.example.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_actividad2.*

class Actividad2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actividad2)

        val nombre = intent.getStringExtra("nombre")
        val edad = intent.getIntExtra("edad",0)
        Log.i("intents","Nombre: $nombre")
        Log.i("intents","Edad: $edad")

        btn_Actividad_1.setOnClickListener {
            irAActividadDos()
        }
    }

    fun irAActividadDos() {
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NO_HISTORY
        startActivity(intent)
    }
}
