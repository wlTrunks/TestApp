package com.lingdtkhe.data.source.network.server

import com.google.gson.annotations.SerializedName
import com.lingdtkhe.data.entities.TvProgramData

/**
 * Response for items
 */
class TVSchedulesResponse(
    @SerializedName("items") val items: List<TvProgramData>
)
