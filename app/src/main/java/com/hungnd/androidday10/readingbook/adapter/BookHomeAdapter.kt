package com.hungnd.androidday10.readingbook.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hungnd.androidday10.R
import com.hungnd.androidday10.readingbook.model.BookModel
import java.util.ArrayList

class BookHomeAdapter(val dataBookOk: ArrayList<BookModel>) :
    RecyclerView.Adapter<BookHomeAdapter.HungHoler>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HungHoler {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.items_recycleview_home, parent, false)
        return HungHoler(view)
    }

    override fun onBindViewHolder(holder: HungHoler, position: Int) {
        val positionData = dataBookOk[position]
        Glide
            .with(holder.imvAvatar)
            .load(dataBookOk[position]?.imvAvatar)
            .fitCenter()
            .placeholder(R.mipmap.ic_launcher)
            .into(holder.imvAvatar)
        holder.tvBookName.text = positionData.bookName
        holder.tvBookChapter.text = positionData.bookChapter
        holder.tvBookDate.text = positionData.bookDate
    }

    override fun getItemCount(): Int {
        return dataBookOk.size
    }

    inner class HungHoler(view: View) : RecyclerView.ViewHolder(view) {
        val imvAvatar = view.findViewById<ImageView>(R.id.imv_Book_Avatar)
        val tvBookName = view.findViewById<TextView>(R.id.tv_Book_Name)
        val tvBookChapter = view.findViewById<TextView>(R.id.tv_Book_Chapter)
        val tvBookDate = view.findViewById<TextView>(R.id.tv_Book_Date)
    }
}