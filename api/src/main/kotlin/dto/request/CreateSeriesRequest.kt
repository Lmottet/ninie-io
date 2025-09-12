package com.lmo.ninie.io.dto.request

data class CreateSeriesRequest(
    val title: String,
    val authorId: Long,
    val isFinished: Boolean
)
