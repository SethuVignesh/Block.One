package com.example.blockone.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.androidisland.vita.VitaOwner
import com.androidisland.vita.vita
import com.example.blockone.R
import com.example.blockone.model.pojo.Block
import com.example.blockone.viewmodel.BlockListViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_block_list.*
import kotlinx.android.synthetic.main.block_list.*

class blockListActivity : AppCompatActivity() {


    private var twoPane: Boolean = false
    private var arrayList = ArrayList<Block>()
    val blockListViewModel: BlockListViewModel =
        vita.with(VitaOwner.None).getViewModel<BlockListViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_block_list)

        intent?.let {
            if (it.extras?.containsKey(BLOCKS) ?: false) {
                arrayList = it.getParcelableArrayListExtra<Block>(BLOCKS)
            }
        }
        arrayList = blockListViewModel.arrayList
        setSupportActionBar(toolbar)
        toolbar.title = title

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        if (block_detail_container != null) {

            twoPane = true
        }
        adapter =
            RecyclerViewAdapter(arrayList, blockListViewModel)

        block_list.adapter = adapter
        layoutManager = LinearLayoutManager(this)
        block_list.layoutManager = layoutManager

        if (arrayList.isEmpty()) blockListViewModel.getHeadBlock()
        blockListViewModel.headBlock.observe(this, Observer {
            blockListViewModel.getBlockList(it.headBlockId)
        })

        blockListViewModel.blockList.observe(this, Observer {
            arrayList.addAll(it)
            if (arrayList.size > 20)
                arrayList.removeAt(arrayList.size - 21)
            adapter.notifyItemRemoved(arrayList.size)
            adapter.notifyDataSetChanged()
            notLoading = true
            adapter.notifyDataSetChanged()
            notLoading = true
        })

        blockListViewModel.selectedBlock.observe(this, Observer {
            var intent = Intent(this, blockDetailActivity::class.java)
            intent.putExtra(blockDetailFragment.ARG_ITEM_ID, it)
            startActivity(intent)
        })

        addscrolllistener()
    }

    lateinit var adapter: RecyclerViewAdapter
    var notLoading = true
    lateinit var layoutManager: LinearLayoutManager
    private fun addscrolllistener() {
        block_list.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (notLoading && layoutManager.findLastCompletelyVisibleItemPosition() == arrayList.size - 1) {
                    arrayList.add(Block(previous = "progress"))
                    adapter.notifyItemInserted(arrayList.size - 1)
                    notLoading = false

                    blockListViewModel.getBlockList(arrayList.get(arrayList.lastIndex - 1).previous)
                }
            }
        })
    }

    companion object {

        const val BLOCKS = "blocks"
    }

}
