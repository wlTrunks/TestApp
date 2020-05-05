package com.lingdtkhe.testapp.entities

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TvProgramVM(
    val id: Int,
    val title: String,
    val description: String,
    val imageUrl: String
) : Parcelable {
    fun getEmailBody(): String = "$title\n$description"
}
