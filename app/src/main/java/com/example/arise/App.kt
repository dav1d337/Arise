package com.example.arise

import android.app.Application
import android.content.Context
import com.example.arise.di.components.AppComponent
import com.example.arise.di.components.DaggerAppComponent
import com.example.arise.di.modules.AppModule
import com.example.arise.di.modules.RoomModule

class App : Application() {

    lateinit var appComponent: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .roomModule(RoomModule(application = this))
            .build()

        appComponent.inject(this)
    }
}