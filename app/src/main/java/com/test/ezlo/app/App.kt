package com.test.ezlo.app

import android.app.Application
import com.test.ezlo.di.AppDiProvider
import com.test.ezlo.di.DaggerAppComponent
import com.test.ezlo.feature.details.di.DetailsDiProvider
import com.test.ezlo.feature.home.di.HomeDiProvider

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        initDi()
    }

    private fun initDi() {
        val appComponent = DaggerAppComponent
            .builder()
            .provideContext(this)
            .build()

        AppDiProvider.di = appComponent
        HomeDiProvider.di = appComponent
        DetailsDiProvider.di = appComponent
    }
}