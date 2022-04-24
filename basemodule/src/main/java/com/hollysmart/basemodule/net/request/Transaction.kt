package com.hollysmart.basemodule.net.request

data class Transaction(
    var code: String, var time: String, var sequence: String, var error_code: String,
    var error_msg: String
)
