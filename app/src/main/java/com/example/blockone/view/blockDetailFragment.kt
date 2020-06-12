package com.example.blockone.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.blockone.R
import com.example.blockone.model.pojo.Block
import com.example.blockone.dummy.DummyContent
import kotlinx.android.synthetic.main.activity_block_detail.*
import kotlinx.android.synthetic.main.block_detail.view.*

/**
 * A fragment representing a single block detail screen.
 * This fragment is either contained in a [blockListActivity]
 * in two-pane mode (on tablets) or a [blockDetailActivity]
 * on handsets.
 */
class blockDetailFragment : Fragment() {

    /**
     * The dummy content this fragment is presenting.
     */
    private var item: Block? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            if (it.containsKey(ARG_ITEM_ID)) {
                // Load the dummy content specified by the fragment
                // arguments. In a real-world scenario, use a Loader
                // to load content from a content provider.
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

        // Show the dummy content as text in a TextView.
        item?.let {
            rootView.block_detail.text = it.blockNum.toString()
        }

        return rootView
    }

    companion object {
        /**
         * The fragment argument representing the item ID that this fragment
         * represents.
         */
        const val ARG_ITEM_ID = "item_id"
    }
}
