package com.marcin.jasi.littleandroidapp.main.presentation.viewPager


import android.app.Fragment
import android.app.FragmentManager
import android.support.v13.app.FragmentStatePagerAdapter


class MainActivityViewPager(fm: FragmentManager, var fragments: List<Fragment>) : FragmentStatePagerAdapter(fm) {

    override fun getItem(position: Int): Fragment = fragments[position]

    override fun getCount(): Int = fragments.size

}