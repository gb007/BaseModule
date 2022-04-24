package com.hollysmart.basemodule.base

import com.hollysmart.myfirstkotlin.base.IBaseView


/**
 * @author gbin
 * Created 2022/01/10.
 * desc: Presenter 基类
 */


interface IPresenter<in V: IBaseView> {

    fun attachView(mRootView: V)

    fun detachView()

}
