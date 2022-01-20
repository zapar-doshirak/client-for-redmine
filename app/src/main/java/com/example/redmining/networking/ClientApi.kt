package com.example.redmining.networking

import com.example.redmining.responses.AccountResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import retrofit2.http.Url

interface ClientApi {

    @FormUrlEncoded
    @POST("/my/account.json")
    suspend fun login(
        @Url clientUrl: String,
        @Field("email") email: String,
        @Field("password") password: String
    ): AccountResponse

}