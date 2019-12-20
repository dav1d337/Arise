package com.example.arise.receiver

import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.core.content.ContextCompat
import com.example.arise.R
import com.example.arise.extensions.isScreenOn
import com.example.arise.extensions.sendNotification

class AlarmBroadcastReceiver: BroadcastReceiver() {

    val TAG = "AlarmBroadcastReceiver"

    override fun onReceive(context: Context, intent: Intent) {
        Log.i(TAG, "PENIShallo")

        val notificationManager = ContextCompat.getSystemService(
            context,
            NotificationManager::class.java
        ) as NotificationManager

        notificationManager.sendNotification(
            context.getText(R.string.notification_title).toString(),
            context
        )


//        val id = intent.getIntExtra(ALARM_ID, -1)
//        val alarm = context.dbHelper.getAlarmWithId(id) ?: return

        if (context.isScreenOn()) {
           // context.showAlarmNotification(alarm)
//            Handler().postDelayed({
//                context.hideNotification(id)
//            }, context.config.alarmMaxReminderSecs * 1000L)
            Log.i(TAG, "Alarm, Screen is active")

        } else {
            Log.i(TAG, "Alarm, Screen is inactive")
//            Intent(context, ReminderActivity::class.java).apply {
//                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
//                putExtra(ALARM_ID, id)
//                context.startActivity(this)
//            }
        }
    }
}