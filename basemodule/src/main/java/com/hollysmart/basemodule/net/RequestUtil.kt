package com.hollysmart.basemodule.net

import com.google.gson.Gson
import com.hollysmart.basemodule.net.request.*
import com.hollysmart.myfirstkotlin.common.AppConst

import com.hollysmart.myfirstkotlin.util.AppUtil
import com.orhanobut.logger.Logger

import java.text.SimpleDateFormat
import java.util.*

object RequestUtil {


    fun getRequestMessage(reqMap: Map<*, *>, transactionCode: String, userId: String): String {

        val header = ReqHeader(
            AppUtil.getCurrentVersionName(),
            userId,
            AppConst.REQUEST_HEDER_ENCRYPT,
            AppConst.REQUEST_HEDER_COMPRESS,
            ""
        )
        val dataFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA)
        val time = dataFormat.format(Date())
        dataFormat.applyPattern("yyyyMMddHHmmss")
        val sequence = dataFormat.format(Date())
        val t = Transaction(
            transactionCode,
            time,
            sequence,
            AppConst.TRANSACTION_ERROR_CODE,
            AppConst.TRANSACTION_ERROR_MESSAGE
        )
        val body = ReqBody(reqMap, null)
        val requestMessage = RequestMessage(header, t, "", body)
        val jsonRequestMessage = JsonRequestMessage(requestMessage)
        val gson = Gson()
        val requestBody = gson.toJson(jsonRequestMessage)
        Logger.d("请求报文:$requestBody")
        return requestBody
    }


}