package com.example.myapp3

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class PersonasAdaptador(
    private val listaPersonas: List<Persona>,
    private val contexto: ReciclerViewActivity,
    private val recyclerView: RecyclerView
):
    RecyclerView.Adapter<PersonasAdaptador.MyViewHolder>() {
    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var nombreTextView: TextView
        var cedulaTextView:TextView
        var accionBoton:Button

        init{
            nombreTextView = view.findViewById(R.id.txtNombre) as TextView
            cedulaTextView = view.findViewById(R.id.txtCedula) as TextView
            accionBoton = view.findViewById(R.id.btnAccion) as Button

            val layout = view.findViewById(R.id.linearLayout) as LinearLayout

            layout
                .setOnClickListener{
                    Log.i("recycler-view","Layout presionado")
                }
            accionBoton.setOnClickListener {
                nombreTextView.text = "NANI?!"
                contexto.cambiarNombreTextView("Me cambiaron")

                val nuevasPersonas = arrayListOf<Persona>()

                nuevasPersonas.add(Persona("Felipe","1928475930"))
                nuevasPersonas.add(Persona("Juan","1495827364"))
                nuevasPersonas.add(Persona("Miguel","2947583668"))

                contexto.iniciarRecylerView(nuevasPersonas,contexto,recyclerView)
            }
        }
    }
    // Esta funcion define el template que vamos a utilizar
    // El template esta en la carpeta de res/layout
    override fun onCreateViewHolder(
        p0: ViewGroup,
        p1: Int):
            PersonasAdaptador.MyViewHolder {
        val itemView = LayoutInflater
            .from(p0.context)
            .inflate(
                R.layout.layout,
                p0,
                false
            )

        return MyViewHolder(itemView)
    }

    // Devuelve el # de items de la lista
    override fun getItemCount(): Int {
        return listaPersonas.size
    }

    override fun onBindViewHolder(myViewHolder: PersonasAdaptador.MyViewHolder,
                                  position: Int) {
        val persona = listaPersonas.get(position)
        myViewHolder.nombreTextView.text = persona.nombre
        myViewHolder.cedulaTextView.text = persona.cedula
    }

}