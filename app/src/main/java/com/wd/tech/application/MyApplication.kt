package com.wd.tech.application

import android.app.Application

import com.kotlinframework.net.network.RetrofitManager

import cn.jpush.android.api.JPushInterface
import com.wd.tech.api.Api

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        RetrofitManager.instance.init(Api.BASE_URL)
        JPushInterface.setDebugMode(true)
        JPushInterface.init(this)
    }
}
