package com.example.arise.db


import android.util.Log
import com.example.arise.Alarm
import com.example.arise.di.ApplicationScope
import io.reactivex.Completable
import io.reactivex.Flowable
import javax.inject.Inject

@ApplicationScope
class RoomAlarmRepository @Inject
constructor(private val dao: RoomAlarmDao): AlarmRepository {

    init {

    }

    override fun getAll(): Flowable<List<Alarm>> {
        return dao.getAll()
    }

    override fun insert(alarm: Alarm): Flowable<Long> {
        Log.i("hallo", alarm.toString())
        return  Flowable.fromCallable{
            dao.insert(alarm)
        }
    }

    override fun delete(alarm: Alarm): Completable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun update(alarm: Alarm): Completable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}