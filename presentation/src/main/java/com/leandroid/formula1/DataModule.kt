package com.leandroid.formula1

import com.leandroid.data.network.implementation.RaceServiceImpl
import org.koin.dsl.module

val dataModule = module {

    single { RaceServiceImpl() }

}