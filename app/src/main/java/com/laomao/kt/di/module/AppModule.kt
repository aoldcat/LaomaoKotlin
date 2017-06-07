package com.laomao.kt.di.module

import android.content.Context
import dagger.Module
import dagger.Provides

/**
 * Created by laomao on 2017/6/1.
 */
@Module
class AppModule(private val context: Context){
    @Provides fun provideContext()=context
}
