package com.wd.tech

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.wd.tech.bean.UserInfo
import com.wd.tech.contract.LoginContract
import com.wd.tech.presenter.LoginPresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),LoginContract.ILoginView, View.OnClickListener {
    lateinit var loginPresenter: LoginPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        initData()
    }
    private fun initView() {
        login.setOnClickListener(this)

    }
    private fun initData() {
        loginPresenter = LoginPresenter()
    }
    fun login() {
        var params=HashMap<String,String>()
        params.put("phone",ed_phone.text.toString())
        params.put("pwd",ed_pass.text.toString())

        loginPresenter.attach(this)

        loginPresenter.login(params,this)
    }
    override fun Failure(string: String) {
        Toast.makeText(this,string,Toast.LENGTH_SHORT).show()
    }
    override fun Success(userInfo: UserInfo) {
        Toast.makeText(this,userInfo.message,Toast.LENGTH_SHORT).show()
    }
    /**
     * 销毁
     */
    override fun onDestroy() {
        super.onDestroy()
        loginPresenter.dattach()
    }
    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.login->login()
        }
    }
}