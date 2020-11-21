package com.ovrbach.tv4challenge.logic

import com.ovrbach.tv4challenge.model.dto.HomeResponse
import com.ovrbach.tv4challenge.model.ui.ShowItem
import javax.inject.Inject

class HomeResponseMapper @Inject constructor() {

    fun toUIModel(homeResponse: HomeResponse) =
        homeResponse.data.map { data ->
            ShowItem(
                id = data.id,
                title = data.title,
                caption = produceEpisodeName(data.season, data.episode),
                image = data.image ?: "", //todo default image
                body = data.description,
            )
        }

    //could be episode name formatter
    private fun produceEpisodeName(season: Int, episode: Int) = if (season != -1 && episode != -1) {
        String.format("S%02d:E%02d", season, episode) //todo ingore when -1
    } else {
        null
    }

}