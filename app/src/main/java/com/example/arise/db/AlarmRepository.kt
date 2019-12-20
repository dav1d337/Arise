package com.example.arise.db

import com.example.arise.Alarm
import io.reactivex.Completable
import io.reactivex.Flowable

interface AlarmRepository {
    fun getAll(): Flowable<List<Alarm>>

    fun insert(alarm: Alarm): Flowable<Long>

    fun delete(alarm: Alarm): Completable

    fun update(alarm: Alarm): Completable
}