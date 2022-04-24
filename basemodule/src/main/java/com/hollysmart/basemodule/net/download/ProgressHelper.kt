package com.hollysmart.basemodule.net.download

import android.util.Log
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import java.io.IOException


object ProgressHelper {
    private val progressBean: ProgressBean = ProgressBean()
    private var mProgressHandler: ProgressHandler? = null
    fun addProgress(builder: OkHttpClient.Builder?): OkHttpClient.Builder? {
        var builder: OkHttpClient.Builder? = builder
        if (builder == null) {
            builder = OkHttpClient.Builder()
        }
        val progressListener: ProgressListener = object : ProgressListener {
            //该方法在子线程中运行
            override fun onProgress(progress: Long, total: Long, done: Boolean) {
                Log.d("progress:", String.format("%d%% done\n", 100 * progress / total))
                if (mProgressHandler == null) {
                    return
                }
                progressBean.bytesRead = progress
                progressBean.contentLength =total
                progressBean.isDone = done
                mProgressHandler!!.sendMessage(progressBean)
            }
        }

        //添加拦截器，自定义ResponseBody，添加下载进度
        builder.networkInterceptors().add(object : Interceptor {
            @Throws(IOException::class)
            override fun intercept(chain: Interceptor.Chain): Response {
                val originalResponse: Response = chain.proceed(chain.request())
                return originalResponse.newBuilder().body(
                    ProgressResponseBody(originalResponse.body!!, progressListener)
                )
                    .build()
            }
        })
        return builder
    }

    fun setProgressHandler(progressHandler: ProgressHandler?) {
        mProgressHandler = progressHandler
    }
}