package com.ovrbach.tv4challenge.feature.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ovrbach.tv4challenge.logic.LoadShowsUseCase
import kotlinx.coroutines.launch

class HomeViewModel @ViewModelInject constructor(
    private val loadShowsUseCase: LoadShowsUseCase
) : ViewModel() {

    val state: MutableLiveData<LoadShowsUseCase.State> = MutableLiveData()
    val isLoading: MutableLiveData<Boolean> = MutableLiveData() //todo should come from use case

    init {
        viewModelScope.launch {
            refreshShows()
        }
    }

    private suspend fun refreshShows() {
        isLoading.postValue(true)
        val state = loadShowsUseCase.loadShows()
        isLoading.postValue(false)
        this.state.postValue(state)
    }

    fun reloadShows() {
        viewModelScope.launch {
            refreshShows()
        }
    }

}