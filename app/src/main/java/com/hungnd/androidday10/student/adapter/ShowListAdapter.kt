package com.hungnd.androidday10.student.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.hungnd.androidday10.R
import com.hungnd.androidday10.student.interfaceff.ItemsClick
import com.hungnd.androidday10.student.model.ShowListModel
import java.util.ArrayList

class ShowListAdapter(
    val dataList: ArrayList<ShowListModel>,
    val itemClick: ItemsClick,
    val itemLongClick: ItemsClick
) :
    RecyclerView.Adapter<ShowListAdapter.HungNDHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HungNDHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.items_rcv_show_list, parent, false)
        return HungNDHolder(
            view
        )
    }

    override fun onBindViewHolder(holder: HungNDHolder, position: Int) {
        val position = dataList[position]
        val subtext = position.tvShowName?.substring(0, 1)
        holder.tvAvatar.text = subtext
        holder.tvShowName.text = position.tvShowName
        holder.tvSubject.text = position.tvSubject
        holder.tvScore.text = position.tvScore
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    inner class HungNDHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener,View.OnLongClickListener {
        val tvAvatar = view.findViewById<TextView>(R.id.imv_avatar)
        val tvShowName = view.findViewById<TextView>(R.id.tv_Show_Name)
        val tvSubject = view.findViewById<TextView>(R.id.tv_Subject)
        val tvScore = view.findViewById<TextView>(R.id.tv_Score)

        init {
            view.setOnClickListener(this)
            view.setOnLongClickListener(this)
        }

        override fun onClick(p0: View?) {
            val positionClick = adapterPosition
            itemClick.onItemsClick(positionClick)

        }

        override fun onLongClick(p0: View?): Boolean {
            val positionLongClick = adapterPosition
            itemLongClick.onLongClickItems(positionLongClick)
            Log.e("hungND","long click")
            return false

        }
    }
}