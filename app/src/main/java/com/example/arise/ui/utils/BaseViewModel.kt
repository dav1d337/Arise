package com.example.arise.ui.utils

import androidx.lifecycle.ViewModel
import android.util.Log
import com.example.arise.SchedulerFacade
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy

open class BaseViewModel(protected val schedulerFacade: SchedulerFacade) : ViewModel() {

    protected val subscriptions = CompositeDisposable()


    override fun onCleared() {
        super.onCleared()
        subscriptions.clear()
    }


    protected fun <T: Any>subscribeToFlowable(flowable: Flowable<T>, callback: (T) -> Unit)
    {
        flowable
                .subscribeOn(schedulerFacade.io)
                .observeOn(schedulerFacade.ui)
                .subscribeBy(
                        onNext = {
                            callback(it)
                        },
                        onError = {
                            Log.e("BaseViewModel", it.message, it)
                        }
                ).addTo(subscriptions)
    }

    protected fun <T: Any>subscribeToObservable(observable: Observable<T>, callback: (T) -> Unit)
    {
        observable
                .observeOn(schedulerFacade.ui)
                .subscribeBy(
                        onNext = {
                            callback(it)
                        },
                        onError = {
                            Log.e("BaseViewModel", it.message, it)
                        }
                ).addTo(subscriptions)
    }

    protected fun subscribeToCompletable(completable: Completable, callback: () -> Unit){
        completable
                .subscribeOn(schedulerFacade.io)
                .observeOn(schedulerFacade.ui)
                .subscribeBy(
                        onComplete = {
                            callback()
                        },
                        onError = {
                            Log.e("BaseViewModel", it.message, it)
                        }
                ).addTo(subscriptions)
    }
}