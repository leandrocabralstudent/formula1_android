package com.leandroid.formula1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.leandroid.data.network.race.RemoteRaceService
import com.leandroid.data.network.service.RaceService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

}