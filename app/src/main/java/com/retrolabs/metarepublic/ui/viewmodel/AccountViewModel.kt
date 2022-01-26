package com.retrolabs.metarepublic.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.retrolabs.metarepublic.domain.repository.DataStoreRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AccountViewModel @Inject constructor(private val dataStoreRepository: DataStoreRepository) : ViewModel() {

    val username = dataStoreRepository.getName().asLiveData()

    var editTextInput = ""
        set(value) {
            println(field)
            field = value
        }

    fun onUserSave() {
        viewModelScope.launch {
            dataStoreRepository.storeData(editTextInput)
        }
    }
}
