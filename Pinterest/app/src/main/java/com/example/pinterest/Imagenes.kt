package com.example.pinterest

import android.graphics.drawable.Drawable
import android.os.Parcel
import android.os.Parcelable

class Imagenes(var txtInfo:String,var imageId:Int, var descripcion:String,var like:Boolean):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readByte() != 0.toByte()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(txtInfo)
        parcel.writeInt(imageId)
        parcel.writeString(descripcion)
        parcel.writeByte(if (like) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Imagenes> {
        override fun createFromParcel(parcel: Parcel): Imagenes {
            return Imagenes(parcel)
        }

        override fun newArray(size: Int): Array<Imagenes?> {
            return arrayOfNulls(size)
        }
    }
}