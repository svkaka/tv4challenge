package com.ovrbach.tv4challenge.logic

import com.ovrbach.tv4challenge.model.dto.HomeResponse
import com.ovrbach.tv4challenge.model.ui.ShowItem

class HomeResponseMapper() {

    fun toUIModel(homeResponse: HomeResponse) {
        homeResponse.data.map { data ->
            ShowItem(
                id = data.id,
                title = "${data.title} (${produceEpisodeName(data.season, data.episode)})",
                image = data.image,
                description = data.description,
            )
        }
    }

    private fun produceEpisodeName(season: Int, episode: Int) =
        String.format("S%02d:E%02d", season, episode)

}