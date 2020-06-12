package com.example.blockone.model.network

import com.example.blockone.model.pojo.AccountRequest
import com.example.blockone.model.pojo.Block
import com.example.blockone.model.pojo.BlockRequest
import com.example.blockone.model.pojo.EOSHeadBlockResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface BlockListApi {
    @POST(".")
    fun getBlockList(): Single<Response<EOSHeadBlockResponse>>


    @Headers(
        "Content-Type: application/json;charset=utf-8",
        "Accept: application/json"
    )
    @POST("/v1/chain/get_block")
    fun getBlock(@Body blockRequest: BlockRequest): Single<Response<Block>>


}