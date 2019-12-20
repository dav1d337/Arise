package com.example.arise.di.modules
import android.app.Application
import com.example.arise.AndroidSchedulerFacade
import com.example.arise.DeviceUuidFactory
import com.example.arise.SchedulerFacade
import com.example.arise.di.ApplicationScope
import dagger.Module
import dagger.Provides

@Module
class AppModule(private val app: Application) {

    private val deviceUuidFactory: DeviceUuidFactory

    init {
        deviceUuidFactory = DeviceUuidFactory(app)
    }

    @Provides
    @ApplicationScope
    internal fun provideApplicationContext(): Application {
        return app
    }

    @Provides
    @ApplicationScope
    internal fun provideDeviceUuid(): DeviceUuidFactory {
        return deviceUuidFactory
    }

    @Provides
    @ApplicationScope
    internal fun provideScheduler(): SchedulerFacade {
        return AndroidSchedulerFacade()
    }


}