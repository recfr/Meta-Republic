package com.retrolabs.metarepublic.domain.repository

import com.retrolabs.metarepublic.data.local.MetaverseDao
import com.retrolabs.metarepublic.data.model.database.MetaDetailsEntity
import javax.inject.Inject

class FavoriteRepositoryImpl @Inject constructor(
    private val dao: MetaverseDao
) : FavoriteRepository {

    override suspend fun insertFavorite(metaDetailsEntity: MetaDetailsEntity) {
        dao.insertFavorite(metaDetailsEntity)
    }

    override suspend fun deleteFavorite(metaDetailsEntity: MetaDetailsEntity) {
        dao.deleteFavorite(metaDetailsEntity)
    }

    override suspend fun deleteAllFavorites() {
        dao.deleteAllFavorites()
    }
}