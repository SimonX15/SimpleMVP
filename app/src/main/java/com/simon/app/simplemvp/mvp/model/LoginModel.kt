package com.simon.app.simplemvp.mvp.model

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.simon.app.simplemvp.mvp.bean.UserBean
import kotlin.concurrent.thread

/**
 * desc:
 *
 * auther: xw
 *
 * date: 2018/3/15
 *
 * @auther: xw
 */
class LoginModel {

    fun login(context: Context, username: String, password: String, onLoginListener: OnLoginListener) {
        thread {
            Thread.sleep(2000)
            if (username == "simon" && password == "12345678") {
                val user = UserBean("simon", "SimonW")
                onLoginListener.loginSuccess(user)
            }
            onLoginListener.loginFailed()
        }
    }

    companion object {
        /** TAG  */
        private val TAG = LoginModel::class.java.simpleName
    }
}