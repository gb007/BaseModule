package com.hollysmart.basemodule.net

import java.io.Serializable

/**
 *
 * 封装返回的数据
 */
data class BaseResponse(
    val result: BaseResult,
    val id:Int?
):Serializable