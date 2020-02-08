package com.route.todoapplicationg2.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity()
data class Note(
    val title: String,
    val content: String,
    val time: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}