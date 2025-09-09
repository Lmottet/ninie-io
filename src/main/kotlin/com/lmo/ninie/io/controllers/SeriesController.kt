package com.lmo.ninie.io.controllers

import com.lmo.ninie.io.dto.response.SeriesResponse
import com.lmo.ninie.io.services.SeriesService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SeriesController(val seriesService: SeriesService) {

    @GetMapping("/")
    fun fetch(): Set<SeriesResponse> = seriesService.list().map { SeriesResponse(it.id, it.title, it.isFinished) }.toSet()
}