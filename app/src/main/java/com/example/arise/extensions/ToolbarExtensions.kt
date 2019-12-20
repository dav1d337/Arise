package com.example.arise.extensions

import android.view.MenuItem
import androidx.annotation.MenuRes
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.ui.setupWithNavController

fun Toolbar.bind(navController: NavController, @MenuRes resId: Int, listener: (MenuItem) -> Boolean) {
    this.inflateMenu(resId)
    this.setOnMenuItemClickListener(listener)

    this.setupWithNavController(navController)
}