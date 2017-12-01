package com.marcin.jasi.littleandroidapp.main.injection.module

import android.app.Fragment
import android.app.FragmentManager
import com.marcin.jasi.littleandroidapp.details.presentation.ui.DetailsFragment
import com.marcin.jasi.littleandroidapp.general.injection.annotation.PerActivity
import com.marcin.jasi.littleandroidapp.general.presentation.helper.Navigator
import com.marcin.jasi.littleandroidapp.main.presentation.ui.MainActivity
import com.marcin.jasi.littleandroidapp.main.presentation.viewPager.MainActivityViewPager
import com.marcin.jasi.littleandroidapp.photosList.presentation.ui.PhotosListFragment
import dagger.Module
import dagger.Provides

@Module
@PerActivity
class MainActivityModule {

    @Provides
    @PerActivity
    fun provideNavigator(activity: MainActivity): Navigator = Navigator(activity)

    @Provides
    @PerActivity
    fun provideFragmentManager(activity: MainActivity) = activity.fragmentManager

    @Provides
    @PerActivity
    fun provideViewPager(fragmentManager: FragmentManager): MainActivityViewPager {
        var fragments = ArrayList<Fragment>()

        fragments.add(PhotosListFragment())
        fragments.add(DetailsFragment())

       return  MainActivityViewPager(fragmentManager,fragments)
    }

}