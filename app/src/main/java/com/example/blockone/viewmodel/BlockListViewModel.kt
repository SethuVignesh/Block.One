package com.example.blockone.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.blockone.model.BlockListRepository
import com.example.blockone.model.pojo.Block
import com.example.blockone.model.pojo.BlockRequest
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers


class BlockListViewModel() : ViewModel() {

    val blockList: MutableLiveData<ArrayList<Block>> = MutableLiveData<ArrayList<Block>>()
    var blockListRepository: BlockListRepository =
        BlockListRepository()
    var showError: MutableLiveData<Boolean> = MutableLiveData<Boolean>()
    fun getHeadBlock() {
        blockListRepository.getCurrentData().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                if (it.isSuccessful) {
                    getBlockList(it.body()?.headBlockId)
                } else {
                }
            }, {
                showError.value = true
            })

    }

    fun getBlockList(blockNumber: String?) {
        getBlockList(blockNumber, 0)
        arrayList = ArrayList<Block>()
    }

    var arrayList: ArrayList<Block> = ArrayList()

    fun getBlockList(blockNumber: String?, count: Int) {
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
                    it.body()?.let {
                        arrayList.add(it)
                        getBlockList(it.previous, count + 1)
                    }
                } else {
                    showError.value = true
                }
            }, {
                showError.value = true

            })


    }

}