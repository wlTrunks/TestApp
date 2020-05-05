package com.lingdtkhe.data.source.network.api

import com.lingdtkhe.data.source.network.server.TVSchedulesResponse
import retrofit2.http.GET

// https://cloud.nousdigital.net/s/Njedq4WpjWz4KKk/download

const val BASE_URL = "https://cloud.nousdigital.net"

interface NousDigitalApi {
    @GET("/s/Njedq4WpjWz4KKk/download")
    suspend fun getTvSchedules(): TVSchedulesResponse
}