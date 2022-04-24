package com.hollysmart.myfirstkotlin.util

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.os.Build
import android.telephony.TelephonyManager
import android.util.Log
import com.google.gson.Gson
import com.hollysmart.myfirstkotlin.base.BaseApplication

import com.ut.device.UTDevice
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*

object AppUtil {


    /**
     * 获取设备ID
     *
     * @return 设备ID
     */

    @SuppressLint("MissingPermission")
    fun getDeviceId(context: Context): String {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            UTDevice.getUtdid(context)
        } else {
            val TelephonyMgr = BaseApplication.getAPPContext()
                .getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
            TelephonyMgr.deviceId
        }
    }







    /**
     * 获取当前时间
     * 格式 yyyy-MM-dd HH:mm:ss
     *
     */
    fun getCurTime(): String {
        val dataFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA)
        return dataFormat.format(Date())
    }

    /**
     * 获取当前时间
     * 格式 yyyyMMdd
     *
     */
    fun getCurDate(): String {
        val dataFormat = SimpleDateFormat("yyyyMMdd", Locale.CHINA)
        return dataFormat.format(Date())
    }

    /**
     * 获取当前时间
     * 格式 yyyyMMdd
     *
     */
    fun getCurDate(type:String): String {
        val dataFormat = SimpleDateFormat(type, Locale.CHINA)
        return dataFormat.format(Date())
    }
    /**
     * 获取versionName
     */
    fun getCurrentVersionName(): String{
        var version = ""
        try {
            val context: Context = BaseApplication.getAPPContext()
            val packageInfo = context.packageManager.getPackageInfo(
                context
                    .packageName, 0
            )
            version = packageInfo.versionName
        } catch (e: Exception) {
            e.printStackTrace()
        }
        Log.d("version::","version=$version")
        return version
    }

    /**
     * 获取versionCode
     */
    fun getCurrentVersionCode(): String {
        var versionCode = ""
        try {
            val context: Context = BaseApplication.getAPPContext()
            val packageInfo = context.packageManager.getPackageInfo(
                context
                    .packageName, 0
            )
            versionCode = "" + packageInfo.versionCode
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }
        return versionCode
    }




}