package com.laomao.kt.di.component

import com.laomao.kt.KtApplication
import com.laomao.kt.di.module.ApiModule
import dagger.Component

/**
 * Created by laomao on 2017/6/5.
 */
@Component(modules = arrayOf(ApiModule::class))
interface ApiComponent {
    fun inject(app:KtApplication)

    fun plus(moudle:BlogModule):BlogComponent
}