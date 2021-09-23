package com.example.emarketapplication.response

import android.os.Parcel
import android.os.Parcelable
import com.example.emarketapplication.modal.Users

data class UsersLoginResponse(
    val success: Boolean? = null,
    val token: String? = null,
    val message: String? = null,
    val details: MutableList<Users>? = null
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readString(),
        parcel.readString(),
        TODO("details")
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(success)
        parcel.writeString(token)
        parcel.writeString(message)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<UsersLoginResponse> {
        override fun createFromParcel(parcel: Parcel): UsersLoginResponse {
            return UsersLoginResponse(parcel)
        }

        override fun newArray(size: Int): Array<UsersLoginResponse?> {
            return arrayOfNulls(size)
        }
    }
}