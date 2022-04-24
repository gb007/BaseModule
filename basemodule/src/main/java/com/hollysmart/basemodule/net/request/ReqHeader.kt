package com.hollysmart.basemodule.net.request

data class ReqHeader(
    var ver: String, var user_id: String, var encrypt: String, var compress: String,
    var mac: String?
)
