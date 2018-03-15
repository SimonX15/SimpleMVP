package com.simon.app.simplemvp.mvp.model

import com.simon.app.simplemvp.mvp.bean.UserBean

/**
 * desc: 登录 回调
 *
 * auther: xw
 *
 * date: 2018/3/15
 *
 * @auther: xw
 */
interface OnLoginListener {
    fun loginSuccess(user: UserBean)

    fun loginFailed()
}