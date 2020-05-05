package com.lingdtkhe.testapp

import android.app.Application
import com.lingdtkhe.data.di.DataModule
import com.lingdtkhe.domain.di.DomainModule
import com.lingdtkhe.testapp.di.PresentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class TestApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@TestApp)
            modules(
                PresentationModule,
                DomainModule,
                DataModule
            )
        }
    }
}