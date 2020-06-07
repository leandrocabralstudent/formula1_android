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

    private val remoteServiceImpl: RaceService by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onResume() {
        super.onResume()
        /*remoteServiceImpl.getRace()
            .doOnSuccess {races->
                Log.i("teste",races.toString())
            }.doOnError {trowable->
                Log.i("teste",trowable.message)
            }.subscribeOn(Schedulers.io())
            .subscribe()*/

    }
}