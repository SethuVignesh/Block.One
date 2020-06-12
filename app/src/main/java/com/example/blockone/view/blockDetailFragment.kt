package com.example.blockone.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.blockone.R
import com.example.blockone.model.pojo.Block
import kotlinx.android.synthetic.main.activity_block_detail.*
import kotlinx.android.synthetic.main.block_detail.view.*

class blockDetailFragment : Fragment() {

    private var item: Block? = null

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
        }

        return rootView
    }

    companion object {

        const val ARG_ITEM_ID = "item_id"
    }
}
