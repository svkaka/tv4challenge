package com.ovrbach.tv4challenge.data

import com.ovrbach.tv4challenge.model.dto.HomeResponse

interface HomeRemoteSource {

    fun getHomeItems(): HomeResponse
}