package com.example.blockone.model

import android.content.Context
import com.example.blockone.model.network.BlockListApi
import com.example.blockone.model.pojo.Block
import com.example.blockone.model.pojo.BlockRequest
import com.example.blockone.model.pojo.EOSHeadBlockResponse
import com.google.gson.GsonBuilder
import io.reactivex.rxjava3.core.Single
import okhttp3.OkHttpClient
import okio.Okio
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.io.IOException


class BlockListRepository() {
    var BaseUrl = "https://eos.greymass.com"
    val retrofit = Retrofit.Builder()
        .baseUrl(BaseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .client(OkHttpClient.Builder().build())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build()
    val retrofit2 = Retrofit.Builder()
        .baseUrl(BaseUrl)
        .addConverterFactory(ScalarsConverterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
//        .client(OkHttpClient.Builder().build())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build()

    val service = retrofit.create(BlockListApi::class.java)
    val service2 = retrofit2.create(BlockListApi::class.java)

    internal fun getCurrentData(): Single<Response<EOSHeadBlockResponse>> {
        return service.getBlockList()
    }

    internal fun getBlockDetails(
        blockRequest: BlockRequest
    ): Single<Response<Block>> {
        return service.getBlock(blockRequest)
//        return getFromAsset(context)
    }
    internal fun getBlockDetailsString(
        blockRequest: BlockRequest
    ): Single<Response<String>> {
        return service2.getBlockString(blockRequest)
    }

    private fun getFromAsset(context: Context): Single<Block> {
        val gson = GsonBuilder().create()
        return Single.just(gson.fromJson(getRequestJson(context), Block::class.java))
    }

    @Throws(IOException::class, NullPointerException::class)
    private fun getRequestJson(context: Context): String {
        val bs = Okio.buffer(Okio.source(context.assets.open("block")))
        return bs.readUtf8()
    }
}