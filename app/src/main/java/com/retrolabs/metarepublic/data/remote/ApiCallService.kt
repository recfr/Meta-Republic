package com.retrolabs.metarepublic.data.remote

import com.retrolabs.metarepublic.BuildConfig
import com.retrolabs.metarepublic.utils.MockDataInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//TODO "Retrofit Dependency Injection"

//@Module
//@InstallIn(SingletonComponent::class)
object ApiCallService {

    /**
     *  Create a body level interceptor for logging.
     */
    private const val BASE_URL = "http://192.168.1.20:3001/"
    private const val BASE_URL2 = MockDataInterceptor.MOCK_METAVERSE_DETAIL_URL


    private val okhttp3client = OkHttpClient.Builder().apply {
        if (BuildConfig.DEBUG) {
            val customInterceptor = MockDataInterceptor()
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY

            addInterceptor(logging)
//            addInterceptor(customInterceptor)
        }
    }

    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okhttp3client.build())
        .build()
        .create(ApiCall::class.java)

    val apiCall
        get() = api
}

