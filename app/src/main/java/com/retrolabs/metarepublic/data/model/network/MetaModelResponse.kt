package com.retrolabs.metarepublic.data.model

import com.retrolabs.metarepublic.data.model.network.MetaDetailsResponse

data class MetaModelResponse(
    val templating: Int?,
    val metaverse: ArrayList<MetaDetailsResponse>,
    val total: String?
)
