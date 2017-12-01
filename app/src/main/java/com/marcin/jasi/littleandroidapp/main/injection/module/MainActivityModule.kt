package com.marcin.jasi.littleandroidapp.main.injection.module

import android.app.Activity
import android.app.Fragment
import android.app.FragmentManager
import com.marcin.jasi.littleandroidapp.details.presentation.ui.DetailsFragment
import com.marcin.jasi.littleandroidapp.general.presentation.helper.Navigator
import com.marcin.jasi.littleandroidapp.main.presentation.viewPager.MainActivityViewPager
import com.marcin.jasi.littleandroidapp.photosList.presentation.ui.PhotosListFragment
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {

    @Provides
    fun provideNavigator(activity: Activity): Navigator {
        return Navigator(activity)
    }

    @Provides
    fun provideViewPager(fragments: List<Fragment>, fragmentManager: FragmentManager): MainActivityViewPager {
        return MainActivityViewPager(fragmentManager, fragments)
    }

    @Provides
    fun provideFragmentsList(detailsFragment: DetailsFragment, photosListFragment: PhotosListFragment): List<Fragment> {
        var fragments: ArrayList<Fragment> = ArrayList()
        
        fragments.add(detailsFragment)
        fragments.add(photosListFragment)

        return fragments
    }

}