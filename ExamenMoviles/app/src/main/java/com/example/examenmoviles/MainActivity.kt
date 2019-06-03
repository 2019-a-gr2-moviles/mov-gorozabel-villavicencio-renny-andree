package com.example.examenmoviles

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_entrar.setOnClickListener {
            irAMenuPrincipal()
        }
    }

    fun irAMenuPrincipal(){
        val intent =Intent(this,MenuPrincipal::class.java)
        val inputNombre = inp_Nombre.text
        intent.putExtra("usuario",inputNombre.toString())
        startActivity(intent)
    }
}
