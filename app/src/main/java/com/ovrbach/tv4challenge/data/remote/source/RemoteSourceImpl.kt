package com.ovrbach.tv4challenge.data.remote.source

import com.ovrbach.tv4challenge.data.remote.ErrorHandler
import com.ovrbach.tv4challenge.data.remote.service.ShowRemoteService
import com.ovrbach.tv4challenge.data.show.ShowRemoteSource
import com.ovrbach.tv4challenge.model.dto.HomeResponse
import com.ovrbach.tv4challenge.model.util.Outcome
import javax.inject.Inject

class ShowRemoteSourceImpl  @Inject constructor(
    private val remoteService: ShowRemoteService,
    private val errorHandler: ErrorHandler
) : ShowRemoteSource {

    override suspend fun getHomeItems(): HomeResponse = remoteService.getHomeItems()

    private suspend fun <T> request(request: suspend () -> T): Outcome<T> = try {
        Outcome.Success(request())
    } catch (t: Throwable) {
        t.printStackTrace()
        Outcome.Failed(errorHandler.mapError(t))
    }
}