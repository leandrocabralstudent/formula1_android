package com.leandroid.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Pilot(
    @PrimaryKey val id: Int?,
    val name: String?,
    val flag: String?
)