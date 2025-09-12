package com.lmo.ninie.io.controllers.admin

import com.lmo.ninie.io.dto.request.CreateSeriesRequest
import com.lmo.ninie.io.dto.response.SeriesResponse
import com.lmo.ninie.io.dto.response.toResponse
import com.lmo.ninie.io.services.SeriesService
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
    fun create(@RequestBody request: CreateSeriesRequest): SeriesResponse = seriesService.create(request).toResponse()
}