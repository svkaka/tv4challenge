package com.ovrbach.tv4challenge.data.show

import com.ovrbach.tv4challenge.model.dto.HomeResponse

interface ShowRemoteSource {

    suspend fun getHomeItems(): HomeResponse
}