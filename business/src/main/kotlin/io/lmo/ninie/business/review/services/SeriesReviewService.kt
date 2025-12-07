package io.lmo.ninie.business.review.services

import io.lmo.ninie.business.review.models.create.CreateSeriesReviewModel
import io.lmo.ninie.business.review.models.read.SeriesReviewModel
import io.lmo.ninie.business.review.models.read.toModel
import io.lmo.ninie.data.entities.review.SeriesReview
import io.lmo.ninie.data.repositories.library.SeriesRepository
import io.lmo.ninie.data.repositories.review.SeriesReviewRepository
import org.springframework.stereotype.Service

@Service
class SeriesReviewService(
    private val seriesReviewRepository: SeriesReviewRepository,
    private val seriesRepository: SeriesRepository
) {

    fun list(): List<SeriesReviewModel> = seriesReviewRepository.findAll().map { it.toModel() }.toList()
    fun get(id: Long): SeriesReviewModel = seriesReviewRepository.findById(id).map { it.toModel() }.orElseThrow()

    fun create(request: CreateSeriesReviewModel): SeriesReviewModel =
        seriesReviewRepository.save(
            SeriesReview(
                content = request.content,
                rating = request.rating,
                series = seriesRepository.getReferenceById(request.seriesId)
            )
        ).toModel()
}