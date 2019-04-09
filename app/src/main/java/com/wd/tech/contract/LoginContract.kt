package com.wd.tech.contract

import android.content.Context
import com.kotlinframework.net.network.IModelCallback
import com.wd.tech.bean.UserInfo

interface LoginContract {
    interface ILoginPresenter{
        fun login(parmas:HashMap<String,String>,context: Context)
    }
    interface ILoginModel{
        fun login(context: Context,params:HashMap<String,String>,modelCallback: IModelCallback<UserInfo>)
    }
    interface ILoginView{
        fun Success(userInfo:UserInfo)
        fun Failure(string: String)
    }
}