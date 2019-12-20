package com.example.arise

import io.reactivex.schedulers.Schedulers
import io.reactivex.android.schedulers.AndroidSchedulers

class AndroidSchedulerFacade : SchedulerFacade {
    override val io: io.reactivex.Scheduler
        get() {
            return Schedulers.io()
        }

    override val ui: io.reactivex.Scheduler
        get() {
            return AndroidSchedulers.mainThread()
        }
}