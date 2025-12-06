package io.lmo.ninie.api.controllers.admin.review

import io.lmo.ninie.api.dto.library.request.CreateBookReviewRequest
import io.lmo.ninie.api.dto.library.request.toModel
import io.lmo.ninie.api.dto.library.response.BookReviewResponse
import io.lmo.ninie.api.dto.library.response.toResponse
import io.lmo.ninie.api.dto.review.request.CreateAuthorRequest
import io.lmo.ninie.api.dto.review.request.toModel
import io.lmo.ninie.api.dto.review.response.AuthorResponse
import io.lmo.ninie.api.dto.review.response.toResponse
import io.lmo.ninie.business.review.services.BookReviewService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/book-reviews")
class BookReviewController(val bookReviewService: BookReviewService) {

    @GetMapping
    fun fetch(): Set<BookReviewResponse> = bookReviewService.list().map { it.toResponse() }.toSet()

    @GetMapping("/{id}")
    fun get(@PathVariable id: Long): BookReviewResponse = bookReviewService.get(id).toResponse()

    @PostMapping
    fun create(@RequestBody request: CreateBookReviewRequest): BookReviewResponse =
        bookReviewService.create(request.toModel()).toResponse()
}