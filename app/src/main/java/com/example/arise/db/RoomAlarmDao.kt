package com.example.arise.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.arise.Alarm
import io.reactivex.Flowable

@Dao
interface RoomAlarmDao {
    @Query("SELECT * FROM Alarm")
    fun getAll(): Flowable<List<Alarm>>

    @Query("SELECT * FROM Alarm WHERE id = :id")
    fun get(id: Long): Flowable<Alarm>

    @Query("DELETE FROM Alarm")
    fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(room: Alarm): Long
}
