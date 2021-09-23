package com.example.emarketapplication.modal

import android.os.Parcel
import android.os.Parcelable

class Users(
    val fullname: String? = null,
    val gender: String? = null,
    val address: String? = null,
    val phone: String? = null,
    val dob: String? = null,
    val username: String? = null,
    val password: String? = null,
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(fullname)
        parcel.writeString(gender)
        parcel.writeString(address)
        parcel.writeString(phone)
        parcel.writeString(dob)
        parcel.writeString(username)
        parcel.writeString(password)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Users> {
        override fun createFromParcel(parcel: Parcel): Users {
            return Users(parcel)
        }

        override fun newArray(size: Int): Array<Users?> {
            return arrayOfNulls(size)
        }
    }
}