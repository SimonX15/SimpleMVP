package com.simon.app.simplemvp.mvp.view

import com.simon.app.simplemvp.mvp.bean.UserBean

/**
 * desc:
 *
 * auther: xw
 *
 * date: 2018/3/15
 *
 * @auther: xw
 */
interface ILoginView {
    fun getUsername(): String //获取用户的账号，返回账号

    fun getPassword(): String //获取用户的莫玛，返回密码

    fun showLoading() //show loading

    fun hideLoading() //hide loading

    fun loginSuccess(user: UserBean) //登录的实现，需要传入用户对象

    fun loginFailure() //信息验证失败,账号或密码有误
}