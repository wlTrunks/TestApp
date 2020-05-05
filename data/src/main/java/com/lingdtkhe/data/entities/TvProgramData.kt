package com.lingdtkhe.data.entities

import com.google.gson.annotations.SerializedName

/**
 * Tv program object that's representative tv program class in data layer
 */
data class TvProgramData(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("description") val description: String,
    @SerializedName("imageUrl") val imageUrl: String
)
