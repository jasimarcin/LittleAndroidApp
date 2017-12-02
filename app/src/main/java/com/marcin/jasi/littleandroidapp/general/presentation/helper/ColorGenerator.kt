package com.marcin.jasi.littleandroidapp.general.presentation.helper

import android.content.Context
import android.support.v4.content.ContextCompat


class ColorGenerator(private var context: Context) {


    fun getColor(id: Int): Int {
        return ContextCompat.getColor(context, id)
    }

}