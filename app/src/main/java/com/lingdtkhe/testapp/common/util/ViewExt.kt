package com.lingdtkhe.testapp.common.util

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.lingdtkhe.testapp.R

/**
 * Extension loading image through Glide
 */
fun ImageView.loadImage(url: String) {
    transitionName = url
    /**
     * Loading image with Glide and set error image in case of error
     */
    Glide.with(context)
        .load(url)
        .apply(
            RequestOptions()
                .error(R.drawable.error_image)
        )
        .into(this)
}