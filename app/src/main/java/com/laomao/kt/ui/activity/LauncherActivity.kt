package com.laomao.kt.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_launcher.*

import com.laomao.kt.R
import com.laomao.kt.base.BaseActivity
import com.laomao.kt.bean.Blog
import com.laomao.kt.di.component.BlogModule
import com.laomao.kt.mvp.contract.BlogContract
import com.laomao.kt.mvp.presenter.BlogPresenter
import com.laomao.kt.utils.getMainComponent
import com.laomao.kt.utils.showToast
import javax.inject.Inject

class LauncherActivity : BaseActivity(), BlogContract.View {
    @Inject lateinit var mPresenter: BlogPresenter
    override fun onBlog(listBlog: List<Blog>) {
        showToast(listBlog.toString())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)
        getMainComponent().plus(BlogModule(this)).inject(this)
        tvLauncherMsg.text = "我是闪屏文字"
//        mPresenter.getBlog()


    }
}
