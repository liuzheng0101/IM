package com.wd.tech.model

import android.content.Context
import com.kotlinframework.net.network.*
import com.wd.tech.api.Api
import com.wd.tech.api.LoginApiService
import com.wd.tech.bean.UserInfo
import com.wd.tech.contract.LoginContract

class LoginModel:LoginContract.ILoginModel {
    override fun login(
            context: Context,
            params: HashMap<String, String>,
            modelCallback:IModelCallback<UserInfo>
        ) {
        RetrofitManager.instance.createService(LoginApiService::class.java).login(Api.LOGIN_URL,params)
                .compose(NetScheduler.compose())
                .subscribe(object : NetResponseObserver<UserInfo>(context){
                    override fun success(data: UserInfo) {
                        modelCallback?.sucess(data)
                    }
                    override fun failure(statusCode: Int, apiErrorModel: ApiErrorModel) {
                        modelCallback?.failure(apiErrorModel.message)
                    }

                })
    }
}