package com.retrolabs.metarepublic.domain.repository

import androidx.lifecycle.LiveData
import com.retrolabs.metarepublic.data.local.MetaverseDao
import com.retrolabs.metarepublic.data.model.database.MetaDetailsEntity
import javax.inject.Inject

class FavoriteRepositoryImpl @Inject constructor(
    private val dao: MetaverseDao
) : FavoriteRepository {

    override fun getAllFavorites(): LiveData<List<MetaDetailsEntity>> {
        return dao.getAllFavorites()
    }

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