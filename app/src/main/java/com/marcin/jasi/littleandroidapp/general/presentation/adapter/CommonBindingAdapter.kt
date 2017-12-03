package com.marcin.jasi.littleandroidapp.general.presentation.adapter

import android.databinding.BindingAdapter
import android.view.View
import android.widget.Button
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.marcin.jasi.littleandroidapp.R

class CommonBindingAdapter {

    companion object {

        @JvmStatic
        @BindingAdapter("imageUrl")
        fun setImageUrl(imageView: ImageView, url: String) {
            Glide.with(imageView)
                    .load(url)
                    .apply(RequestOptions().placeholder(R.drawable.ic_launcher_background))
                    .into(imageView)
        }

        @JvmStatic
        @BindingAdapter("onTouchListener")
        fun setOnTouchListener(view: View, listener: View.OnTouchListener) {
            view.setOnTouchListener(listener)
        }

        @JvmStatic
        @BindingAdapter("onClick")
        fun setOnTouchListener(view: View, listener: View.OnClickListener) {
            view.setOnClickListener(listener)
        }

        @JvmStatic
        @BindingAdapter("onClick")
        fun setOnTouchListener(view: Button, listener: View.OnClickListener) {
            view.setOnClickListener(listener)
        }

    }

}