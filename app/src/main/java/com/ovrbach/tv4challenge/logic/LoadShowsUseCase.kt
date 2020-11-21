package com.ovrbach.tv4challenge.logic

import com.ovrbach.tv4challenge.data.show.ShowRepository
import com.ovrbach.tv4challenge.model.ui.ShowItem
import javax.inject.Inject

class LoadShowsUseCase @Inject constructor(
    private val showRepository: ShowRepository,
    private val responseMapper: HomeResponseMapper
) {
    suspend fun loadShows(): List<ShowItem> {
        val response = showRepository.getHomeItems()
        return responseMapper.toUIModel(response)
    }
}