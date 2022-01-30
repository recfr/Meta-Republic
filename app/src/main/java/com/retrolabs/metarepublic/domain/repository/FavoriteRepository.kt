package com.retrolabs.metarepublic.domain.repository

import androidx.lifecycle.LiveData
import com.retrolabs.metarepublic.data.model.database.MetaDetailsEntity

interface FavoriteRepository {

    fun getAllFavorites(): LiveData<List<MetaDetailsEntity>>

    suspend fun insertFavorite(metaDetailsEntity: MetaDetailsEntity)

    suspend fun deleteFavorite(metaDetailsEntity: MetaDetailsEntity)

    suspend fun deleteAllFavorites()
}