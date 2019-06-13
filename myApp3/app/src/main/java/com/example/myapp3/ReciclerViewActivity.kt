package com.example.myapp3

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutCompat
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_list_view.*
import kotlinx.android.synthetic.main.layout.*

class ReciclerViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        val lista = arrayListOf<Persona>()
        val recycle_view = lv_example
        val actividad = this


        lista.add(Persona("Renny","1313305136"))
        lista.add(Persona("Andree","1304143934"))
        lista.add(Persona("Tito","1319274011"))

        iniciarRecylerView(lista,this,recycle_view)

    }
    fun cambiarNombreTextView(texto:String){
        txt_titulo_rv.text = texto;
    }
    fun iniciarRecylerView(
        lista: List<Persona>,
        actividad: ReciclerViewActivity,
        recycler_view: RecyclerView
    ) {
        val adaptadorPersona = PersonasAdaptador(
            lista,
            actividad,
            recycler_view
        )
        recycler_view.adapter = adaptadorPersona
        recycler_view.itemAnimator = DefaultItemAnimator()
        recycler_view.layoutManager = LinearLayoutManager(actividad)

        adaptadorPersona.notifyDataSetChanged()
    }

}
