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
}
