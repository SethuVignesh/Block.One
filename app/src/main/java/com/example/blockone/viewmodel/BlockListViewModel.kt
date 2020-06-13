package com.example.blockone.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.blockone.model.BlockListRepository
import com.example.blockone.model.pojo.*
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
    var keys: MutableLiveData<ArrayList<AccountDetailsResponse.KeysItem>> =
        MutableLiveData<ArrayList<AccountDetailsResponse.KeysItem>>()

    fun getHeadBlock() {
        blockListRepository.getHeadBlockRepo().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                if (it != null) {
                    headBlock.value = it
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
                if (it != null) {

                    it?.let {
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

    fun getAccount(producer: String) {
        var keyList = ArrayList<AccountDetailsResponse.KeysItem>()
        blockListRepository.getAccountDetail(AccountRequest(producer)).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                if (it != null) {
                    it?.permissions?.let {
                        for (permissions in it) {
                            permissions?.requiredAuth?.keys?.let {
                                for (key in it) {
                                    key?.let { keyList.add(key) }

                                }
                            }
                        }
                    }
                    keys.value = keyList

                } else {
                }
            }, {
                showError.value = true
            })

    }

}