package com.marcin.jasi.littleandroidapp.details.presentation.viewModel

import android.view.View
import com.marcin.jasi.littleandroidapp.details.domain.entity.Loading
import com.marcin.jasi.littleandroidapp.general.presentation.common.CommonViewModel
import com.marcin.jasi.littleandroidapp.general.presentation.helper.DialogHelper
import com.marcin.jasi.littleandroidapp.photosList.presentation.viewModel.ProgressDialogController

// todo inject dialogHelper and progressDialogController
class LoadingItemViewModel(var item: Loading, var dialogHelper: DialogHelper) : CommonViewModel {

    var progressDialogController: ProgressDialogController = ProgressDialogController()

    fun onButtonClick(): View.OnClickListener {
        return View.OnClickListener {
            progressDialogController.hideHeader()
            progressDialogController.hideButtons()

            val dialog = dialogHelper.showProgressBarDialog(progressDialogController)

            progressDialogController.callFinish.subscribe({ dialog.dismiss() })

            dialog.setOnDismissListener({ progressDialogController.onDispose() })
            dialog.show()

            progressDialogController.startAnimation()
        }
    }

}