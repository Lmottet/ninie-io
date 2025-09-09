package com.lmo.ninie.io.services

import com.lmo.ninie.io.data.entities.Series
import com.lmo.ninie.io.data.repositories.SeriesRepository
import com.lmo.ninie.io.dto.request.CreateSeriesRequest
import org.springframework.stereotype.Service

@Service
class SeriesService(private val seriesRepository: SeriesRepository) {

    fun list(): List<Series> = seriesRepository.findAll()

    fun create(request: CreateSeriesRequest): Series = seriesRepository.save(Series(title = request.title, isFinished = request.isFinished))
}