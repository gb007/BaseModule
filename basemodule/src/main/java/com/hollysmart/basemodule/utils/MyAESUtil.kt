package com.hollysmart.myfirstkotlin.util

import android.util.Base64
import android.util.Log
import java.lang.Exception
import java.nio.charset.StandardCharsets
import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec


/**
 * java使用AES加密解密 AES-128-ECB加密
 * 与mysql数据库aes加密算法通用
 * 数据库aes加密解密
 * -- 加密
 * SELECT to_base64(AES_ENCRYPT('www.gowhere.so','jkl;POIU1234++=='));
 * -- 解密
 * SELECT AES_DECRYPT(from_base64('Oa1NPBSarXrPH8wqSRhh3g=='),'jkl;POIU1234++==');
 *
 * @author 836508
 */
object MyAESUtil {
    const val KEY = "7f1e80ff871040c1bf8ec37214ca3c51"

    /**
     * 采用AES加密算法
     */
    private const val KEY_ALGORITHM = "AES"

    /**
     * 字符编码(用哪个都可以，要注意new String()默认使用UTF-8编码 getBytes()默认使用ISO8859-1编码)
     */
    private val CHARSET_UTF8 = StandardCharsets.UTF_8

    /**
     * 加解密算法/工作模式/填充方式
     */
    private const val CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding"

    /**
     * AES 加密
     *
     * @param secretKey 加密密码，长度：16 或 32 个字符
     * @param data      待加密内容
     * @return 返回Base64转码后的加密数据
     */
    fun encrypt(secretKey: String, data: String): String? {
        try {
            // 创建AES秘钥
            val secretKeySpec = SecretKeySpec(secretKey.toByteArray(CHARSET_UTF8), KEY_ALGORITHM)
            // 创建密码器
            val cipher = Cipher.getInstance(CIPHER_ALGORITHM)
            // 初始化加密器
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec)
            val encryptByte = cipher.doFinal(data.toByteArray(CHARSET_UTF8))
            // 将加密以后的数据进行 Base64 编码
            return base64Encode(encryptByte)
        } catch (e: Exception) {
            handleException("encrypt", e)
        }
        return null
    }

    /**
     * AES 解密
     *
     * @param secretKey  解密的密钥，长度：16 或 32 个字符
     * @param base64Data 加密的密文 Base64 字符串
     */
    fun decrypt(secretKey: String, base64Data: String?): String? {
        try {
            val data = base64Decode(base64Data)
            // 创建AES秘钥
            val secretKeySpec = SecretKeySpec(secretKey.toByteArray(CHARSET_UTF8), KEY_ALGORITHM)
            // 创建密码器
            val cipher = Cipher.getInstance(CIPHER_ALGORITHM)
            // 初始化解密器
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec)
            // 执行解密操作
            val result = cipher.doFinal(data)
            return String(result, CHARSET_UTF8)
        } catch (e: Exception) {
            handleException("decrypt", e)
        }
        return null
    }

    /**
     * 将 字节数组 转换成 Base64 编码
     * 用Base64.DEFAULT模式会导致加密的text下面多一行（在应用中显示是这样）
     */
    fun base64Encode(data: ByteArray?): String {
        return Base64.encodeToString(data, Base64.NO_WRAP)
    }

    /**
     * 将 Base64 字符串 解码成 字节数组
     */
    fun base64Decode(data: String?): ByteArray {
        return Base64.decode(data, Base64.NO_WRAP)
    }

    /**
     * 处理异常
     */
    private fun handleException(methodName: String, e: Exception) {
        e.printStackTrace()
        Log.e("com.test", "$methodName---->$e")
    }
}