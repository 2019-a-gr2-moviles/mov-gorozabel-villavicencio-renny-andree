package com.example.examenmoviles

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.R.string.cancel
import android.content.DialogInterface
import android.support.v7.app.AlertDialog


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
    override fun onBackPressed() {
        val alertDialogBuilder = AlertDialog.Builder(this)
        alertDialogBuilder.setTitle("Exit Application?")
        alertDialogBuilder
            .setMessage("Click yes to exit!")
            .setCancelable(false)
            .setPositiveButton("Yes",
                DialogInterface.OnClickListener { dialog, id ->
                    moveTaskToBack(true)
                    android.os.Process.killProcess(android.os.Process.myPid())
                    System.exit(1)
                })

            .setNegativeButton("No", DialogInterface.OnClickListener { dialog, id -> dialog.cancel() })

        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }
}
