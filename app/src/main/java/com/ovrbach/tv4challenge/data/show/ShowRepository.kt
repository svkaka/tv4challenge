package com.ovrbach.tv4challenge.data.show

import com.ovrbach.tv4challenge.model.dto.HomeResponse

interface ShowRepository {

    suspend fun getHomeItems(): HomeResponse
}