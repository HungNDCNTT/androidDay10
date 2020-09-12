package com.hungnd.androidday10.readingbook.readingstory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.hungnd.androidday10.R
import com.hungnd.androidday10.readingbook.fragment.AccountFragment
import com.hungnd.androidday10.readingbook.fragment.HomeFragment
import com.hungnd.androidday10.readingbook.fragment.LibraryFragment
import com.hungnd.androidday10.readingbook.fragment.TypesFragment
import kotlinx.android.synthetic.main.activity_reading_story.*

class ReadingStoryActivity : AppCompatActivity(), View.OnClickListener {
    var fragment: Fragment? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reading_story)
        initView()
    }

    private fun initView() {
        linea_Home.setOnClickListener(this)
        linear_Types.setOnClickListener(this)
        linear_Library.setOnClickListener(this)
        linear_Account.setOnClickListener(this)
        fragment = HomeFragment()
        supportFragmentManager
            .beginTransaction().addToBackStack("")
            .replace(R.id.frame, HomeFragment())
            .commit()
    }

    override fun onClick(p0: View?) {
        val position = p0?.id
        when (position) {
            R.id.linea_Home -> {
                fragment = HomeFragment()
                supportFragmentManager
                    .beginTransaction().addToBackStack("")
                    .replace(R.id.frame, HomeFragment())
                    .commit()
            }
            R.id.linear_Types -> {
                fragment = TypesFragment()
                supportFragmentManager
                    .beginTransaction().addToBackStack("")
                    .replace(R.id.frame, TypesFragment())
                    .commit()
            }
            R.id.linear_Library -> {
                fragment = LibraryFragment()
                supportFragmentManager
                    .beginTransaction().addToBackStack("")
                    .replace(R.id.frame, LibraryFragment())
                    .commit()
            }
            R.id.linear_Account -> {
                fragment = AccountFragment()
                supportFragmentManager
                    .beginTransaction().addToBackStack("")
                    .replace(R.id.frame, AccountFragment())
                    .commit()
            }
        }
    }
}