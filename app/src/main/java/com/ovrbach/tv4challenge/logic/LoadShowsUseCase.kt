package com.ovrbach.tv4challenge.logic

import com.ovrbach.tv4challenge.data.show.ShowRepository
import com.ovrbach.tv4challenge.model.ui.ShowItem
import com.ovrbach.tv4challenge.model.util.Outcome
import javax.inject.Inject

class LoadShowsUseCase @Inject constructor(
    private val showRepository: ShowRepository,
    private val responseMapper: HomeResponseMapper
) {

    suspend fun loadShows(): State {
        return when (val outcome = showRepository.getHomeItems()) {
            is Outcome.Success -> State.Success(responseMapper.toUIModel(outcome.data))
            is Outcome.Failed -> State.Failed(outcome.throwable)
        }
    }

    sealed class State {
        data class Failed(val throwable: Throwable) : State()
        data class Success(val shows: List<ShowItem>) : State()
    }

}