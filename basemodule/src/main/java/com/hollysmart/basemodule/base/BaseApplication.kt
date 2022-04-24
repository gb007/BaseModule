package com.hollysmart.myfirstkotlin.base

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import com.hjq.toast.ToastUtils
import com.hollysmart.myfirstkotlin.util.AppUtil
import com.orhanobut.logger.LogLevel
import com.orhanobut.logger.Logger



open class BaseApplication : Application() {

    companion object {
        lateinit private var context: Context

        fun getAPPContext() = context!!

    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
        initLogger()
        //ToastUtil初始化
        ToastUtils.init(this);
        initDB()
    }

    /**
     * 初始化日志
     */

    fun initLogger() {
        Logger.init("TicketApp").methodCount(1)
            .hideThreadInfo()
            .logLevel(LogLevel.NONE)
    }

    /**
     * 初始化数据库
     */
    fun initDB() {

    }




}