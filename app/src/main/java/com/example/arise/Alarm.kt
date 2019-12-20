package com.example.arise

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.DayOfWeek

@Entity(tableName = "Alarm")
data class Alarm(
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "time")val time: String, //TODO replace?
    @ColumnInfo(name = "days")val days: Int, // TODO array - typeconverter
    @ColumnInfo(name = "status")val status: Boolean
){
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long = 0
}
