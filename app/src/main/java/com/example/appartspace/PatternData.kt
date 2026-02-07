package com.example.appartspace



import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class PatternData(
    @DrawableRes val imageId: Int,
    @StringRes val titleId: Int,
    @StringRes val authorId: Int

)

