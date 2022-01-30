package com.retrolabs.metarepublic.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.retrolabs.metarepublic.data.model.database.FavoriteMetaEntity
import com.retrolabs.metarepublic.data.model.database.MetaDetailsEntity


@Database(entities = [MetaDetailsEntity::class, FavoriteMetaEntity::class], version = 1, exportSchema = false)
abstract class MetaverseDatabase : RoomDatabase() {

    abstract fun metaverseDao(): MetaverseDao

    companion object {

        @Volatile
        private var INSTANCE: MetaverseDatabase? = null

        fun getDatabase(context: Context): MetaverseDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MetaverseDatabase::class.java,
                    "metaverse_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }


}
