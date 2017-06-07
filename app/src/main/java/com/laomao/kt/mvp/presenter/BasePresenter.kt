package com.laomao.kt.mvp.presenter

import rx.Subscription
import rx.subscriptions.CompositeSubscription
import rx.subscriptions.SerialSubscription

/**
 * Created by laomao on 2017/6/5.
 */
open class BasePresenter {
    var compositeSubscription=CompositeSubscription()
    protected fun addSubscription(subscription: Subscription){
        compositeSubscription.add(subscription)
    }
    fun unSubscribe(){
        if (compositeSubscription.hasSubscriptions())
            compositeSubscription.unsubscribe()
    }
}