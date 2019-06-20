package com.example.pinterest

import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.graphics.drawable.Drawable
import android.media.Image
import android.support.v4.content.res.TypedArrayUtils
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

class AdaptadorImagenes(
    private val listaImg:List<Imagenes>,
    private val contexto:MainActivity,
    private val recyclerView:RecyclerView
):
        RecyclerView.Adapter<AdaptadorImagenes.MyViewHolder>(){
    var indice:Int=0

    inner class MyViewHolder(view:View):RecyclerView.ViewHolder(view){
        var imageView1:ImageView

        init{
            imageView1 = view.findViewById(R.id.img1) as ImageView

            val layout = view.findViewById(R.id.layoutg) as GridLayout

            layout.setOnClickListener {
                Log.i("imagen","imagenPresionanada")

            }
        }
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int):
            AdaptadorImagenes.MyViewHolder {
        val itemView = LayoutInflater
            .from(p0.context)
            .inflate(
                R.layout.layout,
                p0,
                false
            )
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return listaImg.size
    }

    override fun onBindViewHolder(myViewHolder: AdaptadorImagenes.MyViewHolder,
                                  position: Int){
        val foto = listaImg[position]
        myViewHolder.imageView1.setImageResource(foto.imageId)

        myViewHolder.imageView1.setOnClickListener{
            indice = myViewHolder.adapterPosition
            Log.i("posicion",indice.toString())
            val intent = Intent(contexto.applicationContext,Informacion::class.java)
            intent.addFlags(FLAG_ACTIVITY_NEW_TASK)
            val listaEx = listaImg
            val listaExtra = Imagenes(foto.txtInfo,foto.imageId,foto.descripcion,foto.like)
            intent.putExtra("imagen",listaExtra)
            intent.putExtra("posicion",position)
            contexto.applicationContext.startActivity(intent)
        }
    }

}