package io.lmo.ninie.api.controllers.admin

import io.lmo.ninie.api.dto.request.CreateSeriesRequest
import io.lmo.ninie.api.dto.request.toModel
import io.lmo.ninie.api.dto.response.SeriesResponse
import io.lmo.ninie.api.dto.response.toResponse
import io.lmo.ninie.business.services.SeriesService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/series")
class SeriesController(val seriesService: SeriesService) {

    @GetMapping
    fun fetch(): Set<SeriesResponse> = seriesService.list().map { it.toResponse() }.toSet()

    @GetMapping("/{id}")
    fun getAuthor(@PathVariable id: Long): SeriesResponse = seriesService.get(id).toResponse()

    @PostMapping
    fun create(@RequestBody request: CreateSeriesRequest): SeriesResponse = seriesService.create(request.toModel()).toResponse()
}