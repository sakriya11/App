package com.sakriya.replicaapp.ui.dashboard

import android.os.Parcel
import android.os.Parcelable


data class NewUser (

        var Fname : String,
        var age : Int,
        var gender: String,
        var Address : String
        ):Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readInt(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(Fname)
        parcel.writeInt(age)
        parcel.writeString(gender)
        parcel.writeString(Address)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<NewUser> {
        override fun createFromParcel(parcel: Parcel): NewUser {
            return NewUser(parcel)
        }

        override fun newArray(size: Int): Array<NewUser?> {
            return arrayOfNulls(size)
        }
    }

}
