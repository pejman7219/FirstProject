package com.example.firstproject.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.firstproject.Fragment.FragmentClinic
import com.example.firstproject.Fragment.FragmentDocter
import com.example.firstproject.Fragment.FragmentFavorit

class AdapterViewPager(fragmentManager: FragmentManager):FragmentStatePagerAdapter(fragmentManager) {



    override fun getItem(position: Int): Fragment {
        when(position) {

            0 -> return FragmentDocter()
            1 -> return FragmentClinic()
            else -> return FragmentFavorit()



        }
    }

    override fun getCount(): Int {
        return 3
    }

}