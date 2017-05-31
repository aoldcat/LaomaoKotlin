package com.laomao.ktlib

import android.app.Activity
import android.support.annotation.IdRes
import android.view.View

/**
 * Created by laomao on 2017/5/31.
 */
inline fun <reified T: View> Activity.findview(@IdRes id:Int):T=findViewById(id) as T