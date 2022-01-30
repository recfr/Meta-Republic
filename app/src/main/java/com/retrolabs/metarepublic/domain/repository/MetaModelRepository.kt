package com.retrolabs.metarepublic.domain.repository

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import com.retrolabs.metarepublic.data.local.MetaverseDao
import com.retrolabs.metarepublic.data.mapper.MetaModelMapper
import com.retrolabs.metarepublic.data.model.database.MetaDetailsEntity
import com.retrolabs.metarepublic.data.model.network.MetaModelResponse
import com.retrolabs.metarepublic.data.remote.ApiCallService.apiCall
import dagger.hilt.android.qualifiers.ApplicationContext
import java.io.File
import javax.inject.Inject


class MetaModelRepositoryImpl @Inject constructor(
    @ApplicationContext val context: Context,
    private val dao: MetaverseDao,
    private val metaModelMapper: MetaModelMapper
) : MetaverseRepository {

    override suspend fun refreshData() {

        getMetaModel().onSuccess { response ->
            val metaModelEntityList = response.metaverse.map { metaModelMapper.mapMetaModelEntity(it) }
            metaModelEntityList.forEach {
                dao.insertMetaModelEntity(it)
            }
        }
    }

    /**
     * If device has network connection, run this method.
     */
    private suspend fun getMetaModel(): Result<MetaModelResponse> {

        val response = apiCall.getMetaverseList()

        return if (response.isSuccessful) {
            Result.success(response.body()!!)
        } else {
            Result.failure(Exception(response.errorBody().toString()))
        }
    }

    /**
     * If device has no network connection, run this method.
     */
    private suspend fun getMockMetaModel(): Result<MetaModelResponse?> {

        val response = apiCall.getMockMetaverseList()

        return if (response.isSuccessful) {
            Result.success(response.body())
        } else {
            Result.failure(Exception(response.errorBody().toString()))
        }
    }

    /**
     * Override MetaverseRepository Room Database Functions
     */
    override fun getAllMetaverse(): LiveData<List<MetaDetailsEntity>> {
        return dao.getAllMetaverse()
    }

    override suspend fun insertNewMetaverse(metaDetailsEntity: MetaDetailsEntity) {
        dao.insertMetaModelEntity(metaDetailsEntity)
    }

    override suspend fun updateMetaverseList(metaDetailsEntityList: List<MetaDetailsEntity>) {
        dao.updateMetaverseList(metaDetailsEntityList)
    }

    /**
     * Check network connection
     * liveData/useCase ?
     * fun Context.hasNetworkConnection(){}
     */
    @RequiresApi(Build.VERSION_CODES.M)
    fun isOnline(context: Context): Boolean {

        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val capabilities = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)

        if (capabilities != null) {
            when {
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> {
                    Log.i("Internet", "NetworkCapabilities.TRANSPORT_CELLULAR")
                    return true
                }
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> {
                    Log.i("Internet", "NetworkCapabilities.TRANSPORT_WIFI")
                    return true
                }
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> {
                    Log.i("Internet", "NetworkCapabilities.TRANSPORT_ETHERNET")
                    return true
                }
            }
        }
        return false
    }

    /**
     * Check is metaverse_database Room Database existing.
     */
    private fun isDatabaseExist(context: Context, databaseName: String): Boolean {
        val databaseFile: File = context.getDatabasePath(databaseName)
        return databaseFile.exists()
    }
}
