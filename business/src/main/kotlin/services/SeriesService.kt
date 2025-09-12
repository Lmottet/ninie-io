package com.lmo.ninie.io.services

import com.lmo.ninie.io.data.entities.Series
import com.lmo.ninie.io.data.repositories.AuthorRepository
import com.lmo.ninie.io.data.repositories.SeriesRepository
import com.lmo.ninie.io.mappers.toModel
import com.lmo.ninie.io.models.CreateSeriesModel
import com.lmo.ninie.io.models.SeriesModel
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class SeriesService(
    private val seriesRepository: SeriesRepository,
    private val authorRepository: AuthorRepository
) {

    fun list(): List<SeriesModel> = seriesRepository.findAll().map { it.toModel() }
    fun get(id: Long): SeriesModel = seriesRepository.findById(id).map { it.toModel() }.orElseThrow()

    @Transactional
    fun create(request: CreateSeriesModel): SeriesModel {
        val series = Series(title = request.title, isFinished = request.isFinished)

        request.authors.forEach { series.addAuthor(authorRepository.getReferenceById(it)) }

        return seriesRepository.save(series).toModel()
    }
}