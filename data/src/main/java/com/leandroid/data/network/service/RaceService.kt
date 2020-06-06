package com.leandroid.data.network.service

import com.leandroid.domain.model.Race
import io.reactivex.Maybe
import retrofit2.http.GET

interface RaceService {
    @GET("/race")
    fun load(): Maybe<Race>
}