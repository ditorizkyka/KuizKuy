package com.example.kuizkuy

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Question(
    val img: Int,
    val question: Array<String>,
    val answer1: Array<String>,
    val answer2: Array<String>,
    val answer3: Array<String>,
    val trueAnswer: Array<String>,
    var indicator: Int
) : Parcelable