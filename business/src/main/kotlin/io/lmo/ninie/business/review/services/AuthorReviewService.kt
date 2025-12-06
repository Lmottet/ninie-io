package io.lmo.ninie.business.review.services

import io.lmo.ninie.business.review.models.create.CreateAuthorReviewModel
import io.lmo.ninie.business.review.models.read.AuthorReviewModel
import io.lmo.ninie.business.review.models.read.toModel
import io.lmo.ninie.data.entities.review.AuthorReview
import io.lmo.ninie.data.repositories.library.AuthorRepository
import io.lmo.ninie.data.repositories.review.AuthorReviewRepository
import org.springframework.stereotype.Service

@Service
class AuthorReviewService(
    private val authorReviewRepository: AuthorReviewRepository,
    private val authorRepository: AuthorRepository
) {

    fun list(): List<AuthorReviewModel> = authorReviewRepository.findAll().map { it.toModel() }.toList()
    fun get(id: Long): AuthorReviewModel = authorReviewRepository.findById(id).map { it.toModel() }.orElseThrow()

    fun create(request: CreateAuthorReviewModel): AuthorReviewModel =
        authorReviewRepository.save(
            AuthorReview(
                content = request.content,
                rating = request.rating,
                author = authorRepository.getReferenceById(request.authorId)
            )
        ).toModel()
}