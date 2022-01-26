package com.retrolabs.metarepublic.data.model.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "metaverse_table")
data class MetaDetailsEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "meta_id")
    val metaId: Int,
    @ColumnInfo(name = "meta_name")
    val metaName: String?,
    @ColumnInfo(name = "meta_uri")
    val metaUri: String?,
    @ColumnInfo(name = "meta_token_name")
    val metaTokenName: String?,
    @ColumnInfo(name = "meta_media")
    val metaMedia: String?,
    @ColumnInfo(name = "meta_info")
    val metaInfo: String?
)
