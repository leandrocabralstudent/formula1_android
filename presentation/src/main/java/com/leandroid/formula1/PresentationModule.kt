package com.leandroid.formula1


import com.leandroid.formula1.home.HomeViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module


val presentationModule = module {
    viewModel { HomeViewModel(androidApplication(),get()) }
}

