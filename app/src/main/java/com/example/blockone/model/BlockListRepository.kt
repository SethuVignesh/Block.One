package com.example.blockone.model

import com.example.blockone.model.network.BlockListApi
import com.example.blockone.model.pojo.AccountDetailsResponse
import com.example.blockone.model.pojo.AccountRequest
import com.example.blockone.model.pojo.BlockRequest
import com.example.blockone.model.pojo.EOSHeadBlockResponse
import io.reactivex.rxjava3.core.Single
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory


class BlockListRepository() {
    var BaseUrl = "https://eos.greymass.com"

    val retrofit = Retrofit.Builder()
        .baseUrl(BaseUrl)
        .addConverterFactory(ScalarsConverterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .client(OkHttpClient.Builder().build())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build()

    val service = retrofit.create(BlockListApi::class.java)


    fun getHeadBlockRepo(): Single<EOSHeadBlockResponse> {
        return service.getHeadBlock()
    }

    fun getBlockDetailsString(
        blockRequest: BlockRequest
    ): Single<String> {
        return service.getBlockString(blockRequest)
    }

    fun getAccountDetail(
        accountRequest: AccountRequest
    ): Single<AccountDetailsResponse> {
        return service.getAccount(accountRequest)
    }

    /*private fun getFromAsset(context: Context): Single<Block> {
        val gson = GsonBuilder().create()
        return Single.just(gson.fromJson(getRequestJson(context), Block::class.java))
    }

    @Throws(IOException::class, NullPointerException::class)
    private fun getRequestJson(context: Context): String {
        val bs = Okio.buffer(Okio.source(context.assets.open("block")))
        return bs.readUtf8()
    }*/
}