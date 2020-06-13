package com.example.blockone.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.androidisland.vita.VitaOwner
import com.androidisland.vita.vita
import com.example.blockone.R
import com.example.blockone.model.pojo.Block
import com.example.blockone.viewmodel.BlockListViewModel
import kotlinx.android.synthetic.main.activity_block_detail.*
import kotlinx.android.synthetic.main.block_detail.*
import kotlinx.android.synthetic.main.block_detail.view.*

class blockDetailFragment : Fragment() {

    private var item: Block? = null
    val blockListViewModel: BlockListViewModel =
        vita.with(VitaOwner.None).getViewModel<BlockListViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            if (it.containsKey(ARG_ITEM_ID)) {
                item = it.getParcelable(ARG_ITEM_ID)
                activity?.toolbar_layout?.title = item?.producer
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.block_detail, container, false)
        item?.let {
            rootView.block_detail.text = it.blockNum.toString()
            rootView.trx_count.text = it?.transactions?.size.toString()
            rootView.signature.text = it.producerSignature
            rootView.json.text = it.rawResponse
            rootView.switcher.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    rootView.json.visibility = View.VISIBLE
                } else {
                    rootView.json.visibility = View.GONE

                }
            }

            blockListViewModel.getAccount(it.producer ?: "")
            blockListViewModel.keys.observe(viewLifecycleOwner, Observer {
                key_list.apply {
                    adapter = KeyListAdapter(it)
                    layoutManager = LinearLayoutManager(activity)
                }
            })
        }

        return rootView
    }

    override fun onResume() {
        super.onResume()

    }

    companion object {

        const val ARG_ITEM_ID = "item_id"
    }
}
