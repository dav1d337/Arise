package com.example.arise.extensions

import android.content.Context
import android.os.PowerManager


fun Context.isScreenOn() = (getSystemService(Context.POWER_SERVICE) as PowerManager).isInteractive