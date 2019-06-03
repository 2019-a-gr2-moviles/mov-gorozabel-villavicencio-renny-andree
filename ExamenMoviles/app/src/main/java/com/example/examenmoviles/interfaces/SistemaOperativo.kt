package com.example.examenmoviles.interfaces

import android.os.Parcel
import android.os.Parcelable
import java.util.*

class SistemaOperativo(var id:Int?,
                       var nombre:String,
                       var versionApi:Int,
                       var fechaLanzamiento:Date,
                       var pesoEnGigas:Double,
                       var instalado:Boolean):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readInt(),
        parcel.readSerializable() as Date,
        parcel.readDouble(),
        parcel.readByte() != 0.toByte()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeString(nombre)
        parcel.writeInt(versionApi)
        parcel.writeSerializable(fechaLanzamiento)
        parcel.writeDouble(pesoEnGigas)
        parcel.writeByte(if (instalado) 1 else 0)
    }

    override fun toString(): String {
        return "${nombre}";
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SistemaOperativo> {
        override fun createFromParcel(parcel: Parcel): SistemaOperativo {
            return SistemaOperativo(parcel)
        }

        override fun newArray(size: Int): Array<SistemaOperativo?> {
            return arrayOfNulls(size)
        }
    }
}

