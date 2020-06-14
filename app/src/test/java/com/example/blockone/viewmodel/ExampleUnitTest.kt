package com.example.blockone.viewmodel

import com.example.blockone.BaseTest
import com.example.blockone.model.BlockListRepository
import com.example.blockone.model.pojo.Block
import com.example.blockone.model.pojo.EOSHeadBlockResponse
import io.reactivex.rxjava3.core.Single
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.times

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest : BaseTest() {

    @Mock
    lateinit var blockListRepository: BlockListRepository

    private lateinit var blockListViewModel: BlockListViewModel

    @Before
    fun setUp() {
        blockListViewModel = Mockito.spy(BlockListViewModel())
        Assert.assertNull(blockListViewModel.showError.value)
        Assert.assertNull(blockListViewModel.blockList.value)
        Assert.assertNull(blockListViewModel.selectedBlock.value)
//        Assert.assertNull(blockListViewModel.headBlock)
    }

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun testGetHeadBlock() {
        val eosHeadBlockResponse = EOSHeadBlockResponse.mock()

        val single = Single.just(eosHeadBlockResponse)

        Mockito.doReturn(single)
            .`when`(blockListRepository)
            .getHeadBlockRepo()

        blockListViewModel.getHeadBlock()

        Mockito.verify(blockListRepository).getHeadBlockRepo()
        Assert.assertEquals(blockListViewModel.showError.value, false)
        Assert.assertNull(blockListViewModel.selectedBlock.value)
    }

    @Test
    fun testGetHeadBlockException() {
        val exception = Exception("error")
        val single = Single.error<Block>(exception)
        Mockito.doReturn(single)
            .`when`(blockListViewModel)
            .getHeadBlock()
        single.test().assertNotComplete()
        single.test().assertFailure(Exception::class.java)

        blockListViewModel.getHeadBlock()
        Mockito.verify(blockListViewModel, times(0)).getHeadBlock()
    }

}
