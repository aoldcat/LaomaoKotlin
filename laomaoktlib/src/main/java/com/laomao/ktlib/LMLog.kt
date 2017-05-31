package com.laomao.ktlib

import android.util.Log

/**
 * Created by laomao on 2017/5/27.
 * 扩展Log,代替LogUtil
 */
private val Any.logTag: String
    get() = javaClass.simpleName

inline fun logv(logTag: String, msg: String) = Log.v(logTag, msg)
inline fun logd(logTag: String, msg: String) = Log.d(logTag, msg)
inline fun logi(logTag: String, msg: String) = Log.i(logTag, msg)
inline fun loge(logTag: String, msg: String) = Log.e(logTag, msg)
inline fun logw(logTag: String, msg: String) = Log.w(logTag, msg)
inline fun logwtf(logTag: String, msg: String) = Log.wtf(logTag, msg)

fun Any.logv(msg: String) = logv(logTag, msg)
fun Any.logd(msg: String) = logd(logTag, msg)
fun Any.logi(msg: String) = logi(logTag, msg)
fun Any.loge(msg: String) = loge(logTag, msg)
fun Any.logw(msg: String) = logw(logTag, msg)
fun Any.logwtf(msg: String) = logwtf(logTag, msg)


fun Any.logv(msg: () -> String) {
    if (Log.isLoggable(logTag, Log.VERBOSE)) logv(msg())
}

fun Any.logi(msg: () -> String) {
    if (Log.isLoggable(logTag, Log.INFO)) logi(msg())
}

fun Any.logd(msg: () -> String) {
    if (Log.isLoggable(logTag, Log.DEBUG)) logd(msg())
}

fun Any.loge(msg: () -> String) {
    if (Log.isLoggable(logTag, Log.ERROR)) loge(msg())
}

fun Any.logw(msg: () -> String) {
    if (Log.isLoggable(logTag, Log.WARN)) logw(msg())
}





