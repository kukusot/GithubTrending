package com.githubtrending.repos.domain.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
data class Licence(
    val key: String,
    val name: String,
    @SerializedName("spdx_id") val displayName: String
) : Parcelable {

    private constructor(source: Parcel) : this(
        source.readString(),
        source.readString(),
        source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(key)
        writeString(name)
        writeString(displayName)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Licence> = object : Parcelable.Creator<Licence> {
            override fun createFromParcel(source: Parcel): Licence = Licence(source)
            override fun newArray(size: Int): Array<Licence?> = arrayOfNulls(size)
        }
    }
}