package com.simon.app.simplemvp

import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.simon.app.simplemvp.mvp.bean.UserBean
import com.simon.app.simplemvp.mvp.presenter.LoginPresenter
import com.simon.app.simplemvp.mvp.view.ILoginView
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), ILoginView {

    var loginPresenter: LoginPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginPresenter = LoginPresenter(this@LoginActivity, this)

        btn_login.setOnClickListener {
            tv_error.visibility = View.GONE
            loginPresenter!!.login()
        }
    }

    override fun getUsername(): String {
        return et_username.text.toString()
    }

    override fun getPassword(): String {
        return et_password.text.toString()
    }

    override fun showLoading() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progressBar.visibility = View.GONE
    }

    override fun loginSuccess(user: UserBean) {
        Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show()
        MainActivity.launch(this)
    }

    override fun loginFailure() {
        Toast.makeText(this, "登录失败", Toast.LENGTH_SHORT).show()
        tv_error.visibility = View.VISIBLE
    }
}
