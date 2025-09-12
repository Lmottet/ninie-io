package com.lmo.ninie.io.models

data class CreateBookModel(
    val title: String,
    val tome: Int,
    val authors: List<Long>,
    val series: List<Long>
)
