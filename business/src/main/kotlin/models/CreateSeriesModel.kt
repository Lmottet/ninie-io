package com.lmo.ninie.io.models

data class CreateSeriesModel(
    val title: String,
    val isFinished: Boolean,
    val authors: List<Long>
)
