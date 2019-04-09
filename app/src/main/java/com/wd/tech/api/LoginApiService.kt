package com.wd.tech.api

import com.wd.tech.bean.UserInfo
import io.reactivex.Observable
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import retrofit2.http.Url

interface LoginApiService {
    @POST
    @FormUrlEncoded
    fun login(@Url string: String,@FieldMap params: HashMap<String,String>): Observable<UserInfo>
}