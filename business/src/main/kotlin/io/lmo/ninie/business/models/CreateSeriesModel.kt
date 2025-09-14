package io.lmo.ninie.business.models

data class CreateSeriesModel(
    val title: String,
    val isFinished: Boolean,
    val authors: List<Long>
)
