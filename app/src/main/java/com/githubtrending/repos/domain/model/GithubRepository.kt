package com.githubtrending.repos.domain.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import java.util.*

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
data class GithubRepository(
    val id: Long,
    val name: String,
    val fullName: String,
    val description: String,
    @SerializedName("stargazers_count") val stars: Int,
    val forksCount: Int,
    val updatedAt: Date,
    val language: String?,
    val license: Licence?,
    val htmlUrl: String,
    val owner: Owner
) : Parcelable {

    private constructor(source: Parcel) : this(
        source.readLong(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readInt(),
        source.readInt(),
        source.readSerializable() as Date,
        source.readString(),
        source.readParcelable<Licence>(Licence::class.java.classLoader),
        source.readString(),
        source.readParcelable<Owner>(Owner::class.java.classLoader)
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeLong(id)
        writeString(name)
        writeString(fullName)
        writeString(description)
        writeInt(stars)
        writeInt(forksCount)
        writeSerializable(updatedAt)
        writeString(language)
        writeParcelable(license, 0)
        writeString(htmlUrl)
        writeParcelable(owner, 0)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<GithubRepository> = object : Parcelable.Creator<GithubRepository> {
            override fun createFromParcel(source: Parcel): GithubRepository = GithubRepository(source)
            override fun newArray(size: Int): Array<GithubRepository?> = arrayOfNulls(size)
        }
    }
}

