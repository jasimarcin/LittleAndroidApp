package com.marcin.jasi.littleandroidapp.general.presentation.helper

import android.app.Dialog
import android.content.Context
import android.support.v7.app.AlertDialog
import android.view.LayoutInflater
import com.marcin.jasi.littleandroidapp.databinding.ProgressDialogLayoutBinding
import com.marcin.jasi.littleandroidapp.photosList.presentation.viewModel.ProgressDialogController


class DialogHelper(var context: Context) {

    fun showProgressBarDialog(controller: ProgressDialogController): Dialog {
        val dialogBuilder = AlertDialog.Builder(context)

        val binding = ProgressDialogLayoutBinding.inflate(LayoutInflater.from(context))
        binding.controller = controller

        dialogBuilder.setView(binding.root)

        return dialogBuilder.create()
    }

}