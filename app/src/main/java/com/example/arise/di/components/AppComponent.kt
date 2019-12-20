package com.example.arise.di.components

import com.example.arise.App
import com.example.arise.di.ApplicationScope
import com.example.arise.di.modules.AppModule
import com.example.arise.di.modules.AriseModule
import com.example.arise.di.modules.RoomModule
import dagger.Component


@ApplicationScope
@Component(modules = arrayOf(AppModule::class, RoomModule::class))
interface AppComponent {
    fun newAriseComponent(module: AriseModule): AriseComponent

    fun inject(app: App)
}