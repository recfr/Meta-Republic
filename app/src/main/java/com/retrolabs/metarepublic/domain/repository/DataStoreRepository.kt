package com.retrolabs.metarepublic.domain.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.map
import javax.inject.Inject


/**
 *  Advantage of writing dataStore top level : one instance of datastore.
 */
private const val USER_PREFERENCES_NAME = "preference"
private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = USER_PREFERENCES_NAME)

class DataStoreRepository @Inject constructor(@ApplicationContext val context: Context) {

    companion object {
        val USERNAME = stringPreferencesKey("USER_NAME")
    }

    suspend fun storeData(userName: String) {
        context.dataStore.edit {
            it[USERNAME] = userName
        }
    }


    fun getName() = context.dataStore.data.map {
        it[USERNAME] ?: ""
    }
}