package com.example.blockone.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.blockone.model.BlockListRepository
import com.example.blockone.model.pojo.Block
import com.example.blockone.model.pojo.BlockRequest
import com.example.blockone.model.pojo.EOSHeadBlockResponse
import com.google.gson.Gson
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers


class BlockListViewModel() : ViewModel() {

    val blockList: MutableLiveData<ArrayList<Block>> = MutableLiveData<ArrayList<Block>>()
    var blockListRepository: BlockListRepository =
        BlockListRepository()
    var showError: MutableLiveData<Boolean> = MutableLiveData<Boolean>()
    var selectedBlock: MutableLiveData<Block> = MutableLiveData<Block>()
    var headBlock: MutableLiveData<EOSHeadBlockResponse> = MutableLiveData<EOSHeadBlockResponse>()
    fun getHeadBlock() {
        blockListRepository.getCurrentData().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                if (it.isSuccessful) {

                    headBlock.value = it.body()
                } else {
                }
            }, {
                showError.value = true
            })

    }

    fun getBlockList(blockNumber: String?) {
        getBlockListString(blockNumber, 0)
        arrayList = ArrayList<Block>()
    }

    var arrayList: ArrayList<Block> = ArrayList()

    fun getBlockList(blockNumber: String?, count: Int) {
        getBlockListString(blockNumber, count)
        return

        if (count >= 20) {
            blockList.value = arrayList
            return
        }
        blockListRepository.getBlockDetails(

            BlockRequest(
                blockNumber
            )
        )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                if (it.isSuccessful) {
                    it.body()?.rawResponse
                    it.body()?.let {

                        arrayList.add(it)
                        getBlockList(it.previous, count + 1)
                    }
                } else {
                    blockList.value = arrayList
                    showError.value = true
                }
            }, {
                blockList.value = arrayList
                showError.value = true


            })


    }

    fun getBlockListString(blockNumber: String?, count: Int) {
        if (count >= 20) {
            blockList.value = arrayList
            return
        }
        blockListRepository.getBlockDetailsString(

            BlockRequest(
                blockNumber
            )
        )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                if (it.isSuccessful) {
                    it.body()
                    it.body()?.let {



                        var block = Gson().fromJson(it, Block::class.java)
                        block?.rawResponse = it
                        block?.let {
                            arrayList.add(block)
                            getBlockListString(block.previous, count + 1)
                        }

                    }
                } else {
                    blockList.value = arrayList
                    showError.value = true
                }
            }, {
                blockList.value = arrayList
                showError.value = true


            })


    }

}