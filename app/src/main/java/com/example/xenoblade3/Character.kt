package com.example.xenoblade3

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Character(
    val name: String,
    val description: String,
    val gender: String,
    val faction: String,
    val role: String,
    val vaEn: String,
    val vaJp: String,
    val photo: Int
) : Parcelable
