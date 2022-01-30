package com.retrolabs.metarepublic.domain.repository

import com.retrolabs.metarepublic.data.model.database.MetaDetailsEntity

interface FavoriteRepository {

    suspend fun insertFavorite(metaDetailsEntity: MetaDetailsEntity)

    suspend fun deleteFavorite(metaDetailsEntity: MetaDetailsEntity)

    suspend fun deleteAllFavorites()
}