package com.shu.data.db.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "cities")
data class CitiesDbo(
    @PrimaryKey
    @ColumnInfo("name")
    val name: String,
)