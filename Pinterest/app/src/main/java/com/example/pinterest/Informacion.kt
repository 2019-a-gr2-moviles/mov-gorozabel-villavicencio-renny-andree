package com.example.pinterest

import android.content.Intent
import android.media.Image
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_informacion.*

class Informacion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_informacion)

        val data=this.intent.getParcelableArrayListExtra<Imagenes>("data")


        val image:Imagenes?=this.intent.getParcelableExtra("imagen")
        val posicion=this.intent.getIntExtra("posicion",0)

        val elemento = data[posicion]

        txtInfo.text=elemento?.txtInfo
        imagenInfo.setImageResource(elemento!!.imageId)
        txtDescripcion.text = elemento?.descripcion
        likeCheck.isChecked=elemento!!.like
    }

    override fun onBackPressed() {
        val data = this.intent.getParcelableArrayListExtra<Imagenes>("data")
        val posicion = this.intent.getIntExtra("posicion",-1)
        data[posicion].like=likeCheck.isChecked
        val intent = Intent(this,MainActivity::class.java)
        intent.putParcelableArrayListExtra("datos",data)
        intent.putExtra("envio",0)
        startActivity(intent)
    }
}
