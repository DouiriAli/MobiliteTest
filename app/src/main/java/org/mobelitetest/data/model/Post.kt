package org.mobelitetest.data.model

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
        )