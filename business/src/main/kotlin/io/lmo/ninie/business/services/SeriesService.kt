package io.lmo.ninie.business.services

import io.lmo.ninie.business.models.CreateSeriesModel
import io.lmo.ninie.business.models.SeriesModel
import io.lmo.ninie.business.models.toModel
import io.lmo.ninie.data.entities.Series
import io.lmo.ninie.data.repositories.AuthorRepository
import io.lmo.ninie.data.repositories.SeriesRepository
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