package com.marcin.jasi.littleandroidapp.general.presentation.adapter

import android.databinding.BindingAdapter
import android.view.View
import android.widget.ImageView

class CommonBindingAdapter {

    companion object {

        @JvmStatic
        @BindingAdapter("imageUrl")
        fun setImageUrl(imageView: ImageView, url: String) {
//            Glide.with(imageView).load(url).into(imageView)
        }

        @JvmStatic
        @BindingAdapter("onTouchListener")
        fun setOnTouchListener(view: View, listener: View.OnTouchListener) {
            view.setOnTouchListener(listener)
        }

    }

}