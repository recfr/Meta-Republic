package com.retrolabs.metarepublic.data.model.network

data class MetaModelResponse(
    val templating: Int?,
    val metaverse: ArrayList<MetaDetailsResponse>,
    val total: String?
)
