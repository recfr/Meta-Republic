package com.retrolabs.metarepublic.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.retrolabs.metarepublic.data.model.database.MetaDetailsEntity
import com.retrolabs.metarepublic.domain.repository.MetaModelRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeFragmentViewModel @Inject constructor(
    private val metaverseRepository: MetaModelRepositoryImpl,
) : ViewModel() {

    init {
        viewModelScope.launch {
            metaverseRepository.refreshData()
        }
    }

    val metaModelLiveData: LiveData<List<MetaDetailsEntity>>
        get() = metaverseRepository.getAllMetaverse()


//    fun updateMetaverseList(metaModelResponse: MetaModelResponse) {
//        viewModelScope.launch {
//            metaverseRepository.updateMetaverseList(metaModelResponse)
//        }
//    }

    fun deleteAll() {
        viewModelScope.launch {
            metaverseRepository.deleteAll()
        }
    }

    /**
     * Use for delete from favorites. That means I need "favorites_table".
     */
    fun deleteMetaverse(metaDetailsEntity: MetaDetailsEntity) {
        viewModelScope.launch {
            metaverseRepository.deleteMetaverse(metaDetailsEntity)
        }
    }
}
