package com.example.arise.di.modules

import android.app.Activity
import android.content.Context
import androidx.fragment.app.FragmentActivity
import com.example.arise.di.ControllerScope
import dagger.Module
import dagger.Provides

@Module
class AriseModule(private val mActivity: FragmentActivity) {

    @Provides
    @ControllerScope
    internal fun context(): Context {
        return mActivity
    }

    @Provides
    @ControllerScope
    internal fun activity(): Activity {
        return mActivity
    }
}