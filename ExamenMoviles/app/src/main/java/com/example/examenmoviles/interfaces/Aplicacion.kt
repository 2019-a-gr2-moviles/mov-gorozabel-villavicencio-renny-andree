package com.example.examenmoviles.interfaces

import android.os.Parcel
import android.os.Parcelable
import java.util.*

class Aplicacion(var id:Int?,
                 var pesoEnGigas:Double,
                 var version:Int,
                 var nombre:String,
                 var urlDescarga:String,
                 var fechaLanzamiento:String,
                 var costo:Double,
                 var sistemaOperativoId:Int):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readDouble(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readDouble(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeDouble(pesoEnGigas)
        parcel.writeInt(version)
        parcel.writeString(nombre)
        parcel.writeString(urlDescarga)
        parcel.writeString(fechaLanzamiento)
        parcel.writeDouble(costo)
        parcel.writeInt(sistemaOperativoId)
    }
    override fun toString(): String {
        return "${nombre}";
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Aplicacion> {
        override fun createFromParcel(parcel: Parcel): Aplicacion {
            return Aplicacion(parcel)
        }

        override fun newArray(size: Int): Array<Aplicacion?> {
            return arrayOfNulls(size)
        }
    }
}