package com.test.company.app

import android.app.Application
import com.test.company.di.AppDiProvider
import com.test.company.di.DaggerAppComponent
import com.test.company.feature.details.di.DetailsDiProvider
import com.test.company.feature.home.di.HomeDiProvider

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