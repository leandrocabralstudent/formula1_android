package com.leandroid.formula1

import android.app.Application
import org.koin.core.context.startKoin

class CommomApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        startKoin{
            modules(dataModule)
        }
    }
}