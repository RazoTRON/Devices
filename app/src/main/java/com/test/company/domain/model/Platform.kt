package com.test.company.domain.model

import androidx.annotation.DrawableRes
import com.test.company.R

enum class Platform(val key: String, @DrawableRes val image: Int) {
    COMPUTER("Computer", R.drawable.computer),
    NOTEBOOK("Notebook", R.drawable.notebook),
    MOBILE("Mobile", R.drawable.smartphone),
    DEFAULT("", R.drawable.computer);

    companion object {
        fun getByKey(key: String): Platform {
            return Platform.values().firstOrNull { it.key == key } ?: DEFAULT
        }
    }
}