package com.wd.tech.presenter

import android.content.Context
import com.kotlinframework.net.network.IModelCallback
import com.wd.tech.bean.UserInfo
import com.wd.tech.contract.LoginContract
import com.wd.tech.model.LoginModel

class LoginPresenter:LoginContract.ILoginPresenter{
    lateinit var loginModel: LoginModel
    lateinit var iLoginView: LoginContract.ILoginView
    override fun login(parmas: HashMap<String, String>, context: Context) {
        loginModel.login(context,parmas,object :IModelCallback<UserInfo>{
            override fun failure(string: String) {
                iLoginView?.Failure(string)
            }
            override fun sucess(data: UserInfo) {
                iLoginView?.Success(data)
            }
        })
    }
    /**
     * 绑定view
     */
    fun attach(iLoginView: LoginContract.ILoginView){
        this.iLoginView=iLoginView
        loginModel= LoginModel()
    }
    /**
     * 解绑
     */
    fun dattach(){
        if (iLoginView!=null){
            iLoginView==null
        }
    }
}