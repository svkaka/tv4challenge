package com.ovrbach.tv4challenge.logic

import com.ovrbach.tv4challenge.model.dto.HomeResponse
import com.ovrbach.tv4challenge.model.ui.ShowItem
import javax.inject.Inject

class HomeResponseMapper @Inject constructor(
    private val imageProxyUrlBuilder: ImageProxyUrlBuilder
) {

    companion object {
        private const val DEFAULT_URL =
            "http://bppl.kkp.go.id/uploads/publikasi/karya_tulis_ilmiah/default-min.jpg"
    }

    fun toUIModel(homeResponse: HomeResponse) =
        homeResponse.data.map { data ->
            ShowItem(
                id = data.id,
                title = data.title,
                caption = produceEpisodeName(data.season, data.episode),
                image = data.image?.let { image -> imageProxyUrlBuilder.homeImage(image) }
                    ?: DEFAULT_URL,
                body = data.description,
            )
        }

    //could be episode name formatter
    private fun produceEpisodeName(season: Int, episode: Int) = if (season != -1 && episode != -1) {
        String.format("S%02d:E%02d", season, episode) // ignore when -1
    } else {
        null
    }

}