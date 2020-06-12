package com.example.blockone.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.blockone.R
import com.example.blockone.model.pojo.Block
import com.example.blockone.viewmodel.BlockListViewModel
import java.util.*

class RecyclerViewAdapter(
    var list: ArrayList<Block>?, var viewModel: BlockListViewModel
) : RecyclerView.Adapter<RecyclerView.ViewHolder?>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return if (viewType == TYPE_DATA) {
            DataHolder(inflater.inflate(R.layout.block_list_content, parent, false))
        } else {
            ProgressHolder(inflater.inflate(R.layout.row_loading_item, parent, false))
        }
    }


    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        position: Int
    ) {
        if (holder is DataHolder) {
            holder.textTitle.text = list!![position].producer
            holder.textSubtitle.text = list!![position].id
        }
    }

    override fun getItemCount(): Int {
        return if (list == null) 0 else list!!.size
    }

    override fun getItemViewType(position: Int): Int {
        return if (list!![position].previous == "progress") {
            TYPE_PROGRESS
        } else {
            TYPE_DATA
        }
    }

    internal inner class DataHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var textTitle: TextView
        var textSubtitle: TextView

        init {
            textTitle = itemView.findViewById<View>(R.id.id_text) as TextView
            textSubtitle = itemView.findViewById<View>(R.id.content) as TextView
            itemView.setOnClickListener {
                viewModel.selectedBlock.value = list?.get(adapterPosition)

            }
        }
    }

    internal inner class ProgressHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView)

    companion object {
        const val TYPE_DATA = 0
        const val TYPE_PROGRESS = 1
    }


}