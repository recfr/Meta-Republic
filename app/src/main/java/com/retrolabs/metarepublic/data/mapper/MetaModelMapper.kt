package com.retrolabs.metarepublic.data.mapper

import com.retrolabs.metarepublic.data.model.database.MetaDetailsEntity
import com.retrolabs.metarepublic.data.model.network.MetaDetailsResponse
import javax.inject.Inject

class MetaModelMapper @Inject constructor() {

    fun mapMetaModelEntity(metaDetailsResponse: MetaDetailsResponse): MetaDetailsEntity {
        return MetaDetailsEntity(
            metaId = metaDetailsResponse.metaId ?: -1,
            metaName = metaDetailsResponse.metaName,
            metaUri = metaDetailsResponse.metaUri,
            metaTokenName = metaDetailsResponse.metaTokenName,
            metaMedia = metaDetailsResponse.metaMedia,
            metaInfo = metaDetailsResponse.metaInfo
        )
    }
}
