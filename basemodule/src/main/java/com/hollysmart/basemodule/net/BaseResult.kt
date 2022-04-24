package com.hollysmart.basemodule.net


import java.io.Serializable

data class BaseResult(
    val transStatus: String,
    val transCode: String,
    val transErrorCode: String,
    val transErrorMessage: String,
    val info: String
) : Serializable
