package com.example.buildagridapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val stringResources : Int,
    val numberOfPic : Int,
    @DrawableRes val drawableRes: Int
)
