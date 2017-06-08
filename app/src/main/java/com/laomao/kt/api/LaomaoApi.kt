package com.laomao.kt.api

import com.laomao.kt.bean.Blog
import com.laomao.kt.bean.JsonResult
import retrofit2.http.GET
import rx.Observable

/**
 * Created by laomao on 2017/6/5.
 */
interface LaomaoApi {
    //1111
    @GET("classes/blogs")
    fun getBlog():Observable<JsonResult<List<Blog>>>
}