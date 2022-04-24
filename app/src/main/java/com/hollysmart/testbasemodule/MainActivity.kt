package com.hollysmart.testbasemodule

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Base64
import android.view.View
import android.widget.ImageView
import com.hollysmart.myfirstkotlin.common.AppConst
import com.hollysmart.testbasemodule.mvp.contract.RandomImageContract
import com.hollysmart.testbasemodule.mvp.model.bean.RandomImageBean
import com.hollysmart.testbasemodule.mvp.presenter.RandomImagePresenter
import java.lang.Exception
import java.util.*

class MainActivity : AppCompatActivity(), RandomImageContract.View {

    private lateinit var imgage: ImageView


    private val mPresenter by lazy { RandomImagePresenter() }

    init {
        mPresenter.attachView(this)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imgage = findViewById(R.id.imageView);
        imgage.setOnClickListener(View.OnClickListener {
            getRandomImage()
        })
        getRandomImage()
    }

    fun getRandomImage() {

        var time = Date().time.toString()

        AppConst.API_SERVER_URL = AppConst.API_HTTP + "202.105.247.39:8885"
        val params = mutableMapOf<String, String>()
        params["_t"] = time
        mPresenter.getRandomImage(time, params)

    }

    override fun showRandomImage(randomImage: RandomImageBean) {
        var base64_image = randomImage.result.substring(22)
        imgage.setImageBitmap(stringtoBitmap(base64_image))
    }

    override fun showError(errorMsg: String, errorCode: Int) {

    }

    override fun showLoading() {

    }

    override fun showLoadingSuccess() {

    }

    override fun showLoadingFailed() {

    }


    private fun stringtoBitmap(base64: String?): Bitmap? {
        //将字符串转换成Bitmap类型
        var bitmap: Bitmap? = null
        try {
            val bitmapArray: ByteArray = Base64.decode(base64, Base64.DEFAULT)
            bitmap = BitmapFactory.decodeByteArray(bitmapArray, 0, bitmapArray.size)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return bitmap
    }
}