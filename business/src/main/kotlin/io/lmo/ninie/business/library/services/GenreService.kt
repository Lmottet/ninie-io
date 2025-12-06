package io.lmo.ninie.business.library.services

import io.lmo.ninie.business.library.models.create.CreateSeriesModel
import io.lmo.ninie.business.library.models.read.SeriesModel
import io.lmo.ninie.business.library.models.read.toModel
import io.lmo.ninie.data.entities.library.Series
import io.lmo.ninie.data.repositories.library.AuthorRepository
import io.lmo.ninie.data.repositories.library.SeriesRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class GenreService(
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