package com.example.arise

import io.reactivex.Scheduler

interface SchedulerFacade {

    val io: Scheduler
    val ui: Scheduler
}

