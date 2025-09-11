package com.lmo.ninie.io.services

import com.lmo.ninie.io.data.entities.Series
import com.lmo.ninie.io.data.repositories.AuthorRepository
import com.lmo.ninie.io.data.repositories.SeriesRepository
import com.lmo.ninie.io.dto.request.CreateSeriesRequest
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class SeriesService(
    private val seriesRepository: SeriesRepository,
    private val authorRepository: AuthorRepository
) {

    fun list(): List<Series> = seriesRepository.findAll()
    fun get(id: Long): Series = seriesRepository.findById(id).orElseThrow()
    fun getInfo(id: Long): Series = seriesRepository.findByIdWithInfo(id).orElseThrow()

    @Transactional
    fun create(request: CreateSeriesRequest): Series {
        val author = authorRepository.getReferenceById(request.authorId)
        val series = Series(title = request.title, isFinished = request.isFinished)

        series.addAuthor(author)

        return seriesRepository.save(series)
    }
}