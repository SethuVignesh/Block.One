package com.example.blockone.model

import com.example.blockone.model.network.BlockListApi
import com.example.blockone.model.pojo.Block
import com.example.blockone.model.pojo.BlockRequest
import com.example.blockone.model.pojo.EOSHeadBlockResponse
import io.reactivex.rxjava3.core.Single
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class BlockListRepository() {
    var BaseUrl = "https://eos.greymass.com"
    val retrofit = Retrofit.Builder()
        .baseUrl(BaseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .client(OkHttpClient.Builder().build())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build()
    val service = retrofit.create(BlockListApi::class.java)

    internal fun getCurrentData(): Single<Response<EOSHeadBlockResponse>> {
        return service.getBlockList()
    }

    internal fun getBlockDetails(blockRequest: BlockRequest): Single<Response<Block>> {
        return service.getBlock(blockRequest)
    }
}