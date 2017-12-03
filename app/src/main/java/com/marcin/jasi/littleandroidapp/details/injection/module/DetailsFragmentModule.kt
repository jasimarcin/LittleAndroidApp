package com.marcin.jasi.littleandroidapp.details.injection.module

import com.marcin.jasi.littleandroidapp.details.presentation.adapter.DetailsListAdapter
import com.marcin.jasi.littleandroidapp.details.presentation.ui.DetailsFragment
import com.marcin.jasi.littleandroidapp.general.injection.annotation.PerFragment
import com.marcin.jasi.littleandroidapp.general.presentation.helper.DialogHelper
import com.marcin.jasi.littleandroidapp.photosList.presentation.viewModel.ProgressDialogController
import dagger.Module
import dagger.Provides

@Module
@PerFragment
class DetailsFragmentModule {

    @Provides
    @PerFragment
    fun provideDetailsListAdapter() = DetailsListAdapter()

    @Provides
    @PerFragment
    fun provideProgressDialogController(): ProgressDialogController = ProgressDialogController()

    @Provides
    @PerFragment
    fun provideDialogHelper(fragment: DetailsFragment): DialogHelper = DialogHelper(fragment.activity)
}