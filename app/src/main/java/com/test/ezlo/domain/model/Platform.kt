package com.test.ezlo.domain.model

import androidx.annotation.DrawableRes
import com.test.ezlo.R

enum class Platform(val key: String, @DrawableRes val image: Int) {
    G450("Sercomm G450", R.drawable.vera_plus_big),
    G550("Sercomm G550", R.drawable.vera_secure_big),
    VeraLite("MiCasaVerde VeraLite", R.drawable.vera_edge_big),
    NA900("Sercomm NA900", R.drawable.vera_edge_big),
    NA301("Sercomm NA301", R.drawable.vera_edge_big),
    NA930("Sercomm NA930", R.drawable.vera_edge_big),
    DEFAULT("", R.drawable.vera_edge_big);

    companion object {
        fun getByKey(key: String): Platform {
            return Platform.values().firstOrNull { it.key == key } ?: DEFAULT
        }
    }
}