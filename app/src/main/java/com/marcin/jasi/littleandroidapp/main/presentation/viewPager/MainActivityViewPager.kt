package com.marcin.jasi.littleandroidapp.main.presentation.viewPager


import android.app.Fragment
import android.app.FragmentManager
import android.support.v13.app.FragmentStatePagerAdapter
import com.marcin.jasi.littleandroidapp.details.presentation.ui.DetailsFragment
import com.marcin.jasi.littleandroidapp.photosList.presentation.ui.PhotosListFragment


class MainActivityViewPager : FragmentStatePagerAdapter {

    val fragments : List<Fragment>

    constructor(fm: FragmentManager) : super(fm) {
        fragments = ArrayList()

        fragments.add(PhotosListFragment())
        fragments.add(DetailsFragment())
    }

    override fun getItem(position: Int): Fragment = fragments[position]

    override fun getCount(): Int = fragments.size

}