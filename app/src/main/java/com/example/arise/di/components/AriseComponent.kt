package com.example.arise.di.components

import com.example.arise.di.ControllerScope
import com.example.arise.di.modules.AriseModule
import com.example.arise.ui.main.MainFragment
import dagger.Subcomponent

@ControllerScope
@Subcomponent(modules = arrayOf(AriseModule::class))
interface AriseComponent {
    fun inject(mainFragment: MainFragment)

}
