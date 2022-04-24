package com.hollysmart.myfirstkotlin.common

object AppConst {


    lateinit var HTTP_TOKEN: String

    //服务间隔重复时间
    const val ELAPSED_TIME: Long = 1000

    //查询后台运行服务的最大查询数量
    const val RETRIEVE_SERVICE_COUNT = 50

    //系统设置SharedPreferences
    const val SHARE_PREFRENCE_SYS_CONFIG = "sysConfig"

    //服务器ip和端口配置
    const val SHARE_PREFRENCE_SYS_CONFIG_SERVER = "sysConfig_Server"

    //用户id
    const val SHARE_PREFRENCE_USER_INFO = "user_info"

    //http协议
    const val API_HTTP = "http://"

    //https协议
    const val API_HTTPS = "https://"

    //服务器IP + Port
    var API_SERVER_URL = "http://10.2.9.150:8885"

    //默认的超时时间
    const val DEFAULT_TIMEOUT = 60000



    //RequestHeader参数encrypt
    const val REQUEST_HEDER_ENCRYPT = "0"

    //RequestHeader参数compress
    const val REQUEST_HEDER_COMPRESS = "0"

    //Transaction参数error_code
    const val TRANSACTION_ERROR_CODE = "0"

    //Transaction参数error_message
    const val TRANSACTION_ERROR_MESSAGE = "success"

    //默认两次点击事件间隔
    const val EXITTIME = 200

    //屏幕触摸移动超过25px为移动，否则时touch事件
    const val MOVE_EVENT_DISTANCE = 25



}