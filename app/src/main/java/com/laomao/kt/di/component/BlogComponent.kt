package com.laomao.kt.di.component

import com.laomao.kt.mvp.contract.BlogContract
import com.laomao.kt.ui.activity.LauncherActivity
import dagger.Module
import dagger.Provides
import dagger.Subcomponent

/**
 * Created by laomao on 2017/6/5.
 */
@Subcomponent(modules= arrayOf(BlogModule::class))
interface BlogComponent {
    fun inject(activity:LauncherActivity)
}

@Module
class BlogModule(private val mView:BlogContract.View){
    @Provides fun getView()=mView

}