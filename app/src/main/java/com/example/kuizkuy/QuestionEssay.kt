package com.example.kuizkuy

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class QuestionEssay(
    val img: Int,
    val question: Array<String>,
    val trueAnswer: Array<String>,
    var indicator: Int,
    var point: Int
) : Parcelable