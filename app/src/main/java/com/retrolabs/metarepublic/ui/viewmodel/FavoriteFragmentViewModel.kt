package com.retrolabs.metarepublic.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.retrolabs.metarepublic.data.model.database.MetaDetailsEntity
import com.retrolabs.metarepublic.domain.repository.FavoriteRepositoryImpl
import kotlinx.coroutines.launch
import javax.inject.Inject

class FavoriteFragmentViewModel @Inject constructor(
    private val favoriteRepositoryImpl: FavoriteRepositoryImpl
) : ViewModel() {

    val favoriteLiveData: LiveData<List<MetaDetailsEntity>>
        get() = favoriteRepositoryImpl.getAllFavorites()


    /**
     * do not need that function here.
     */
    fun insertFavorite(metaDetailsEntity: MetaDetailsEntity) {
        viewModelScope.launch {
            favoriteRepositoryImpl.insertFavorite(metaDetailsEntity)
        }
    }

    fun deleteFavorite(metaDetailsEntity: MetaDetailsEntity) {
        viewModelScope.launch {
            favoriteRepositoryImpl.deleteFavorite(metaDetailsEntity)
        }
    }

    fun deleteAllFavorites() {
        viewModelScope.launch {
            favoriteRepositoryImpl.deleteAllFavorites()
        }
    }
}