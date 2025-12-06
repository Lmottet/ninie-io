package io.lmo.ninie.business.library.models.create

data class CreateSeriesModel(
    val title: String,
    val isFinished: Boolean,
    val authors: List<Long>
)
