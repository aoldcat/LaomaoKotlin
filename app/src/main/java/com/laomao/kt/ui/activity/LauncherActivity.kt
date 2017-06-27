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
import com.laomao.ktlib.MYEDIT
import javax.inject.Inject

class LauncherActivity : BaseActivity(), BlogContract.View {
    @Inject lateinit var mPresenter: BlogPresenter
    override fun onBlog(listBlog: List<Blog>) {
//        showToast(listBlog.toString())
//        tvLauncherMsg.text=listBlog.toString()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)
        getMainComponent().plus(BlogModule(this)).inject(this)
        tvLauncherMsg.text = "我是闪屏文字"
//        mPresenter.getBlog()

        myEdittext.setInitText("1","2","5","9")

        btnLeft.setOnClickListener { myEdittext.setFoucesLeft() }
        btnRight.setOnClickListener { myEdittext.setFoucesRight() }
        btn0.setOnClickListener { myEdittext.setFoucesText(btn0.text as String?) }
        btn1.setOnClickListener { myEdittext.setFoucesText(btn1.text as String?) }
        btn2.setOnClickListener { myEdittext.setFoucesText(btn2.text as String?) }
        btn3.setOnClickListener { myEdittext.setFoucesText(btn3.text as String?) }
    }
}
