package com.ovrbach.tv4challenge.data.remote.service

import com.ovrbach.tv4challenge.model.dto.HomeResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ShowRemoteService {

    @GET("assets")
    suspend fun getHomeItems(@Query("client") client: String = "android-code-test"): HomeResponse
}