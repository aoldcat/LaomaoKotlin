package com.laomao.kt

import android.app.Application
import com.laomao.kt.di.component.ApiComponent
import com.laomao.kt.di.component.DaggerApiComponent
import com.laomao.kt.di.module.ApiModule
import com.laomao.kt.di.module.AppModule
import javax.inject.Inject

/**
 * Created by laomao on 2017/6/5.
 */
class KtApplication : Application() {
    @Inject lateinit var apiCompenent:ApiComponent
    companion object{
        lateinit var instance:KtApplication
    }
    init {
        instance=this
    }

    override fun onCreate() {
        super.onCreate()
        DaggerApiComponent.builder().apiModule(ApiModule()).appModule(AppModule(this)).build().inject(this)
    }
}