package com.example.pinterest

import android.content.Intent
import android.media.Image
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_informacion.*

class Informacion : AppCompatActivity() {
    var posicion:Int?=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_informacion)

        val image:Imagenes?=this.intent.getParcelableExtra("imagen")
        posicion=this.intent.getIntExtra("posicion",0)

        txtInfo.text=image?.txtInfo
        imagenInfo.setImageResource(image!!.imageId)
        txtDescripcion.text = image?.descripcion
        likeCheck.isChecked=image?.like
    }

    override fun onBackPressed() {
        val intent = Intent(this,MainActivity::class.java)
        intent.putExtra("imagen",Imagenes(txtInfo.text.toString(),imagenInfo.id,txtDescripcion.text.toString(),likeCheck.isChecked))
        intent.putExtra("posicion",posicion)
        startActivity(intent)
    }
}
