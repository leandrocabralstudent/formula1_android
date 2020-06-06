package com.leandroid.formula1

import com.leandroid.data.local.implementation.RaceRepositoryImpl
import org.koin.dsl.module

val dataModule = module {

    single { RaceRepositoryImpl(get()) }

}