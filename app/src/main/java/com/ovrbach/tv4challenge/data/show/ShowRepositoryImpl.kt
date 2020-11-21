package com.ovrbach.tv4challenge.data.show

import com.ovrbach.tv4challenge.model.dto.HomeResponse
import javax.inject.Inject

class ShowRepositoryImpl @Inject constructor(
    private val remoteSource: ShowRemoteSource
) : ShowRepository {

    override suspend fun getHomeItems(): HomeResponse = remoteSource.getHomeItems()
}