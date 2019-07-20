package com.example.firstproject.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.firstproject.Adapter.AdapterViewPager
import com.example.firstproject.R
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_view_pager.*
import kotlin.random.Random

class ActivityViewPager : AppCompatActivity() {
    lateinit var realm: Realm


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager)



        viewPager.adapter = AdapterViewPager(supportFragmentManager)




        bottomNavigation.setOnNavigationItemSelectedListener { item ->

            when(item.itemId)
            {
                R.id.navegation_doctor -> {
                    viewPager.setCurrentItem(0,true)
                }
                R.id.navigation_clinic -> {
                    viewPager.setCurrentItem(1,true)
                }
                R.id.navigation_favorit -> {
                    viewPager.setCurrentItem(2,true)
                }
             }
            true

        }
    }
}
