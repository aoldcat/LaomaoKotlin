package com.laomao.kt.mvp.contract

import com.laomao.kt.bean.Blog
import com.laomao.kt.bean.JsonResult
import com.laomao.kt.bean.LeanResult
import com.laomao.kt.mvp.model.BlogModel
import rx.Observable

/**
 * Created by laomao on 2017/6/5.
 */
interface BlogContract {
    interface View{
        fun onBlog(listBlog:List<Blog>)
    }
    interface Model{
        fun getBlog():Observable<LeanResult<List<Blog>>>
    }
    interface Presenter{
        fun getBlog()
    }
}