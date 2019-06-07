package com.example.myapp3

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutCompat
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.layout.*

class ReciclerViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_persona)

        val lista = arrayListOf<Persona>()
        val recycle_view = rv_personas
        val actividad = this

        lista.add(Persona("Renny","1313305136"))
        lista.add(Persona("Andree","1304143934"))
        lista.add(Persona("Tito","1319274011"))

        val adaptadorPersona = PersonasAdaptador(lista,
            actividad,
            recycle_view)

        rv_personas.adapter = adaptadorPersona
        rv_personas.itemAnimator = DefaultItemAnimator()
        rv_personas.layoutManager = LinearLayoutManager(actividad)

        adaptadorPersona.notifyDataSetChanged()

    }
}
