package com.edsondev26.horoscapp.ui.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class LuckyModel(
    // Make sure to get the correct format of data
    @DrawableRes val image:Int,
    @StringRes val text:Int
)