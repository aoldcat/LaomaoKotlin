package com.laomao.kt.utils

import android.widget.Toast
import com.laomao.kt.base.BaseActivity

/**
 * Created by laomao on 2017/5/26.
 */
fun BaseActivity.extFun(string: String):String{
    return string+"ext"
}
fun BaseActivity.showToast(string:String){
    Toast.makeText(this,string,Toast.LENGTH_SHORT).show();
}