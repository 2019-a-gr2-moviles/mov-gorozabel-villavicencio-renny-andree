package com.example.myapp3

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import kotlinx.android.synthetic.main.activity_respuesta.*

class Respuesta : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_respuesta)

        btn_enviarIntentR.setOnClickListener { enviarIntentConRespuesta() }
        btn_devRespuesta.setOnClickListener { enviarIntentConRespuestaPropia() }

    }

    fun enviarIntentConRespuestaPropia(){
        val intentRespuestaPropia = Intent(
            this,
            ResultadoPropioActivity::class.java
        )
        this.startActivityForResult(intentRespuestaPropia,305)
    }

    fun enviarIntentConRespuesta(){
        val intentConRespuesta= Intent(
            Intent.ACTION_PICK,
            ContactsContract.CommonDataKinds.Phone.CONTENT_URI
            )
        this.startActivityForResult(intentConRespuesta,304)
    }

    override fun onActivityResult(requestCode: Int,
                                  resultCode: Int,
                                  data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when(resultCode){
            RESULT_OK ->{
                Log.i("intent-respuesta","LO LOGRAMOS!! ${Activity.RESULT_OK}")

                when(requestCode){
                    304->{
                        Log.i("intent-respuesta","To'o bien CONTACTO LLEGO!!")
                        val uri = data?.data
                        val cursor = contentResolver.query(
                            uri,
                            null,
                            null,
                            null,
                            null)
                        cursor?.moveToFirst()

                        val indiceTelefono = cursor.getColumnIndex(
                            ContactsContract.CommonDataKinds.Phone.NUMBER
                        )
                        val telefono = cursor?.getString(indiceTelefono)

                        Log.i("intent-respuesta","El telefono es: $telefono")

                        cursor?.close()
                    }
                    305->{
                        val nombre = data?.getStringExtra("nombreUsuario")
                        val edad = data?.getIntExtra("edadUsuario",0)
                        Log.i("intent-respuesta","Nombre: $nombre")
                        Log.i("intent-respuesta","Edad: $edad")
                    }

                }
            }
            Activity.RESULT_CANCELED->{
                Log.i("intent-respuesta","No escogio ese man, ya danio la App")
            }
        }
    }
}
