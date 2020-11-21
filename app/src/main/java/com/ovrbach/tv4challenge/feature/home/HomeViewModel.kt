package com.ovrbach.tv4challenge.feature.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ovrbach.tv4challenge.logic.LoadShowsUseCase
import com.ovrbach.tv4challenge.model.ui.ShowItem
import kotlinx.coroutines.launch

class HomeViewModel @ViewModelInject constructor(
    private val loadShowsUseCase: LoadShowsUseCase
) : ViewModel() {

    val shows: MutableLiveData<List<ShowItem>> = MutableLiveData()

    init {
        viewModelScope.launch {
            refreshShows()
        }
    }

    private suspend fun refreshShows() {
        val loadedShows = loadShowsUseCase.loadShows()
        shows.postValue(loadedShows)
    }

    fun reloadShows() {
        viewModelScope.launch {
            refreshShows()
        }
    }

}