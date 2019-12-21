package com.example.arise

import android.app.*
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import com.example.arise.di.components.AppComponent
import com.example.arise.di.components.DaggerAppComponent
import com.example.arise.di.modules.AppModule
import com.example.arise.di.modules.RoomModule
import com.example.arise.ui.AppStartActivity
import com.example.arise.ui.main.MainFragment
import com.example.arise.ui.main.MainFragment_MembersInjector

class App : Application() {

    lateinit var appComponent: AppComponent
        private set

    lateinit var alarmNotification: Notification
        private set

    override fun onCreate() {
        super.onCreate()

        // Create an explicit intent for an Activity in your app
        val intent = Intent(this, AppStartActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        val pendingIntent: PendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)

        var builder = NotificationCompat.Builder(this, "Arise")
            .setSmallIcon(R.drawable.ic_add_black_24dp)
            .setContentTitle("Title")
            .setContentText("Content")
            .setFullScreenIntent(pendingIntent, true)
            .setAutoCancel(true)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setCategory(NotificationCompat.CATEGORY_ALARM)

        alarmNotification = builder.build()

        createNotificationChannel()

        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .roomModule(RoomModule(application = this))
            .build()

        appComponent.inject(this)
    }

    private fun createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Channel"
            val descriptionText = "Channel for Notifications"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel("Arise", name, importance).apply {
                description = descriptionText
            }
            // Register the channel with the system
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }
}