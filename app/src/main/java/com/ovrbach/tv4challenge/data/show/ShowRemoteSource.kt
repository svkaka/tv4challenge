package com.ovrbach.tv4challenge.data.show

import com.ovrbach.tv4challenge.model.dto.HomeResponse
import com.ovrbach.tv4challenge.model.util.Outcome

interface ShowRemoteSource {

    suspend fun getHomeItems(): Outcome<HomeResponse>
}