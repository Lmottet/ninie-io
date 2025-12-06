package io.lmo.ninie.business.library.models.create

data class CreateBookModel(
    val title: String,
    val tome: Int,
    val authors: List<Long>,
    val series: List<Long>
)
