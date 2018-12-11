package org.mobelitetest.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName


/**
 * Created by Ali DOUIRI on 09/12/2018.
 * my.alidouiri@gmail.com
 */
data class Post(
        @SerializedName("userId") val uid: Long,
        @SerializedName("id") val id: Long,
        @SerializedName("title") val title: String,
        @SerializedName("body") val body: String
) : Parcelable {
        constructor(source: Parcel) : this(
                source.readLong(),
                source.readLong(),
                source.readString(),
                source.readString()
        )

        override fun describeContents() = 0

        override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
                writeLong(uid)
                writeLong(id)
                writeString(title)
                writeString(body)
        }

        companion object {
                @JvmField
                val CREATOR: Parcelable.Creator<Post> = object : Parcelable.Creator<Post> {
                        override fun createFromParcel(source: Parcel): Post = Post(source)
                        override fun newArray(size: Int): Array<Post?> = arrayOfNulls(size)
                }
        }
}