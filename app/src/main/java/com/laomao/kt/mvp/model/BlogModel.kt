package com.laomao.kt.mvp.model

import com.laomao.kt.api.LaomaoApi
import com.laomao.kt.bean.Blog
import com.laomao.kt.bean.JsonResult
import com.laomao.kt.mvp.contract.BlogContract
import rx.Observable
import javax.inject.Inject

/**
 * Created by laomao on 2017/6/5.
 */
class BlogModel
   @Inject constructor(private val api:LaomaoApi):BlogContract.Model{
    override fun getBlog(): Observable<JsonResult<List<Blog>>> {
        return api.getBlog()
    }
}
