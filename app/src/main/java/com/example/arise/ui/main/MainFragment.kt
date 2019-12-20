package com.example.arise.ui.main

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.arise.Alarm
import com.example.arise.R
import com.example.arise.extensions.ariseComponent
import com.example.arise.ui.utils.BaseFragment
import kotlinx.android.synthetic.main.create_alarm_dialog.*
import kotlinx.android.synthetic.main.main_fragment.*


class MainFragment : BaseFragment<MainViewModel>() {

    private val adapter = AlarmAdapter(arrayListOf())

    override fun inject() = ariseComponent().inject(this)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)

        viewModel.alarms.observe(this, Observer {alarms ->
            alarms?.let {
                adapter.update(it)
            }
        })

        floatingActionButton.setOnClickListener {
            val dialog = Dialog(context!!)
            dialog.setTitle("Create Alarm")
            dialog.setContentView(R.layout.create_alarm_dialog)
            dialog.timePicker.setIs24HourView(true)
            dialog.title.setImeActionLabel("Custom text", KeyEvent.KEYCODE_ENTER)

            dialog.cancelButton.setOnClickListener{
                dialog.onBackPressed()
            }

            dialog.saveButton.setOnClickListener{
                val hour = dialog.timePicker.hour
                val minute = dialog.timePicker.minute
                val timeInput = String.format("%02d:%02d", hour, minute)
                val newAlarm = Alarm(dialog.title.text.toString(),timeInput,   2, false)
                viewModel.insert(newAlarm)
                dialog.onBackPressed()
            }

            dialog.show()
            val width = (resources.displayMetrics.widthPixels * 0.85).toInt()
            val height = (resources.displayMetrics.heightPixels * 0.85).toInt()

            dialog.getWindow()!!.setLayout(width, height)
         //   findNavController().navigate(R.id.main_to_create)
        }
    }
}