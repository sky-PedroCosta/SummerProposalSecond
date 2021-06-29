package com.summerproposal.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.summerproposal.domain.model.*
import com.summerproposal.repository.PeacockRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed class MainState {
    object Loading : MainState()
    data class Success(val data: PeacockData) : MainState()
    data class Error(val exception: Throwable) : MainState()
}

@HiltViewModel
class MainViewModel @Inject constructor(
    private val peacockRepositoryImpl: PeacockRepositoryImpl,
) : ViewModel() {

    private val _res = MutableStateFlow<MainState>(MainState.Loading)

    val res : LiveData<MainState>
        get() = _res.asLiveData()

    init {
        fetchData()
    }

    fun fetchData() {
        viewModelScope.launch {
            peacockRepositoryImpl.getAll().let {
                val peacockData = it.body()
                if(it.code() == 200 && peacockData != null) {
                    var filteredList = peacockData.relationships.items.items.filter { it1 ->
                         it1.relationships != null || it1.relationships?.items?.data?.isNotEmpty() == true
                    }
                    var b = Relationship(Items(filteredList))
                    _res.value = MainState.Success(peacockData.copy(relationships = b))
                }
                else{
                    _res.value = MainState.Error(Throwable(it.message()))
                }

            }
        }
    }
}

//        CoroutineScope(Dispatchers.IO).launch {
//            val data = peacockRepositoryImpl.getAll()
//        }
