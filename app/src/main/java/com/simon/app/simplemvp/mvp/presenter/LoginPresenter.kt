package com.simon.app.simplemvp.mvp.presenter

import android.os.Handler
import com.simon.app.simplemvp.mvp.bean.UserBean
import com.simon.app.simplemvp.mvp.model.LoginModel
import com.simon.app.simplemvp.mvp.model.OnLoginListener
import com.simon.app.simplemvp.mvp.view.ILoginView

/**
 * desc: 登录 Presenter
 *
 * auther: xw
 *
 * date: 2018/3/15
 *
 * @auther: xw
 */
class LoginPresenter(private val iLoginView: ILoginView) {

    private val loginModel = LoginModel()

    var handler: Handler = Handler()

    fun login() {
        iLoginView.showLoading()

        loginModel.login(iLoginView.getUsername(), iLoginView.getPassword(), object : OnLoginListener {

            override fun loginSuccess(user: UserBean) {
                handler.post {
                    iLoginView.hideLoading()
                    iLoginView.loginSuccess(user)
                    handler.removeCallbacksAndMessages(null)
                }
            }

            override fun loginFailed() {
                handler.post {
                    iLoginView.hideLoading()
                    iLoginView.loginFailure()
                    handler.removeCallbacksAndMessages(null)
                }
            }
        })
    }


    companion object {
        /** TAG  */
        private val TAG = LoginPresenter::class.java.simpleName
    }
}