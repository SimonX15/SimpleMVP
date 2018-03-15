package com.simon.app.simplemvp.mvp.bean

/**
 * desc: 用户信息
 *
 * auther: xw
 *
 * date: 2018/3/15
 *
 * @auther: xw
 */
data class UserBean(
        var username: String,
        var name: String,
        var age: Int? = 0,
        var phone: String? = null,
        var address: String? = null
)