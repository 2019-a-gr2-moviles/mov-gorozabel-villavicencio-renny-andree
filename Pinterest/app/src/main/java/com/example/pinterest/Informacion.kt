package com.example.pinterest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_informacion.*

class Informacion : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_informacion)

        val image:Imagenes?=this.intent.getParcelableExtra("imagen")

        txtInfo.text=image?.txtInfo
        imagenInfo.setImageResource(image!!.imageId)
        txtDescripcion.text = image?.descripcion

    }
}
