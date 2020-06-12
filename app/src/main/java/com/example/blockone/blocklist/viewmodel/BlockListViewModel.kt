package com.example.blockone.blocklist.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.blockone.blocklist.model.BlockListRepository
import com.example.blockone.blocklist.model.pojo.Block
import com.example.blockone.blocklist.model.pojo.BlockRequest
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers


class BlockListViewModel() : ViewModel() {
    val block: MutableLiveData<Block> = MutableLiveData<Block>()
    var blockListRepository: BlockListRepository = BlockListRepository()
    fun getHeadBlock() {
        blockListRepository.getCurrentData().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                if (it.isSuccessful) {
                    getBlockList(it.body()?.headBlockId)
                } else {
                }
            }, {

            })

    }

    fun getBlockList(blockNumber: String?) {
        getBlockList(blockNumber, 0)
    }

    fun getBlockList(blockNumber: String?, count: Int) {
        if (count > 20) return
        blockListRepository.getBlockDetails(BlockRequest(blockNumber))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                if (it.isSuccessful) {
                    it.body()?.let {
                        block.value = it
                        getBlockList(it.previous, count + 1)
                    }
                } else {
                    getBlockList(blockNumber, count + 1)
                    block.value = Block.mock()

                }
            }, {
                getBlockList(blockNumber, count + 1)
                block.value = Block.mock()
            })

    }
}