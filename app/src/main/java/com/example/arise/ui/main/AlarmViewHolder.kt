package com.example.arise.ui.main

import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.arise.Alarm
import com.example.arise.R

class AlarmViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val time = itemView.findViewById<TextView>(R.id.time)
    private val days = itemView.findViewById<TextView>(R.id.days)
    private val name = itemView.findViewById<TextView>(R.id.name)


    var item: Alarm? = null

    fun bindTo(alarm: Alarm) {
        item = alarm

        time.text = alarm.time.toString()
        days.text = alarm.days.toString()
        name.text = alarm.name.toString()
    }
}