package io.lmo.ninie.api.controllers.admin.review

import io.lmo.ninie.api.dto.library.request.CreateSeriesReviewRequest
import io.lmo.ninie.api.dto.library.request.toModel
import io.lmo.ninie.api.dto.library.response.SeriesReviewResponse
import io.lmo.ninie.api.dto.library.response.toResponse
import io.lmo.ninie.api.dto.review.request.CreateAuthorRequest
import io.lmo.ninie.api.dto.review.request.toModel
import io.lmo.ninie.api.dto.review.response.AuthorResponse
import io.lmo.ninie.api.dto.review.response.toResponse
import io.lmo.ninie.business.review.services.SeriesReviewService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/series-reviews")
class SeriesReviewController(val seriesReviewService: SeriesReviewService) {

    @GetMapping
    fun fetch(): Set<SeriesReviewResponse> = seriesReviewService.list().map { it.toResponse() }.toSet()

    @GetMapping("/{id}")
    fun get(@PathVariable id: Long): SeriesReviewResponse = seriesReviewService.get(id).toResponse()

    @PostMapping
    fun create(@RequestBody request: CreateSeriesReviewRequest): SeriesReviewResponse =
        seriesReviewService.create(request.toModel()).toResponse()
}