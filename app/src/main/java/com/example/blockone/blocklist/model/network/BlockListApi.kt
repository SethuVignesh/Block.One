package com.example.blockone.blocklist.model.network

import com.example.blockone.blocklist.model.pojo.Block
import com.example.blockone.blocklist.model.pojo.BlockRequest
import com.example.blockone.blocklist.model.pojo.EOSHeadBlockResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface BlockListApi {
    @POST(".")
    fun getBlockList(): Single<Response<EOSHeadBlockResponse>>

//    @POST("/v1/chain/get_block")
//    fun getBlock(@Body blockRequest: BlockRequest): Call<Block>

    @POST("/v1/chain/get_block")
    fun getBlock(@Body blockRequest: BlockRequest): Single<Response<Block>>

}