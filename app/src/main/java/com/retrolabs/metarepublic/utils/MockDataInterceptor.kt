package com.retrolabs.metarepublic.utils

import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.Protocol
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody


class MockDataInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        val requestUri = chain.request().url.toUri().toString()

        return if (requestUri.endsWith(MOCK_METAVERSE_DETAIL_URL)) {
            println(MOCK_METAVERSE_DETAIL_URL)
            getMockResponse(chain)
        } else {
            chain.proceed(chain.request())
        }
    }

    private fun getMockResponse(chain: Interceptor.Chain): Response {

        val mockResponseString = MockDataProvider.MOCK_METAVERSE_DETAIL

        return chain.proceed(chain.request())
            .newBuilder()
            .code(SUCCESS_CODE)
            .protocol(Protocol.HTTP_2)
            .message(mockResponseString)
            .body(mockResponseString.toResponseBody(CONTENT_TYPE_JSON.toMediaTypeOrNull()))
            .addHeader(CONTENT_TYPE_KEY, CONTENT_TYPE_JSON)
            .build()
    }

    companion object {
        const val MOCK_METAVERSE_DETAIL_URL = "mock_meta_detail"
        private const val SUCCESS_CODE = 200
        private const val CONTENT_TYPE_KEY = "content-type"
        private const val CONTENT_TYPE_JSON = "application/json"
    }
}


