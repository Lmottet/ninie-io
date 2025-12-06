package io.lmo.ninie.api.controllers.admin.review

import io.lmo.ninie.api.dto.library.request.CreateAuthorReviewRequest
import io.lmo.ninie.api.dto.library.request.toModel
import io.lmo.ninie.api.dto.library.response.AuthorReviewResponse
import io.lmo.ninie.api.dto.library.response.toResponse
import io.lmo.ninie.business.review.services.AuthorReviewService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/author-reviews")
class AuthorReviewController(val authorReviewService: AuthorReviewService) {

    @GetMapping
    fun fetch(): Set<AuthorReviewResponse> = authorReviewService.list().map { it.toResponse() }.toSet()

    @GetMapping("/{id}")
    fun get(@PathVariable id: Long): AuthorReviewResponse = authorReviewService.get(id).toResponse()

    @PostMapping
    fun create(@RequestBody request: CreateAuthorReviewRequest): AuthorReviewResponse =
        authorReviewService.create(request.toModel()).toResponse()
}