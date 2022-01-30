package com.retrolabs.metarepublic.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.retrolabs.metarepublic.data.model.database.MetaDetailsEntity


/**
 * Data Access Object
 */
@Dao
interface MetaverseDao {

    /**
     * The @Query annotation allows you to write SQL statements and expose them as DAO methods.
     * Use these query methods to query data from your app's database, or
     * when you need to perform more complex inserts, updates, and deletes.
     */
    @Query("SELECT * FROM metaverse_table ORDER BY meta_id")
    fun getAllMetaverse(): LiveData<List<MetaDetailsEntity>>

    /**
     * The @Insert annotation allows you to define methods that insert their
     * parameters into the appropriate table in the database.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMetaModelEntity(metaDetailsEntity: MetaDetailsEntity)

    /**
     * The @Update annotation allows you to define methods that update specific rows in a database table.
     * Similarly to @Insert methods, @Update methods accept data entity instances as parameters.
     */
    @Update
    suspend fun updateMetaverseList(metaDetailsEntity: List<MetaDetailsEntity>)

    /**
     * Favorite Lists Methods
     */
    @Insert
    suspend fun insertFavorite(metaDetailsEntity: MetaDetailsEntity)

    /**
     * The @Delete annotation allows you to define methods that delete specific rows from a database table.
     * Similarly to @Insert methods, @Delete methods accept data entity instances as parameters.
     *
     * The DELETE operation returns the Int when deletion of the single object is successful
     * returns 1 else returns 0 if the DELETE operation is unsuccessful.
     */
    @Delete
    suspend fun deleteFavorite(metaDetailsEntity: MetaDetailsEntity)

    @Query("DELETE FROM favorite_table")
    suspend fun deleteAllFavorites()
}
