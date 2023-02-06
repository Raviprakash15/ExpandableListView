package com.ravi.expandablelistview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.keabis.expandablelistview.R
import com.keabis.expandablelistview.databinding.ItemHeaderBinding


class HeaderAdapter(
    private var mContext: Context,
    private val items: List<LstHeaderModel>,
    private val listener: (LstHeaderModel, Int) -> Unit
) : RecyclerView.Adapter<HeaderAdapter.HeaderViewHolder>() {
    private var childAdapter: ChildAdapter? = null

    override
    fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeaderViewHolder {
        val v = ItemHeaderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HeaderAdapter.HeaderViewHolder(v)

    }

    override
    fun onBindViewHolder(holder: HeaderViewHolder, position: Int) {
        val item = items[position]
        holder.bindItem(items[position])
        holder.itemBinding.txtTower.setOnClickListener(View.OnClickListener {
            listener(item, holder.adapterPosition)

        })
        childAdapter = ChildAdapter(
            mContext,
            item.lstSubHeader,
            item.name.toString()
        )
        holder.itemBinding.listChild.adapter = childAdapter
        holder.itemBinding.listChild.layoutManager =
            LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false)
        val divider = DividerItemDecoration(
            mContext,
            (holder.itemBinding.listChild.layoutManager as LinearLayoutManager).orientation
        )
        divider.setDrawable(AppCompatResources.getDrawable(mContext, R.drawable.divider)!!)
        holder.itemBinding.listChild.addItemDecoration(divider)
        holder.itemBinding.layoutHeader.setOnClickListener { onItemClicked(item) }
        if (item.isExpanded) {
            holder.itemBinding.listChild.visibility = View.VISIBLE
            holder.itemBinding.imgArrow.setImageResource(R.drawable.ic_arrow_up)
        } else {
            holder.itemBinding.listChild.visibility = View.GONE
            holder.itemBinding.imgArrow.setImageResource(R.drawable.ic_arrow_down)
        }
    }

    override
    fun getItemCount(): Int {
        return items?.size ?: 0
    }

    private fun onItemClicked(lstHeaderModel: LstHeaderModel?) {
        lstHeaderModel?.isExpanded = !lstHeaderModel?.isExpanded!!
        notifyDataSetChanged()
    }

    class HeaderViewHolder(var itemBinding: ItemHeaderBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bindItem(item: LstHeaderModel) {
            itemBinding.txtTower.text = item?.name
            itemBinding.txtTowerCount.text = " -" + item?.lstSubHeader?.size + " Floors"


        }
    }


}