package com.example.arise.ui.main

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.arise.Alarm
import com.example.arise.R
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.alarm_item.view.*

class AlarmAdapter(private val alarms: ArrayList<Alarm>) : RecyclerView.Adapter<AlarmAdapter.AlarmViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = AlarmViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.alarm_item,parent,false)
    )

    override fun getItemCount(): Int = alarms.size

    override fun onBindViewHolder(holder: AlarmViewHolder, position: Int) {
        holder.bind(alarms[position])
    }

    fun update(newAlarms: List<Alarm>) {
        alarms.clear()
        alarms.addAll(newAlarms)
        notifyDataSetChanged()
    }

    class AlarmViewHolder(private val view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {

        private var alarm: Alarm? = null

        init {
            view.setOnClickListener(this)
        }

        fun bind(alarm: Alarm) {
            this.alarm = alarm
            view.time.text = alarm.time.toString()
            view.name.text = alarm.name.toString()
            view.days.text = alarm.days.toString()
        }

        //4
        override fun onClick(v: View) {
            val context = itemView.context
       //     val showPhotoIntent = Intent(context, PhotoActivity::class.java)
         //   showPhotoIntent.putExtra(PHOTO_KEY, photo)
            //context.startActivity(showPhotoIntent)
            Log.i("RecyclerView", "hallo CLICK!")
        }
    }

}