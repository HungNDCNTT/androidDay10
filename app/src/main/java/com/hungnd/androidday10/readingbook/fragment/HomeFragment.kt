package com.hungnd.androidday10.readingbook.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hungnd.androidday10.R
import com.hungnd.androidday10.readingbook.adapter.BookHomeAdapter
import com.hungnd.androidday10.readingbook.model.BookModel
import java.util.ArrayList

class HomeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val dataBook = ArrayList<BookModel>()
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        val recycleHome = view.findViewById<RecyclerView>(R.id.rcv_Book_Home)
        recycleHome.setHasFixedSize(true)
        recycleHome.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        val adapterBook = BookHomeAdapter(dataBook)
        recycleHome.adapter = adapterBook
        dataBook.add(BookModel(R.drawable.lee, "LeeSin Book", "Game", "19/2/2020"))
        dataBook.add(BookModel(R.drawable.lee, "LeeSin Book", "Game", "19/2/2020"))
        dataBook.add(BookModel(R.drawable.lee, "LeeSin Book", "Game", "19/2/2020"))
        dataBook.add(BookModel(R.drawable.lee, "LeeSin Book", "Game", "19/2/2020"))
        dataBook.add(BookModel(R.drawable.lee, "LeeSin Book", "Game", "19/2/2020"))
        dataBook.add(BookModel(R.drawable.lee, "LeeSin Book", "Game", "19/2/2020"))
        dataBook.add(BookModel(R.drawable.lee, "LeeSin Book", "Game", "19/2/2020"))
        dataBook.add(BookModel(R.drawable.lee, "LeeSin Book", "Game", "19/2/2020"))
        dataBook.add(BookModel(R.drawable.lee, "LeeSin Book", "Game", "19/2/2020"))
        dataBook.add(BookModel(R.drawable.lee, "LeeSin Book", "Game", "19/2/2020"))
        return view
    }


}