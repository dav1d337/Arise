package com.example.arise.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.arise.Alarm
import com.example.arise.SchedulerFacade
import com.example.arise.db.RoomAlarmRepository
import com.example.arise.ui.utils.BaseViewModel
import javax.inject.Inject

class MainViewModel
@Inject
constructor(schedulerFacade: SchedulerFacade,
            private val repo: RoomAlarmRepository
) : BaseViewModel(schedulerFacade) {

    private val _alarms = MutableLiveData<List<Alarm>>()

    val alarms: LiveData<List<Alarm>>
        get() {
            return _alarms
        }


    init {
        subscribeToFlowable(repo.getAll()) {
            Log.i("hallo", it.size.toString())
            _alarms.value = it
        }
    }

    fun insert(alarm: Alarm) {
        repo.insert(alarm).subscribeOn(schedulerFacade.io).blockingFirst()
    }

}