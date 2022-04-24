package com.hollysmart.basemodule.net.request

import com.hollysmart.basemodule.net.request.ReqBody
import com.hollysmart.basemodule.net.request.ReqHeader
import com.hollysmart.basemodule.net.request.Transaction

data class RequestMessage(
    val header: ReqHeader,
    val transaction: Transaction,
    val systemTime: String?,
    val body: ReqBody
)
