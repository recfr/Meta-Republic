package com.retrolabs.metarepublic.di

import android.content.Context
import androidx.room.Room
import com.retrolabs.metarepublic.data.local.MetaverseDao
import com.retrolabs.metarepublic.data.local.MetaverseDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class AppModule {

    @Singleton
    @Provides
    fun providesMetaverseDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, MetaverseDatabase::class.java, "metaverse_database")
            .fallbackToDestructiveMigration().build()

    @Provides
    fun providesMetaverseDao(metaverseDatabase: MetaverseDatabase): MetaverseDao {
        return metaverseDatabase.metaverseDao()
    }
}
