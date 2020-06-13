package com.example.blockone.model.network

import com.example.blockone.model.pojo.*
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface BlockListApi {
    @POST(".")
    fun getHeadBlock(): Single<EOSHeadBlockResponse>

    @Headers(
        "Content-Type: application/json;charset=utf-8",
        "Accept: application/json"
    )
    @POST("/v1/chain/get_block")
    fun getBlockString(@Body blockRequest: BlockRequest): Single<String>


    @Headers(
        "Content-Type: application/json;charset=utf-8",
        "Accept: application/json"
    )
    @POST("/v1/chain/get_account")
    fun getAccount(@Body accountRequest: AccountRequest): Single<AccountDetailsResponse>

}