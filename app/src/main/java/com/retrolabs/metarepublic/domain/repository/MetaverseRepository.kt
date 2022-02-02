package com.retrolabs.metarepublic.domain.repository

import androidx.lifecycle.LiveData
import com.retrolabs.metarepublic.data.model.database.MetaDetailsEntity

interface MetaverseRepository {

    fun getAllMetaverse(): LiveData<List<MetaDetailsEntity>>

    suspend fun refreshData()

    suspend fun insertNewMetaverse(metaDetailsEntity: MetaDetailsEntity)

    suspend fun updateMetaverseList(metaDetailsEntityList: List<MetaDetailsEntity>)

    suspend fun insertFavorites(metaDetailsEntity: MetaDetailsEntity)
}
