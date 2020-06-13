package com.example.blockone.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.blockone.R
import com.example.blockone.model.pojo.AccountDetailsResponse


class KeyListAdapter(val keyList: ArrayList<AccountDetailsResponse.KeysItem>) :
    RecyclerView.Adapter<KeyListAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KeyListAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.row_block_item, parent, false)
        return ViewHolder(v)
    }


    override fun onBindViewHolder(holder: KeyListAdapter.ViewHolder, position: Int) {
        holder.bindItems(keyList[position])
    }


    override fun getItemCount(): Int {
        return keyList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(key: AccountDetailsResponse.KeysItem) {
            val textViewName = itemView.findViewById(R.id.tvTitle) as TextView
            val textViewDetials = itemView.findViewById(R.id.tvDesc) as TextView
            textViewDetials.visibility = View.GONE

            textViewName.text = key.key

        }
    }
}