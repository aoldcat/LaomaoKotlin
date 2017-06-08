package com.laomao.kt.mvp.presenter

import android.util.Log
import com.laomao.kt.bean.Blog
import com.laomao.kt.mvp.contract.BlogContract
import com.laomao.kt.mvp.model.BlogModel
import rx.android.schedulers.AndroidSchedulers
import javax.inject.Inject

/**
 * Created by laomao on 2017/6/5.
 */
class BlogPresenter
@Inject constructor(private val mModel: BlogModel, private val mView: BlogContract.View) : BlogContract.Presenter, BasePresenter() {
    override fun getBlog() {
        addSubscription(mModel.getBlog().observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    res ->
//                    if (!res.error)
                        mView.onBlog(res.results)
                }, {
                   e->Log.e("error",e.message)
                }))
    }
}