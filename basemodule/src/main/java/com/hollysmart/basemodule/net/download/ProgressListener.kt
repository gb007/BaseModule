package com.hollysmart.basemodule.net.download

interface ProgressListener {

    /**
     * @param progress  已经下载或上传字节数
     * @param total  总字节数
     * @param done   是否完成
     */
    fun onProgress(progress: Long, total: Long, done: Boolean)

}