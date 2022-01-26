package com.retrolabs.metarepublic.data.remote

import com.retrolabs.metarepublic.data.model.MetaModelResponse
import com.retrolabs.metarepublic.utils.MockDataInterceptor.Companion.MOCK_METAVERSE_DETAIL_URL
import retrofit2.Response
import retrofit2.http.GET

interface ApiCall {
    @GET("metaverselist")
    suspend fun getMetaverseList(): Response<MetaModelResponse>

    @GET(MOCK_METAVERSE_DETAIL_URL)
    suspend fun getMockMetaverseList() : Response<MetaModelResponse>
}
