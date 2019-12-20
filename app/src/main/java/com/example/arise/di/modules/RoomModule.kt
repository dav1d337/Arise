package com.example.arise.di.modules

import android.app.Application
import androidx.room.Room
import com.example.arise.db.AlarmRepository
import com.example.arise.db.AppDatabase
import com.example.arise.db.RoomAlarmDao
import com.example.arise.db.RoomAlarmRepository
import com.example.arise.di.ApplicationScope
import dagger.Module
import dagger.Provides

@Module
class RoomModule(private val application: Application) {

    val database: AppDatabase = Room.databaseBuilder(application, AppDatabase::class.java, "app-db").build()

    @ApplicationScope
    @Provides
    fun provideDabase(): AppDatabase {
        return database
    }

    @ApplicationScope
    @Provides
    fun provideAlarmDao(): RoomAlarmDao {
        return database.alarmDao()
    }

    @ApplicationScope
    @Provides
    fun provideAlarmRepository(repo: RoomAlarmRepository): AlarmRepository {
        return repo
    }

}