package com.shu.data.db.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "cities")
data class CitiesDbo(
    @PrimaryKey(autoGenerate = true) val id: Long = 0L,
    @ColumnInfo("name")
    val name: String,
)