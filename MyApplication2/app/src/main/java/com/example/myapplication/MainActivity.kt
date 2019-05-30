package com.example.myapplication

import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NO_HISTORY
import android.content.Intent.FLAG_ACTIVITY_SINGLE_TOP
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_Actividad_2.setOnClickListener {
            irAActividadDos()
        }
    }

    fun irAActividadDos(){
        val intent = Intent(this,Actividad2::class.java)
        intent.flags = FLAG_ACTIVITY_NO_HISTORY
        intent.putExtra("nombre","Renny")
        intent.putExtra("edad",21)

        startActivity(intent)
    }


}
