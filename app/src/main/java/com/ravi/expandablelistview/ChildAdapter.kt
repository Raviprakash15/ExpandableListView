package com.ravi.expandablelistview

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.keabis.expandablelistview.databinding.ItemChildBinding


class ChildAdapter(
    private var mContext: Context,
    private val data: List<LstSubHeader>,
    private val towerName: String,
    ) :
    RecyclerView.Adapter<ChildAdapter.ChildViewHolder>() {


    override
    fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildViewHolder {
        val v = ItemChildBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ChildAdapter.ChildViewHolder(v)

    }

    override
    fun onBindViewHolder(holder: ChildViewHolder, position: Int) {
        val item = data?.get(position)
        holder.itemBinding.txtFloor.text = item?.subHeader
        holder.itemBinding.txtTower.text = towerName
    }

    override
    fun getItemCount(): Int {
        return data?.size ?: 0
    }

    class ChildViewHolder(var itemBinding: ItemChildBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

    }


}